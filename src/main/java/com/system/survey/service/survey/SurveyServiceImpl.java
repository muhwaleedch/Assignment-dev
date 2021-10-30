package com.system.survey.service.survey;

import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.system.survey.config.ApplicationProperties;
import com.system.survey.dto.survey.*;
import com.system.survey.dto.user.UserDto;
import com.system.survey.enums.ActiveStatus;
import com.system.survey.enums.QuestionTypesEnum;
import com.system.survey.model.*;
import com.system.survey.repository.organization.OrganizationModuleHeadfootRepository;
import com.system.survey.repository.survey.*;
import com.system.survey.repository.sysparameter.SysParameterRepository;
import com.system.survey.service.utils.EmailService;
import com.system.survey.service.utils.ObjectTransformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements ISurveyService {

    private Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);

    @Autowired
    private IntSurveyRepository surveyRepository;

    @Autowired
    private IntFormRepository formRepository;

    @Autowired
    private IntQuestionRepository questionRepo;

    @Autowired
    private IntQuestionAnsweroptionRepository questionAnswerOptionRepo;

    @Autowired
    private IntQuestionTypeRepository questionTypeRepo;

    @Autowired
    private IntQuestionRepository questionRepository;

    @Autowired
    private IntQuestionUserReplyRepository questionUserReplyRepo;

    @Autowired
    private IntQuestionAttachTypeRepository questionAttachTypeRepo;

    @Autowired
    private IntQuestionAttachRepository questionAttachRepo;

    @Autowired
    private SysParameterRepository sysParameterRepository;

    @Autowired
    private IntFormJsonRepository intFormJsonRepository;

    @Autowired
    private IntQuestionSurveyFormRepository intQuestionSurveyFormRepo;

    @Autowired
    private IntQuestionFormQuestionRepository intQuestionFormQuestionRepo;

    @Autowired
    private OrganizationModuleHeadfootRepository organizationModuleHeadfootRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectTransformationService objTransformationService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<IntSurveyDto> findAllActiveSurveys() {
        List<IntSurveyDto> surveyDtos = objTransformationService.transformIntSurveyModelsToIntSurveyDtos(surveyRepository.findAllActiveSurveys());
        surveyDtos.forEach(surveyDto -> {
            surveyDto.setFormDtos(objTransformationService.transformIntFormModelsToIntFormDtos(formRepository.findIntFormByIntSurveyUuid(surveyDto.getIntSurveyUuid())));
        });
        return surveyDtos;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<IntFormDto> findIntFormsBySurveyUuid(String surveyUuid) {
        return objTransformationService.transformIntFormModelsToIntFormDtos(formRepository.findIntFormByIntSurveyUuid(surveyUuid));
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<IntQuestionsDto> findIntQuestionsByFormUuid(UserDto userDto, String formUuid) {
        List<IntQuestionsDto> questionsToReturn = new ArrayList<IntQuestionsDto>();
        List<IntQuestionsDto> questions = objTransformationService.transformIntQuestionModelsToDtos(questionRepo.findIntQuestionsByIntFormUuid(formUuid));
        List<IntQuestionsDto> subQuestions = new ArrayList<IntQuestionsDto>();
        questions.forEach(question -> {
            Optional<IntQuestionType> questionType = questionTypeRepo.findIntQuestionTypeByIntQuestionTypeUuid(question.getIntQuestionIntQuestionTypeuuid());
            question.setQuestionType(QuestionTypesEnum.text.name());
            if (questionType.isPresent()) {
                question.setQuestionType(questionType.get().getIntQuestionTypeName().toLowerCase());
                if (question.getQuestionType().equalsIgnoreCase(QuestionTypesEnum.parent_question.name())) {
                    List<IntQuestionsDto> subQuestionsList = objTransformationService.transformIntQuestionModelsToDtos(questionRepo.findIntQuestionsByIntQuestionParentUuid(question.getIntQuestionUuid()));
                    question.setSubQuestions(subQuestionsList);
                    subQuestions.addAll(subQuestionsList);
                }
            }
        });
        questionsToReturn.addAll(questions);
        questions.addAll(subQuestions);
        questions.forEach(question -> {
            List<IntQuestionsAnsweroptionDto> questionAnswerOpts = objTransformationService.transformIntQuestionAnswerModelToDto(questionAnswerOptionRepo.findQuestionAnserOptionsByQuestionUuid(question.getIntQuestionUuid()));
            question.setIntQuestionsAnswerOptionDtos(questionAnswerOpts);
            List<IntQuestionUserreplyDto> questionUserReplies = objTransformationService.transformIntQuestionUserreplyModelsToDtos(questionUserReplyRepo.findIntQuestionUserReplyByUserUuidAndQuestionUuid(userDto.getUserUuid(), question.getIntQuestionUuid()));
            question.setIntQuestionUserReplies(questionUserReplies);
            if (questionUserReplies.isEmpty()) {
                //As question's reply are empty there are two possibilites, user hasn't replied yet  or this question is of attachment type so search once for attachment.
                Optional<IntQuestionAttach> questionAttachOpt = questionAttachRepo.findQuestionAttachmentByQuestionUuidUserUuid(question.getIntQuestionUuid(), userDto.getUserUuid());
                if (questionAttachOpt.isPresent()) {
                    IntQuestionAttach questionAttach = questionAttachOpt.get();
                    Path fileDiskPath = Paths.get(questionAttach.getIntQuestionAttachServerpath());
                    if (Files.exists(fileDiskPath)) {
                        try {
                            byte[] readFileBytes = Files.readAllBytes(fileDiskPath);
                            String contentType = Files.probeContentType(fileDiskPath);
                            String fileName = questionAttach.getIntQuestionAttachOrgfilenamepath();
                            String base64String = Base64.getEncoder().encodeToString(readFileBytes);

                            IntQuestionAttachDto questionAttachDto = new IntQuestionAttachDto();
                            questionAttachDto.setIntQuestionAttachOrgfilenamepath(fileName);
                            questionAttachDto.setIntQuestionAttachContentType(contentType);
                            questionAttachDto.setIntQuestionAttachBase64String(base64String);
                            question.setIntQuestionAttachDto(questionAttachDto);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            logger.error("Error reading file for Survey Question: ", e);
                        }

                    }
                }
            }
            if (question.getQuestionType() == null) {
                Optional<IntQuestionType> questionType = questionTypeRepo.findIntQuestionTypeByIntQuestionTypeUuid(question.getIntQuestionIntQuestionTypeuuid());
                question.setQuestionType(QuestionTypesEnum.text.name());
                if (questionType.isPresent()) {
                    question.setQuestionType(questionType.get().getIntQuestionTypeName().toLowerCase());
                }
            }
        });

        return questionsToReturn;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addUpdateUserSurveyResponse(UserDto userDto, Map<String, Object> surveyResponses, String formUuid, String formName, String surveyUuid) throws Exception {

        List<IntQuestionUserreply> userReplyModels = new ArrayList<IntQuestionUserreply>();
        surveyResponses.forEach((questionUuid, reply) -> {
            Optional<IntQuestion> questionOpt = questionRepository.findIntQuestionByQuestionUuid(questionUuid);
            List<IntQuestionUserreply> userReplyModelsExisting = questionUserReplyRepo.findIntQuestionUserReplyByUserUuidAndQuestionUuid(userDto.getUserUuid(), questionUuid);
            userReplyModelsExisting.forEach(userReplyExistingModel -> {
                userReplyExistingModel.setActiveStatus(ActiveStatus.N);
                userReplyModels.add(userReplyExistingModel);
            });
            if (reply instanceof String) {
                userReplyModels.add(objTransformationService.transformReplyToIntQuestionUserReplyModel((String) reply, questionOpt.get(), userDto));
            } else if (reply instanceof List) {

                ((List<Object>) reply).forEach(replyOption -> {
                    if (replyOption instanceof String) {
                        userReplyModels.add(objTransformationService.transformReplyToIntQuestionUserReplyModel((String) replyOption, questionOpt.get(), userDto));
                    } else if (replyOption instanceof Map) {
                        try {
                            saveSurveyQuestionAttachment(userDto, questionOpt.get(), (Map<String, String>) replyOption);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            logger.error("Error saving user question attachment: ", e);
                        }
                    }
                });

            }
            IntQuestion currentQuestion = questionOpt.get();
            currentQuestion.setIntQuestionUsagestatus("Y");
            questionRepository.save(currentQuestion);
            if (currentQuestion.getIntQuestionParentUuid() != null && !"".equals(currentQuestion.getIntQuestionParentUuid())) {
                Optional<IntQuestion> parentQuestionOpt = questionRepository.findIntQuestionByQuestionUuid(currentQuestion.getIntQuestionParentUuid());
                if (parentQuestionOpt.isPresent()) {
                    IntQuestion parentQuestion = parentQuestionOpt.get();
                    parentQuestion.setIntQuestionUsagestatus("Y");
                    questionRepository.save(parentQuestion);
                }
            }
        });

        userReplyModels.forEach(userReply -> {
            try {
                questionUserReplyRepo.save(userReply);
            } catch (Exception e) {
                logger.error("Error saving user survey", e);
            }
        });

        saveFormJson(userDto, surveyResponses, formUuid, formName, surveyUuid);
        generatePdf(userDto, formUuid);
    }

    @Transactional(readOnly = false, propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void saveSurveyQuestionAttachment(UserDto userDto, IntQuestion question, Map<String, String> base64Data) throws Exception {
        try {
            Optional<IntQuestionAttachType> questionAttachType = questionAttachTypeRepo.findIntQuestionAttachTypeByIntQuestionAttachTypeName("userverification");
            Optional<SysParameter> sysParameterOptAttach = sysParameterRepository.findSysParameterBySysParameterName("attachments_dir");
            if (sysParameterOptAttach.isPresent() && questionAttachType.isPresent()) {
                String attachmentTypeUuid = questionAttachType.get().getIntQuestionAttachTypeUuid();
                Optional<IntQuestionAttach> questionAttachOpt = questionAttachRepo.findQuestionAttachmentByQuestionUuidUserUuid(question.getIntQuestionUuid(), userDto.getUserUuid());

                String fileDownloadPath = "";
                String saveToDirectory = sysParameterOptAttach.get().getSysParameterValue();
                Files.createDirectories(Paths.get(saveToDirectory));

                if (questionAttachOpt.isPresent()) {
                    IntQuestionAttach userAttach = questionAttachOpt.get();
                    //fileDownloadPath = userAttach.getUserAttachPath();
                    userAttach.setActiveStatus(ActiveStatus.N);
                    userAttach.setIntQuestionAttachUpdateStatus("Y");
                    userAttach.setIntQuestionAttachAdminverifyStatus("N");
                    userAttach = questionAttachRepo.save(userAttach);
                }
                String base64DataString = base64Data.get("content");
//				byte[] bytes = Base64.getEncoder().encode(base64DataString.substring(base64DataString.indexOf(",") + 1).getBytes("UTF-8"));
                byte[] bytes = Base64.getDecoder().decode(base64DataString.substring(base64DataString.indexOf(",") + 1).getBytes("UTF-8"));
                String fileNameUuid = UUID.randomUUID().toString();
                String orignalFileName = base64Data.get("name");
                // Code block to save attachment type
                fileNameUuid += "_" + orignalFileName;
                fileDownloadPath = saveToDirectory + File.separator + fileNameUuid;

                Path path = Paths.get(fileDownloadPath);
                Files.write(path, bytes);

                IntQuestionAttach userAttachNew = new IntQuestionAttach();
                userAttachNew.setIntQuestionAttachUuid(UUID.randomUUID().toString());
                userAttachNew.setIntQuestionUseruuid(userDto.getUserUuid());
                userAttachNew.setIntQuestionUserid(userDto.getUserUserId());
                userAttachNew.setIntQuestionAttachServerpath(fileDownloadPath);
                userAttachNew.setIntQuestionAttachTypeUuid(attachmentTypeUuid);
                userAttachNew.setIntQuestionAttachOrgfilenamepath(orignalFileName);
                userAttachNew.setActiveStatus(ActiveStatus.Y);
                userAttachNew.setIntQuestionAttachUpdateStatus("N");
                userAttachNew.setIntQuestionAttachAdminverifyStatus("N");
                userAttachNew.setIntQuestionAttachQuestionuuid(question.getIntQuestionUuid());
                userAttachNew.setIntQuestionAttachQuestionid(String.valueOf(question.getIntQuestionId()));
                if (Files.size(Paths.get(fileDownloadPath)) <= 64000) {
                    userAttachNew.setIntQuestionAttachBlob(bytes);
                }
                userAttachNew = questionAttachRepo.save(userAttachNew);


            } else {
                logger.warn("Missing configuration while saving Question Attachment. Either attachments_dir in sys_parameter table or userverification in int_question_attach_type is not defined");
            }
        } catch (Exception e) {
            logger.error("Error saving user question attachment", e);
            throw new Exception("Error saving user question attachment");
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void saveFormJson(UserDto userDto, Map<String, Object> surveyResponses, String formUuid, String formName, String surveyUuid) throws Exception {
        try {
            Optional<IntQuestionSurveyForm> surveyFormOpt = intQuestionSurveyFormRepo.findIntQuestionSurveyFormByFormUuidSurveyUuid(formUuid, surveyUuid);
            if (surveyFormOpt.isPresent()) {
                Optional<IntFormJson> formJsonOpt = intFormJsonRepository.findFormJsonByUserUuidFormUuidSurveyUuid(surveyUuid, formUuid, userDto.getUserUuid());
                int submitTimes = 0;
                if (formJsonOpt.isPresent()) {
                    IntFormJson existingFormJson = formJsonOpt.get();
                    existingFormJson.setActiveStatus(ActiveStatus.N);
                    submitTimes = Integer.valueOf(existingFormJson.getIntFormJsonSubmittimes());
                    intFormJsonRepository.save(existingFormJson);
                }

                IntFormJson newFormJson = new IntFormJson();
                newFormJson.setIntFormJsonUuid(UUID.randomUUID().toString());
                newFormJson.setIntFormJsonFormid(surveyFormOpt.get().getIntQuestionSurveyFormFormid());
                newFormJson.setIntFormJsonFormuuid(surveyFormOpt.get().getIntQuestionSurveyFormFormuuid());
                newFormJson.setIntFormJsonSurveyid(surveyFormOpt.get().getIntQuestionSurveyFormSurveyid());
                newFormJson.setIntFormJsonSurveyuuid(surveyFormOpt.get().getIntQuestionSurveyFormSurveyuuid());
                newFormJson.setIntFormJsonUseruuid(userDto.getUserUuid());
                Gson convertMapToJson = new Gson();
                String jsonString = convertMapToJson.toJson(surveyResponses);
                newFormJson.setIntFormJsonString(jsonString.getBytes());
                newFormJson.setIntFormJsonSubmittimes(String.valueOf(++submitTimes));
                newFormJson.setActiveStatus(ActiveStatus.Y);
                newFormJson.setIntFormJsonFormDefaultName(formName);
                intFormJsonRepository.save(newFormJson);
            }
        } catch (Exception e) {
            logger.error("Error saving Form Json", e);
            throw new Exception("Error saving Form Json");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public IntSurveyDto saveUpdateSurveyInformation(IntSurveyDto surveyDto) throws Exception {

        IntSurvey intSurvey = objTransformationService.transformIntSurveyDtoToIntSurveyModel(surveyDto);
        if (intSurvey.getIntSurveyUuid() != null && (intSurvey.getIntSurveyUuid().contains("_new") || intSurvey.getIntSurveyUuid().isEmpty())) {
            intSurvey.setIntSurveyUuid(UUID.randomUUID().toString());
        } else {
            Optional<IntSurvey> intSurveyOpt = surveyRepository.findIntSurveyBySurveyUuid(intSurvey.getIntSurveyUuid());
            if (intSurveyOpt.isPresent()) {
                IntSurvey intSurveyExist = intSurveyOpt.get();
                intSurveyExist.setIntSurveyName(intSurvey.getIntSurveyName());
                intSurveyExist.setIntSurveyShortdesc(intSurvey.getIntSurveyShortdesc());
                intSurveyExist.setIntSurveyDesc(intSurvey.getIntSurveyDesc());
                intSurvey = intSurveyExist;
            }
        }
        intSurvey.setActiveStatus(ActiveStatus.Y);
        intSurvey = surveyRepository.save(intSurvey);

        surveyDto = objTransformationService.transformIntSurveyModelToIntSurveyDto(intSurvey);
        return surveyDto;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteSurveyInformation(String surveyUuid) throws Exception {
        Optional<IntSurvey> intSurveyOpt = surveyRepository.findIntSurveyBySurveyUuid(surveyUuid);
        IntSurvey intSurvey = intSurveyOpt.orElseThrow(() -> new Exception("No Survey Found with Survey Uuid: " + surveyUuid));
        intSurvey.setActiveStatus(ActiveStatus.N);
        surveyRepository.save(intSurvey);

        List<IntQuestionSurveyForm> surveyForms = intQuestionSurveyFormRepo.findIntQuestionSurveyFormBySurveyUuid(surveyUuid);
        for (IntQuestionSurveyForm surveyForm : surveyForms) {
            surveyForm.setActiveStatus(ActiveStatus.N);
            intQuestionSurveyFormRepo.save(surveyForm);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteFormInformation(String formUuid) throws Exception {
        Optional<IntForm> intFormOpt = formRepository.findIntFormByIntFormUuid(formUuid);
        IntForm intForm = intFormOpt.orElseThrow(() -> new Exception("No Form Found with Form Uuid: " + formUuid));
        intForm.setActiveStatus(ActiveStatus.N);
        formRepository.save(intForm);

        List<IntQuestionSurveyForm> surveyForms = intQuestionSurveyFormRepo.findIntQuestionSurveyFormByFormUuid(formUuid);
        for (IntQuestionSurveyForm surveyForm : surveyForms) {
            surveyForm.setActiveStatus(ActiveStatus.N);
            intQuestionSurveyFormRepo.save(surveyForm);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Optional<IntFormJsonDto> findIntFormJsonByFormName(String formName, UserDto userDto) throws Exception {
        try {
            Optional<IntFormJsonDto> resultObj = Optional.empty();
            Optional<IntFormJson> intFormJsonOpt = intFormJsonRepository.findFormJsonByFormNameUserUuid(formName, userDto.getUserUuid());
            if (intFormJsonOpt.isPresent()) {
                resultObj = Optional.of(objTransformationService.transformIntFormJsonModelToDto(intFormJsonOpt.get()));
            }
            return resultObj;
        } catch (Exception e) {
            logger.error("Error finding Form Json by form name", e);
            throw new Exception("Error finding Form Json by form name");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public IntFormDto saveIntForm(IntFormDto intFormDto) throws Exception {
        try {
            IntFormDto returnDto = new IntFormDto();
            IntForm newForm = objTransformationService.transformIntFormDtoToModel(intFormDto);
            if (newForm.getIntFormUuid() != null && (newForm.getIntFormUuid().contains("_new") || newForm.getIntFormUuid().isEmpty())) {
                newForm.setIntFormUuid(UUID.randomUUID().toString());
            } else {
                Optional<IntForm> intFormExistingOpt = formRepository.findIntFormByIntFormUuid(newForm.getIntFormUuid());
                if (intFormExistingOpt.isPresent()) {
                    IntForm intFormExisting = intFormExistingOpt.get();
                    intFormExisting.setIntFormName(newForm.getIntFormName());
                    intFormExisting.setIntFormShortdesc(newForm.getIntFormShortdesc());
                    intFormExisting.setIntFormDesc(newForm.getIntFormDesc());
                    intFormExisting.setIntFormPageNoOfQuestions(newForm.getIntFormPageNoOfQuestions());
                    newForm = intFormExisting;
                }
            }
            newForm.setActiveStatus(ActiveStatus.Y);
            newForm = formRepository.save(newForm);
			/*int newFormId = newForm.getIntFormId();
			intQuestionSurveyFormRepo.updateIntQuestionSurveyFormToInActive(newForm.getIntFormUuid());
			for (String surveyUuid : intFormDto.getSurveyUuids()) {
				Optional<IntSurvey> surveyOpt = surveyRepository.findIntSurveyBySurveyUuid(surveyUuid);
				IntSurvey survey = surveyOpt.orElseThrow(() -> new Exception("Survey with Survey UUID : " + surveyUuid + " not exists. Unable to save form"));
				IntQuestionSurveyForm surveyForm = new IntQuestionSurveyForm();
				surveyForm.setIntQuestionSurveyFormUuid(UUID.randomUUID().toString());
				surveyForm.setActiveStatus(ActiveStatus.Y);
				surveyForm.setIntQuestionSurveyFormFormid(String.valueOf(newFormId));
				surveyForm.setIntQuestionSurveyFormFormuuid(newForm.getIntFormUuid());
				surveyForm.setIntQuestionSurveyFormSurveyid(String.valueOf(survey.getIntSurveyId()));
				surveyForm.setIntQuestionSurveyFormSurveyuuid(surveyUuid);
				intQuestionSurveyFormRepo.save(surveyForm);
			}*/
            returnDto = objTransformationService.transformIntFormModelToIntFormDto(newForm);
            return returnDto;
        } catch (Exception e) {
            logger.error("Error saving form details", e);
            throw new Exception("Error saving form details");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public IntQuestionsDto saveIntQuestion(IntQuestionsDto intQuestionsDto) {
        IntQuestionsDto returnQuestion = new IntQuestionsDto();
        IntQuestion newQuestion = objTransformationService.transformIntQuestionDtoToModel(intQuestionsDto);
        if ((newQuestion.getIntQuestionUuid() == null || newQuestion.getIntQuestionUuid().contains("_new") || newQuestion.getIntQuestionUuid().isEmpty())) {
            newQuestion.setIntQuestionUuid(UUID.randomUUID().toString());
        } else {
            Optional<IntQuestion> intQuestionOption = questionRepo.findIntQuestionByQuestionUuid(newQuestion.getIntQuestionUuid());
            if (intQuestionOption.isPresent()) {
                newQuestion = objTransformationService.transformIntQuestionDtoToModel(objTransformationService.transformIntQuestionModelToDto(intQuestionOption.get()));
                newQuestion.setCreatedDts(intQuestionOption.get().getCreatedDts());
                if ("Y".equals(newQuestion.getIntQuestionUsagestatus())) {
                    throw new IllegalStateException("This question cannot be updated as its been answered in a survey");
                }
            }
        }

        newQuestion.setActiveStatus(ActiveStatus.Y);
        newQuestion = questionRepo.save(newQuestion);

        if (intQuestionsDto.getFormsUuid() != null && !intQuestionsDto.getFormsUuid().isEmpty()) {
            intQuestionFormQuestionRepo.updateInActiveIntQuestionFormQuestionByQuestionUuid(newQuestion.getIntQuestionUuid());
            for (String formUuid : intQuestionsDto.getFormsUuid()) {
                Optional<IntForm> formOptional = formRepository.findIntFormByIntFormUuid(formUuid);
                if (formOptional.isPresent()) {
                    IntForm form = formOptional.get();
                    IntQuestionFormQuestion intQuestionFormQuestion = new IntQuestionFormQuestion();
                    intQuestionFormQuestion.setIntQuestionFormQuestionUuid(UUID.randomUUID().toString());
                    intQuestionFormQuestion.setIntQuestionFormQuestionFormid(String.valueOf(form.getIntFormId()));
                    intQuestionFormQuestion.setIntQuestionFormQuestionFormuuid(form.getIntFormUuid());
                    intQuestionFormQuestion.setIntQuestionFormQuestionQuestionid(String.valueOf(newQuestion.getIntQuestionId()));
                    intQuestionFormQuestion.setIntQuestionFormQuestionQuestionuuid(newQuestion.getIntQuestionUuid());
                    intQuestionFormQuestion.setActiveStatus(ActiveStatus.Y);
                    intQuestionFormQuestionRepo.save(intQuestionFormQuestion);
                }
            }
        }

        if (intQuestionsDto.getIntQuestionsAnswerOptionDtos() != null && !intQuestionsDto.getIntQuestionsAnswerOptionDtos().isEmpty()) {
            questionAnswerOptionRepo.updateInActiveQuestionAnswerOptoinsByQuestionUuid(newQuestion.getIntQuestionUuid());
            for (IntQuestionsAnsweroptionDto optionDto : intQuestionsDto.getIntQuestionsAnswerOptionDtos()) {
                IntQuestionAnsweroption questionAnswerOption = new IntQuestionAnsweroption();
                questionAnswerOption.setIntQuestionAnsweroptionUuid(UUID.randomUUID().toString());
                questionAnswerOption.setIntQuestionAnsweroptionIntQuestionId(String.valueOf(newQuestion.getIntQuestionId()));
                questionAnswerOption.setIntQuestionAnsweroptionIntQuestionUuid(newQuestion.getIntQuestionUuid());
                questionAnswerOption.setIntQuestionAnsweroptionAnswer(optionDto.getIntQuestionAnsweroptionAnswer());
                questionAnswerOption.setActiveStatus(ActiveStatus.Y);
                questionAnswerOptionRepo.save(questionAnswerOption);
            }
        }

        returnQuestion = objTransformationService.transformIntQuestionModelToDto(newQuestion);
        return returnQuestion;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteIntQuestion(String questionUuid) throws Exception {
        Optional<IntQuestion> intQuestionOption = questionRepo.findIntQuestionByQuestionUuid(questionUuid);
        if (intQuestionOption.isPresent()) {
            IntQuestion intQuestion = intQuestionOption.get();
            if ("Y".equals(intQuestion.getIntQuestionUsagestatus())) {
                throw new IllegalStateException("This question cannot be deleted as its been answered in a survey");
            }
            intQuestion.setActiveStatus(ActiveStatus.N);
            questionRepo.save(intQuestion);
            intQuestionFormQuestionRepo.updateInActiveIntQuestionFormQuestionByQuestionUuid(questionUuid);
            questionAnswerOptionRepo.updateInActiveQuestionAnswerOptoinsByQuestionUuid(questionUuid);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<IntFormDto> findAllActiveIntFormList() {
        List<IntFormDto> formDtos = objTransformationService.transformIntFormModelsToIntFormDtos(formRepository.findAllActiveIntForm());
        for (IntFormDto formDto : formDtos) {
            List<String> surveyUuids = intQuestionSurveyFormRepo.findIntQuestionSurveyFormByFormUuid(formDto.getIntFormUuid())
                    .stream()
                    .map(IntQuestionSurveyForm::getIntQuestionSurveyFormSurveyuuid)
                    .collect(Collectors.toList());
            formDto.setSurveyUuids(surveyUuids);
        }

        return formDtos;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<IntQuestionsDto> findAllActiveParentIntQuestionList() {
        return objTransformationService.transformIntQuestionModelsToDtos(questionRepo.findAllActiveParentIntQuestions());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<IntQuestionsDto> findAllActiveIntQuestionList() {
        List<IntQuestionsDto> questionsList = objTransformationService.transformIntQuestionModelsToDtos(questionRepo.findAllActiveIntQuestions());
        for (IntQuestionsDto question : questionsList) {
            List<IntQuestionFormQuestion> formQuestions = intQuestionFormQuestionRepo.findIntQuestionFromQuestionByQuestionUuid(question.getIntQuestionUuid());
            question.setFormsUuid(formQuestions.stream().map(IntQuestionFormQuestion::getIntQuestionFormQuestionFormuuid).collect(Collectors.toList()));
            question.setIntQuestionsAnswerOptionDtos(objTransformationService.transformIntQuestionAnswerModelToDto(questionAnswerOptionRepo.findQuestionAnserOptionsByQuestionUuid(question.getIntQuestionUuid())));
        }
        return questionsList;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<IntQuestionTypeDto> findAllActiveQuestionTypes() {
        return objTransformationService.transformIntQuestionTypeModelsToDtos(questionTypeRepo.findAllActiveQuestionTypes());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void generatePdf(UserDto userDto, String formUuid) throws Exception {
        List<IntQuestionsDto> formQuestions = findIntQuestionsByFormUuid(userDto, formUuid);
        Optional<SysParameter> sysParameterOptional = sysParameterRepository.findSysParameterBySysParameterName("temp_pdf_dir");
        if (sysParameterOptional.isPresent()) {
            String pdfTempDir = sysParameterOptional.get().getSysParameterValue();
            Path pdfTempDirPathObj = Paths.get(pdfTempDir);
            if (!Files.exists(pdfTempDirPathObj)) {
                Files.createDirectories(pdfTempDirPathObj);
            }


            int count = 1;
            float fntSize, lineSpacing;
            fntSize = 10f;
            lineSpacing = 16f;
            List<Paragraph> paragraphList = new ArrayList<Paragraph>();
            for (IntQuestionsDto questionDto : formQuestions) {
                String questionText = count + ". " + questionDto.getIntQuestionCompletequestion();
                paragraphList.add(new Paragraph(new Phrase(lineSpacing, questionText, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize))));
                if (questionDto.getSubQuestions() != null && !questionDto.getSubQuestions().isEmpty()) {
                    int subCount = 1;
                    for (IntQuestionsDto questionSubDto : questionDto.getSubQuestions()) {
                        String subCountStr = count + "." + subCount;
                        String subQuestionText = "\t \t " + subCountStr + ". " + questionSubDto.getIntQuestionCompletequestion();
                        paragraphList.add(new Paragraph(new Phrase(lineSpacing, subQuestionText, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize))));
                        for (IntQuestionUserreplyDto userReply : questionSubDto.getIntQuestionUserReplies()) {
                            StringBuilder pdfBody = new StringBuilder();
                            String userReplyStr = userReply.getIntQuestionUserreplyReply();
                            //pdfBody.append("\n");
                            pdfBody.append("\t \t \t \t " + userReplyStr);
                            paragraphList.add(new Paragraph(new Phrase(lineSpacing, pdfBody.toString(), FontFactory.getFont(FontFactory.COURIER, fntSize))));
                        }
                        subCount++;
                    }
                } else {
                    for (IntQuestionUserreplyDto userReply : questionDto.getIntQuestionUserReplies()) {
                        StringBuilder pdfBody = new StringBuilder();
                        String userReplyStr = userReply.getIntQuestionUserreplyReply();
                        //pdfBody.append("\n");
                        pdfBody.append("\t \t " + userReplyStr);
                        paragraphList.add(new Paragraph(new Phrase(lineSpacing, pdfBody.toString(), FontFactory.getFont(FontFactory.COURIER, fntSize))));
                    }
                }
                count++;
                paragraphList.add(new Paragraph("\n"));
                //pdfBody.append("\n");
                //pdfBody.append("\n");
            }

            Optional<OrganizationModuleHeadfoot> orgModuleOpt = organizationModuleHeadfootRepository.findOrganizationModuleHeadfootByOrgNameAndOutputType(applicationProperties.getDefaultSurveyOrgName(), "pdf");

            String nameLabel = userDto.getUserFirstName() + " " + userDto.getUserLastName();
            String currentDateLabel = new Date().toString();

            String fileName = pdfTempDir + File.separator + UUID.randomUUID().toString() + ".pdf";
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            Paragraph nameParagraphLabel = new Paragraph(new Phrase(lineSpacing, "Name: ", FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)));
            Paragraph dateParagraphLabel = new Paragraph(new Phrase(lineSpacing, "Date: ", FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)));
            Paragraph nameParagraph = new Paragraph(new Phrase(lineSpacing, nameLabel, FontFactory.getFont(FontFactory.COURIER, fntSize)));
            Paragraph dateParagraph = new Paragraph(new Phrase(lineSpacing, currentDateLabel, FontFactory.getFont(FontFactory.COURIER, fntSize)));

            if (orgModuleOpt.isPresent()) {
                Image header = Image.getInstance(orgModuleOpt.get().getOrganizationModuleHeadfootHeader());
                header.setAlignment(Image.ALIGN_MIDDLE);
                document.add(header);
            }
            document.add(nameParagraphLabel);
            document.add(nameParagraph);
            document.add(dateParagraphLabel);
            document.add(dateParagraph);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            for (Paragraph p : paragraphList) {
                document.add(p);
            }
            //document.add(p);
            if (orgModuleOpt.isPresent()) {
                Image footer = Image.getInstance(orgModuleOpt.get().getOrganizationModuleHeadfootFooter());
                footer.setAlignment(Image.ALIGN_MIDDLE);
                document.add(footer);
            }
            document.close();
            writer.close();

            emailService.sendEmail(userDto.getUserEmail(), fileName);
        } else {
            logger.error("temp_pdf_dir parameter not found in sys_parameter table.");
            throw new Exception("temp_pdf_dir parameter not found in sys_parameter table.");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveSurveyFormAssociation(String surveyUuid, List<String> formUuids) throws Exception {
        intQuestionSurveyFormRepo.updateIntQuestionSurveyFormToInActive(surveyUuid);

        for (String formUuid : formUuids) {
            Optional<IntForm> formOpt = formRepository.findIntFormByIntFormUuid(formUuid);
            Optional<IntSurvey> surveyOpt = surveyRepository.findIntSurveyBySurveyUuid(surveyUuid);
            IntForm form = formOpt.orElseThrow(() -> new Exception("Form with Form UUID : " + formUuid + " not exists. Unable to save survey-form association."));
            IntSurvey survey = surveyOpt.orElseThrow(() -> new Exception("Survey with Survey UUID : " + surveyUuid + " not exists. Unable to save form"));
            IntQuestionSurveyForm surveyForm = new IntQuestionSurveyForm();
            surveyForm.setIntQuestionSurveyFormUuid(UUID.randomUUID().toString());
            surveyForm.setActiveStatus(ActiveStatus.Y);
            surveyForm.setIntQuestionSurveyFormFormid(String.valueOf(form.getIntFormId()));
            surveyForm.setIntQuestionSurveyFormFormuuid(formUuid);
            surveyForm.setIntQuestionSurveyFormSurveyid(String.valueOf(survey.getIntSurveyId()));
            surveyForm.setIntQuestionSurveyFormSurveyuuid(surveyUuid);
            intQuestionSurveyFormRepo.save(surveyForm);
        }

    }
}
