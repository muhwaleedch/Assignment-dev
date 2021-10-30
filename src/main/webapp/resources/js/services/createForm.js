/**
 *
 */

$(document).ready(function () {

  //$("#form-progress").hide();
  //$("#form-questions").show();
  //var formQuestionsComponent = new FormQuestionsComponent(new Date().getTime()+'_new', [ "45133d21-b7d5-429e-8eba-24188b50d576", "a41aa466-bb03-439f-a9f2-a7588bf773d3" ], '', '', '', 10);
  //formQuestionsComponent.render('#form-questions');
  fetchFormInformation();
});

function fetchFormInformation() {
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/activeFormList',
    requestBody: '',
    serviceCallback: formInformationCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)
}

function formInformationCallback(response) {
  if (response.status !== 200) {
    $("#form-error-message").find("span").text(response.message);
  } else {
    $("#form-progress").hide();
    $("#form-questions").show();
    $("#form-add-bottom-div").show();
    var formQuestions = response.data.data;
    var rows = "";
    formQuestions.forEach(form => {
      rows += "<tr>";
      rows += "<td>" + form.intFormName + "</td>"
      rows += "<td>"
      rows += "<input type='hidden' value='" + form.intFormUuid + "' id='intFormUuid'/>"
      rows += "<input type='hidden' value='" + form.surveyUuids + "' id='surveyUuids'/>"
      rows += "<input type='hidden' value='" + form.intFormName + "' id='intFormName'/>"
      rows += "<input type='hidden' value='" + form.intFormShortdesc + "' id='intFormShortdesc'/>"
      rows += "<input type='hidden' value='" + form.intFormDesc + "' id='intFormDesc'/>"
      rows += "<input type='hidden' value='" + form.intFormPageNoOfQuestions + "' id='intFormPageNoOfQuestions'/>"
      rows += "<a id='form-edit-button' class='btn btn-primary' href='javascript:void(0);' onclick='javascript:editForm(this)'> Edit </a> &nbsp; "
      rows += "<a id='form-delete-button' class='btn btn-danger' href='javascript:void(0);' onclick='javascript:deleteForm(this)'> Delete </a>"
      rows += "<a id='form-delete-progress' class='btn btn-danger' href='javascript:void(0);' style='display: none;'> <i id='address-delete-progress' class='fas fa-sync fa-spin'></i></a>"
      rows += "</td>"
      rows += "</tr>"
      //var formQuestionsComponent = new FormQuestionsComponent(form.intFormUuid, form.surveyUuids, form.intFormName, form.intFormShortdesc, form.intFormDesc, form.intFormPageNoOfQuestions);
      //formQuestionsComponent.render('#form-questions');
    })
  }

  $("#form-questions").find("table").find("tbody").append(rows);
  $("#form-questions").find("table").DataTable();


}

function deleteForm(deleteButton) {
  var td = $(deleteButton).parent();
  $(deleteButton).hide();
  $(td).find("#form-delete-progress").show();
  var intFormUuid = $(td).find("#intFormUuid").val();
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/deleteForm?formUuid=' + intFormUuid,
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

function editForm(editButton) {
  $("#new-form-questions").html("");
  var td = $(editButton).parent();
  var formUuid = $(td).find("#intFormUuid").val();
  var surveyUuids = $(td).find("#surveyUuids").val();
  var formNameName = $(td).find("#intFormName").val();
  var intFormShortdesc = $(td).find("#intFormShortdesc").val();
  var intFormDesc = $(td).find("#intFormDesc").val();
  var intFormPageNoOfQuestions = $(td).find("#intFormPageNoOfQuestions").val();
  var formQuestionsComponent = new FormQuestionsComponent(formUuid, surveyUuids.split(","), formNameName, intFormShortdesc, intFormDesc, intFormPageNoOfQuestions);
  formQuestionsComponent.render('#new-form-questions');
  $('#newForm').modal('show');
}

function addNewForm() {
  $("#new-form-questions").html("");
  var formQuestionsComponent = new FormQuestionsComponent(new Date().getTime() + '_new', [], '', '', '', 10);
  formQuestionsComponent.render('#new-form-questions');
  $('#newForm').modal('show');
}