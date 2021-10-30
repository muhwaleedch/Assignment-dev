/**
 *
 */

$(document).ready(function () {


  //var surveyQuestionsComponent = new SurveyQuestionsComponent(new Date().getTime()+'_new');
  //surveyQuestionsComponent.render('#survey-questions');
  fetchSurveyInformation();
});

function fetchSurveyInformation() {
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/activeSurveyList',
    requestBody: '',
    serviceCallback: surveyInformationCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)
}

function surveyInformationCallback(response) {
  if (response.status !== 200) {
    $("#survey-error-message").find("span").text(response.message);
  } else {
    $("#survey-progress").hide();
    $("#survey-questions").show();
    $("#survey-add-bottom-div").show();
    var surveyQuestions = response.data.data;
    var rows = "";
    surveyQuestions.forEach(question => {
      rows += "<tr>";
      rows += "<td>" + question.intSurveyName + "</td>"
      rows += "<td>"
      rows += "<input type='hidden' value='" + question.intSurveyUuid + "' id='intSurveyUuid'/>"
      rows += "<input type='hidden' value='" + question.intSurveyName + "' id='intSurveyName'/>"
      rows += "<input type='hidden' value='" + question.intSurveyShortdesc + "' id='intSurveyShortdesc'/>"
      rows += "<input type='hidden' value='" + question.intSurveyDesc + "' id='intSurveyDesc'/>"
      rows += "<a id='survey-edit-button' class='btn btn-primary' href='javascript:void(0);' onclick='javascript:editSurvey(this)'> Edit </a> &nbsp; "
      rows += "<a id='survey-addform-button' class='btn btn-primary' href='javascript:void(0);' onclick='javascript:attachForms(this)'> Attach Forms </a> &nbsp;"
      rows += "<a id='survey-delete-button' class='btn btn-danger' href='javascript:void(0);' onclick='javascript:deleteSurvey(this)'> Delete </a>"
      rows += "<a id='survey-delete-progress' class='btn btn-danger' href='javascript:void(0);' style='display: none;'> <i id='address-delete-progress' class='fas fa-sync fa-spin'></i></a>"
      rows += "</td>"
      rows += "</tr>"
      //var surveyQuestionsComponent = new SurveyQuestionsComponent(question.intSurveyUuid, question.intSurveyName, question.intSurveyShortdesc, question.intSurveyDesc);
      //surveyQuestionsComponent.render('#survey-questions');
    })

    $("#survey-questions").find("table").find("tbody").append(rows);
    $("#survey-questions").find("table").DataTable();
  }

}

function deleteSurvey(deleteButton) {
  var td = $(deleteButton).parent();
  $(deleteButton).hide();
  $(td).find("#survey-delete-progress").show();
  var surveyUuid = $(td).find("#intSurveyUuid").val();
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/deleteSurvey?surveyUuid=' + surveyUuid,
    requestBody: '',
    serviceCallback: function (response) {
      if (response.status !== 200) {
        alert(response.message);
      } else {
        $(td).parent().remove();
      }
    },
    jwt: jwtToken
  }
  RestClient.getInstance().get(request);
}

function editSurvey(editButton) {
  $("#new-survey-questions").html("");
  var td = $(editButton).parent();
  var surveyUuid = $(td).find("#intSurveyUuid").val();
  var surveyName = $(td).find("#intSurveyName").val();
  var surveyShortDesc = $(td).find("#intSurveyShortdesc").val();
  var surveyDesc = $(td).find("#intSurveyDesc").val();

  var surveyQuestionsComponent = new SurveyQuestionsComponent(surveyUuid, surveyName, surveyShortDesc, surveyDesc);
  surveyQuestionsComponent.render('#new-survey-questions');
  $('#newSurvey').modal('show');
}

function addNewSurvey() {
  $("#new-survey-questions").html("");
  var surveyQuestionsComponent = new SurveyQuestionsComponent(new Date().getTime() + '_new', '', '', '');
  surveyQuestionsComponent.render('#new-survey-questions');
  $('#newSurvey').modal('show');
}

function attachForms(attachFormButton) {
  $("#attachForm-body").html("");
  var td = $(attachFormButton).parent();
  var surveyUuid = $(td).find("#intSurveyUuid").val();
  var attachFormsComponent = new AttachFormsAndQuestions(surveyUuid, '', 'form');
  attachFormsComponent.render("#attachForm-body");
  $("#attachForm").modal('show');
}