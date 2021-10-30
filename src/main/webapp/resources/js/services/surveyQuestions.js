/**
 *
 */
var pageSize = 10;
var formUuid = "";
var formName = "";
var surveyUuid = "";
$(document).ready(function () {
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  pageSize = parseInt(urlParams.get('pageSize'));
  formUuid = urlParams.get('formId');
  formName = urlParams.get('formName');
  surveyUuid = urlParams.get('surveyId');
  setDefaultSurveyName();
  preFetchSurveyQuestions();
  //fetchSurveyQuestions();
});

function clearFormName() {
  $("#surveyQuestions").text("");
  $("#surveyName").text("");
  $("#surveyName").removeAttr("readonly");
}

function preFetchSurveyQuestions() {
  $("#survey-errors").find("span").text("");
  var surveyName = $("#surveyName").val().trim();
  if (surveyName === '') {
    setDefaultSurveyName();
  }
  $("#survey-questions-progress").show();
  $("#surveyQuestions").hide();
  //$("#surveyNameDiv").hide();
  $("#surveyQuestions").text("");
  surveyName = $("#surveyName").val().trim();
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/findFormJsonByFormName?formName=' + surveyName,
    requestBody: '',
    serviceCallback: function (response) {

      if (response.status === 200) {
        $("#survey-questions-progress").hide();
        $("#survey-errors").find("span").text("A form with same name already exists. Please choose unique name.");
      } else if (response.status === 404) {
        $("#surveyName").prop("readonly", true);
        fetchSurveyQuestions();
      } else {
        $("#survey-questions-progress").hide();
        $("#survey-errors").find("span").text(response.message);
      }
    },
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)
}

//############################# FETCH SURVEYS #########################################

function fetchSurveyQuestions() {
  if (formUuid !== "") {
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'survey/findQuestionsByFormUuid?formUuid=' + formUuid,
      requestBody: '',
      serviceCallback: surveyQuestionsDetailsCallback,
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
  }

}

function getQuestionEntry(question) {
  var questionEntry = {};
  if (question.questionType === "manychoice") {
    questionEntry.type = "checkbox"
  } else if (question.questionType === "onechoice") {
    questionEntry.type = "radiogroup"
  } else if (question.questionType === "file") {
    questionEntry.type = "file"
  } else if (question.questionType === "parent_question") {
    questionEntry.type = "panel"
  } else {
    questionEntry.type = "text"
  }

  questionEntry.name = question.intQuestionUuid;
  questionEntry.title = question.intQuestionCompletequestion;
  if (question.questionType !== 'parent_question') {
    questionEntry.isRequired = true;
    questionEntry.hasNone = true;
    questionEntry.colCount = 5;
    var choices = []
    question.intQuestionsAnswerOptionDtos.forEach(option => {
      choices.push(option.intQuestionAnsweroptionAnswer);
    });
    questionEntry.choices = choices;
  }
  return questionEntry;
}

function getQuestionReplies(questions) {
  var questionAnwers = {};
  questions.forEach(question => {
    var questionAnswersString = [];
    question.intQuestionUserReplies.forEach(answer => {
      questionAnswersString.push(answer.intQuestionUserreplyReply);
    })
    if (questionAnswersString.length >= 1) {
      if (questionAnswersString.length > 1) {
        questionAnwers[question.intQuestionUuid] = questionAnswersString;
      } else {
        questionAnwers[question.intQuestionUuid] = questionAnswersString[0];
      }
    } else {
      //Check for attachment
      if (question.intQuestionAttachDto !== null) {
        var contentType = question.intQuestionAttachDto.intQuestionAttachContentType;
        var base64DataString = 'data:' + contentType + ';base64,' + question.intQuestionAttachDto.intQuestionAttachBase64String;
        var fileName = question.intQuestionAttachDto.intQuestionAttachOrgfilenamepath;
        questionAnwers[question.intQuestionUuid] = {
          'name': fileName,
          'type': contentType,
          'content': base64DataString
        };
      }
    }

  });
  return questionAnwers;
}

function surveyQuestionsDetailsCallback(response) {
  $("#survey-questions-progress").hide();
  if (response.status !== 200) {
    $("#survey-errors").find("span").text(response.message);
  } else {
    $("#surveyQuestions").show();
    //$("#surveyNameDiv").show();

    Survey.StylesManager.applyTheme("modern");

    var surveyQuestions = response.data.data;
    var questionsArrayForSurveyJSjson = [];
    var allQuestionsArrayRecievedFromAPI = [];
    var pages = [];
    var pageNo = 1;
    surveyQuestions.forEach(question => {

      var questionEntry = getQuestionEntry(question);
      if (question.questionType === "parent_question") {
        if (question.subQuestions !== undefined && question.subQuestions !== null && question.subQuestions.length > 0) {
          var elements = [];
          question.subQuestions.forEach(subQuestion => {
            var subQuestionEntry = getQuestionEntry(subQuestion);
            subQuestionEntry.startWithNewLine = false;
            elements.push(subQuestionEntry);
            allQuestionsArrayRecievedFromAPI.push(subQuestion);
          })
          questionEntry.elements = elements;
        }
      } else {
        allQuestionsArrayRecievedFromAPI.push(question);
      }
      questionsArrayForSurveyJSjson.push(questionEntry);
      if (questionsArrayForSurveyJSjson.length === pageSize) {
        var page = {};
        page.name = "page" + pageNo;
        page.questions = questionsArrayForSurveyJSjson;
        pages.push(page);
        questionsArrayForSurveyJSjson = [];
        count = 0;
        pageNo++;
      }
    });

    if (questionsArrayForSurveyJSjson.length > 0) {
      var page = {};
      page.name = "page" + pageNo;
      page.questions = questionsArrayForSurveyJSjson;
      pages.push(page);
      questionsArrayForSurveyJSjson = [];
    }

    var json = {
      showQuestionNumbers: "off",
      "pages": pages
    };

    window.survey = new Survey.Model(json);

    survey.onComplete.add(function (result) {
      //console.log(result.data);
      //console.log("Result JSON:\n" + JSON.stringify(result.data, null, 3));
      const friendlyUsername = $("#surveyName").val();
      const value = result.data
      const jwtToken = JwtDAO.getInstance().getJWT();
      const request = {
        api: 'survey/saveUserSurvey?surveyUuid=' + surveyUuid + '&formUuid=' + formUuid + '&formName=' + friendlyUsername,
        requestBody: value,
        serviceCallback: function (response) {
          if (response.status !== 200) {
            $("#survey-errors").find("span").text(response.message);
          } else {
            $("#survey-success").find("span").text("Survey Response saved successfully");
          }
        },
        jwt: jwtToken
      }
      //console.log('Request json', request);
      RestClient.getInstance().post(request);

    });


    //console.log(questionAnwers);
    survey.data = getQuestionReplies(allQuestionsArrayRecievedFromAPI);

    $("#surveyQuestions").Survey({model: survey});
  }
}

function setDefaultSurveyName() {
  const jwtToken = JwtDAO.getInstance().getJWT();
  var username = parseJwt(jwtToken);
  var today = new Date();
  var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
  var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();

  var dateTime = date + ' ' + time;

  var surveyName = formName + "-" + username.sub + '_' + dateTime;
  $("#surveyName").val(surveyName);
}