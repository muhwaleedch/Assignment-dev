package com.system.survey.controller.rest;

import com.system.survey.dto.Response;
import com.system.survey.dto.authentication.UserPrincipal;
import com.system.survey.dto.survey.IntFormDto;
import com.system.survey.dto.survey.IntFormJsonDto;
import com.system.survey.dto.survey.IntQuestionsDto;
import com.system.survey.dto.survey.IntSurveyDto;
import com.system.survey.exception.ExceptionUtil;
import com.system.survey.service.survey.ISurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/survey")
public class SurveyRestController {

    private Logger logger = LoggerFactory.getLogger(SurveyRestController.class);

    @Autowired
    private ISurveyService surveyService;

    @RequestMapping(value = "/saveUpdateSurvey", method = RequestMethod.POST)
    public ResponseEntity<?> saveUpdateSurvey(@RequestBody IntSurveyDto intSurveyDto) {
        try {
            return new ResponseEntity<>(new Response("SUCCESS", "Survey Saved/Updated successfully ", surveyService.saveUpdateSurveyInformation(intSurveyDto)), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while saving/updating survey ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteSurvey", method = RequestMethod.GET)
    public ResponseEntity<?> deleteSurvey(@RequestParam String surveyUuid) {
        try {
            surveyService.deleteSurveyInformation(surveyUuid);
            return new ResponseEntity<>(new Response("SUCCESS", "Survey Deleted successfully "), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleting survey ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
    public ResponseEntity<?> deleteForm(@RequestParam String formUuid) {
        try {
            surveyService.deleteFormInformation(formUuid);
            return new ResponseEntity<>(new Response("SUCCESS", "Form Deleted successfully "), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleting form ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
    public ResponseEntity<?> deleteQuestion(@RequestParam String questionUuid) {
        try {
            surveyService.deleteIntQuestion(questionUuid);
            return new ResponseEntity<>(new Response("SUCCESS", "Question Deleted successfully "), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleting question ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/activeSurveyList", method = RequestMethod.GET)
    public ResponseEntity<?> activeSurveyList() {
        try {
            return new ResponseEntity<>(new Response("SUCCESS", "Active survey list found successfully ", surveyService.findAllActiveSurveys()), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while fetching active survey list ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findFormBySurveyUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findFormBySurveyUuid(@RequestParam String surveyUuid) {
        try {
            return new ResponseEntity<>(new Response("SUCCESS", "Active survey list found successfully ", surveyService.findIntFormsBySurveyUuid(surveyUuid)), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding form by surveyuuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findQuestionsByFormUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findQuestionsByFormUuid(@RequestParam String formUuid) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new ResponseEntity<>(new Response("SUCCESS", "Active questions list found successfully ", surveyService.findIntQuestionsByFormUuid(userPrincipal.getUserDto(), formUuid)), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding questions by form uuids ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/generateQuestionsPDFByFormUuid", method = RequestMethod.GET)
    public ResponseEntity<?> generateQuestionsByFormUuid(@RequestParam String formUuid) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            surveyService.generatePdf(userPrincipal.getUserDto(), formUuid);
            return new ResponseEntity<>(new Response("SUCCESS", "Successfully generated PDF for formUUID: " + formUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while generating PDF for formUuid" + formUuid, ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveUserSurvey", method = RequestMethod.POST)
    public ResponseEntity<?> saveUserSurvey(@RequestBody Map<String, Object> surveyObject, @RequestParam String formUuid, @RequestParam String formName, @RequestParam String surveyUuid) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            surveyService.addUpdateUserSurveyResponse(userPrincipal.getUserDto(), surveyObject, formUuid, formName, surveyUuid);
            return new ResponseEntity<>(new Response("SUCCESS", "Survey results saved successfully"), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while saving user survey ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveForm", method = RequestMethod.POST)
    public ResponseEntity<?> saveForm(@RequestBody IntFormDto intFormDto) {
        try {

            return new ResponseEntity<>(new Response("SUCCESS", "Form Saved/Updated successfully ", surveyService.saveIntForm(intFormDto)), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while creating form ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
    public ResponseEntity<?> saveQuestion(@RequestBody IntQuestionsDto intQuestionDto) {
        try {

            return new ResponseEntity<>(new Response("SUCCESS", "Question Saved/Updated successfully ", surveyService.saveIntQuestion(intQuestionDto)), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while create questions ", ex);
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findFormJsonByFormName", method = RequestMethod.GET)
    public ResponseEntity<?> findFormJsonByFormName(@RequestParam String formName) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<IntFormJsonDto> formJsonDtoOpt = surveyService.findIntFormJsonByFormName(formName, userPrincipal.getUserDto());
            if (formJsonDtoOpt.isPresent()) {
                return new ResponseEntity<>(new Response("SUCCESS", "Form json found successfully", formJsonDtoOpt.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Response("NOT FOUND", "No Form Json found with Form Name : " + formName), HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while finding from json by form name ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/activeFormList", method = RequestMethod.GET)
    public ResponseEntity<?> activeFormList() {
        try {
            return new ResponseEntity<>(new Response("SUCCESS", "Active form list found successfully ", surveyService.findAllActiveIntFormList()), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding active from list ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/activeParentQuestionsList", method = RequestMethod.GET)
    public ResponseEntity<?> activeParentQuestionsList() {
        try {
            return new ResponseEntity<>(new Response("SUCCESS", "Active Parent questions list found successfully ", surveyService.findAllActiveParentIntQuestionList()), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding active parent questions list ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/activeQuestionsList", method = RequestMethod.GET)
    public ResponseEntity<?> activeQuestionsList() {
        try {
            return new ResponseEntity<>(new Response("SUCCESS", "Active questions list found successfully ", surveyService.findAllActiveIntQuestionList()), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding active questions list ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/activeQuestionTypes", method = RequestMethod.GET)
    public ResponseEntity<?> activeQuestionTypes() {
        try {
            return new ResponseEntity<>(new Response("SUCCESS", "Active questions type list found successfully ", surveyService.findAllActiveQuestionTypes()), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding active question types ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveSurveyFormAttachment", method = RequestMethod.POST)
    public ResponseEntity<?> saveSurveyFormAttachment(String surveyUuid, @RequestBody List<String> uuidsToAssociate) {
        try {
            surveyService.saveSurveyFormAssociation(surveyUuid, uuidsToAssociate);
            return new ResponseEntity<>(new Response("SUCCESS", "survey-form association saved successfully "), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while saving survey-form association ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
