/**
 *
 */

$(document).ready(function () {

  //$("#question-progress").hide();
  //$("#questions").show();
  //var formQuestionsComponent = new FormQuestionsComponent(new Date().getTime()+'_new', [ "45133d21-b7d5-429e-8eba-24188b50d576", "a41aa466-bb03-439f-a9f2-a7588bf773d3" ], '', '', '', 10);
  //formQuestionsComponent.render('#form-questions');
  fetchQuestionInformation();
  //var questionsComponent = new QuestionsComponent(new Date().getTime()+'_new', '', '', '', '', '');
  //questionsComponent.render("#questions");
});

function fetchQuestionInformation() {
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/activeQuestionsList',
    requestBody: '',
    serviceCallback: questionInformationCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)
}

function questionInformationCallback(response) {
  if (response.status !== 200) {
    $("#form-error-message").find("span").text(response.message);
  } else {
    $("#question-progress").hide();
    $("#questions").show();
    $("#form-add-bottom-div").show();
    var formQuestions = response.data.data;
    var rows = "";
    formQuestions.forEach(form => {
      var options = []
      if (form.intQuestionsAnswerOptionDtos !== null) {
        form.intQuestionsAnswerOptionDtos.forEach(option => {
          options.push(option.intQuestionAnsweroptionAnswer);
        });
      }


      rows += "<tr>";
      rows += "<td>" + form.intQuestionName + "</td>"
      rows += "<td>" + form.intQuestionCompletequestion + "</td>"
      rows += "<td>"
      rows += "<input type='hidden' value='" + form.intQuestionUuid + "' id='intQuestionUuid'/>"
      rows += "<input type='hidden' value='" + form.formsUuid + "' id='formsUuid'/>"
      rows += "<input type='hidden' value='" + form.intQuestionParentUuid + "' id='intQuestionParentUuid'/>"
      rows += "<input type='hidden' value='" + form.intQuestionIntQuestionTypeuuid + "' id='intQuestionIntQuestionTypeuuid'/>"
      rows += "<input type='hidden' value='" + form.intQuestionName + "' id='intQuestionName'/>"
      rows += "<input type='hidden' value='" + form.intQuestionCompletequestion + "' id='intQuestionCompletequestion'/>"
      rows += "<input type='hidden' value='" + form.intQuestionUsagestatus + "' id='intQuestionUsagestatus'/>"
      rows += "<input type='hidden' value='" + options + "' id='options'/>"
      rows += "<a id='form-edit-button' class='btn btn-primary' href='javascript:void(0);' onclick='javascript:editQuestion(this)'> Edit </a> &nbsp; "
      rows += "<a id='form-delete-button' class='btn btn-danger' href='javascript:void(0);' onclick='javascript:deleteQuestion(this)'> Delete </a>"
      rows += "<a id='form-delete-progress' class='btn btn-danger' href='javascript:void(0);' style='display: none;'> <i id='address-delete-progress' class='fas fa-sync fa-spin'></i></a>"
      rows += "</td>"
      rows += "</tr>"
      //var formQuestionsComponent = new FormQuestionsComponent(form.intFormUuid, form.surveyUuids, form.intFormName, form.intFormShortdesc, form.intFormDesc, form.intFormPageNoOfQuestions);
      //formQuestionsComponent.render('#form-questions');
    })
  }

  $("#questions").find("table").find("tbody").append(rows);
  $("#questions").find("table").DataTable();


}

function deleteQuestion(deleteButton) {
  var td = $(deleteButton).parent();
  var intQuestionUsagestatus = $(td).find("#intQuestionUsagestatus").val();
  if (intQuestionUsagestatus !== "" && intQuestionUsagestatus === "Y") {
    alert("This question cannot be deleted because it is already answered in a survey");
  } else {
    $(deleteButton).hide();
    $(td).find("#form-delete-progress").show();
    var intQuestionUuid = $(td).find("#intQuestionUuid").val();
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'survey/deleteQuestion?questionUuid=' + intQuestionUuid,
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
}

function editQuestion(editButton) {
  $("#new-form-questions").html("");
  var td = $(editButton).parent();
  var intQuestionUuid = $(td).find("#intQuestionUuid").val();
  var formsUuid = $(td).find("#formsUuid").val();
  var intQuestionParentUuid = $(td).find("#intQuestionParentUuid").val();
  var intQuestionIntQuestionTypeuuid = $(td).find("#intQuestionIntQuestionTypeuuid").val();
  var intQuestionName = $(td).find("#intQuestionName").val();
  var intQuestionCompletequestion = $(td).find("#intQuestionCompletequestion").val();
  var intQuestionUsagestatus = $(td).find("#intQuestionUsagestatus").val();
  var options = $(td).find("#options").val();
  if (intQuestionUsagestatus !== "" && intQuestionUsagestatus === "Y") {
    alert("This question cannot be edited because it is already answered in a survey");
  } else {
    var questionsComponent = new QuestionsComponent(intQuestionUuid, formsUuid.split(","), intQuestionParentUuid, intQuestionIntQuestionTypeuuid, intQuestionName, intQuestionCompletequestion, options.split(","));
    questionsComponent.render('#new-form-questions');
    $('#newForm').modal('show');
  }
}

function addNewQuestion() {
  $("#new-form-questions").html("");
  var questionsComponent = new QuestionsComponent(new Date().getTime() + '_new', [], '', '', '', '', []);
  questionsComponent.render("#new-form-questions");
  $('#newForm').modal('show');
}