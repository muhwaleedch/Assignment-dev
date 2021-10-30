/**
 *
 */

$(document).ready(function () {
  fetchSurveys();
});

//################## FETCH SURVEYS ##########################################
function fetchSurveys() {
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/activeSurveyList',
    requestBody: '',
    serviceCallback: surveyDetailsCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)
}

function surveyDetailsCallback(response) {
  $("#survey-progress").hide();
  if (response.status !== 200) {
    $("#survey-errors").find("span").text(response.message);
  } else {
    $("#surveyForm").show();
    var questions = response.data.data;
    var liElements = "";
    questions.forEach(element => {
      liElements += "<li>" + element.intSurveyName + "<ul>";
      element.formDtos.forEach(formElement => {
        liElements += "<li><a href='/views/survey/surveyQuestions.jsp?surveyId=" + element.intSurveyUuid + "&formName=" + formElement.intFormName + "&formId=" + formElement.intFormUuid + "&pageSize=" + formElement.intFormPageNoOfQuestions + "'>" + formElement.intFormName + "</a></li>"
      })
      liElements += "</ul></li>"

    });
    $("#surveys").html(liElements);
  }
}

//################################## FETCH FORMS ####################################
function fetchForms(surveyElement) {
  var surveyUuid = $(surveyElement).val();
  if (surveyUuid !== "") {
    $("#forms").attr("disabled", "true");
    $("#forms").text("");
    $("#surveyQuestions").text("");
    $("#forms").append($('<option>', {
      value: '',
      text: 'Select Form'
    }));
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'survey/findFormBySurveyUuid?surveyUuid=' + surveyUuid,
      requestBody: '',
      serviceCallback: formsDetailsCallback,
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
  }
}

function formsDetailsCallback(response) {
  $("#forms").removeAttr("disabled");
  if (response.status !== 200) {
    $("#survey-errors").find("span").text(response.message);
  } else {
    var forms = response.data.data;
    forms.forEach(element => {
      $("#forms").append($('<option>', {
        value: element.intFormUuid,
        text: element.intFormName
      }));
    });
  }
}

//############################# FETCH SURVEYS #########################################

function fetchSurveyQuestions(formElement) {
  var formUuid = $(formElement).val();
  if (formUuid !== "") {
    $("#survey-questions-progress").show();
    $("#surveyQuestions").hide();
    $("#surveyQuestions").text("");
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

function surveyQuestionsDetailsCallback(response) {
  $("#survey-questions-progress").hide();
  $("#surveyQuestions").show();
  if (response.status !== 200) {
    $("#survey-errors").find("span").text(response.message);
  } else {
    Survey.StylesManager.applyTheme("modern");

    var surveyQuestions = response.data.data;
    var questionsArray = [];
    surveyQuestions.forEach(question => {
      var questionEntry = {};
      if (question.questionType === "manychoice") {
        questionEntry.type = "checkbox"
      } else if (question.questionType === "onechoice") {
        questionEntry.type = "radiogroup"
      } else {
        questionEntry.type = "text"
      }

      questionEntry.name = question.intQuestionUuid;
      questionEntry.title = question.intQuestionCompletequestion;
      questionEntry.isRequired = true;
      questionEntry.hasNone = true;
      questionEntry.colCount = 5;
      var choices = []
      question.intQuestionsAnswerOptionDtos.forEach(option => {
        choices.push(option.intQuestionAnsweroptionAnswer);
      });
      questionEntry.choices = choices;
      questionsArray.push(questionEntry);
    });

    var json = {
      questions: questionsArray
    };

    window.survey = new Survey.Model(json);

    survey
        .onComplete
        .add(function (result) {
          console.log("Result JSON:\n" + JSON.stringify(result.data, null, 3));
        });

    $("#surveyQuestions").Survey({model: survey});
  }
}