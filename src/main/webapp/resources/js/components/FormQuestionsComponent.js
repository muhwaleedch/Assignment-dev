/**
 *
 */
class FormQuestionsComponent {

  constructor(formUuid, surveyUuids, formName, formShortDesc, formDesc, noOfQuestionsPerPage) {
    this.formId = formUuid;
    this.formUuid = formUuid;
    this.surveyUuids = surveyUuids;
    this.formName = formName;
    this.formShortDesc = formShortDesc;
    this.formDesc = formDesc;
    this.noOfQuestionsPerPage = noOfQuestionsPerPage;
  }

  getFormQuestionsMarkup() {
    return '<input id="formUuid_' + this.formUuid + '" type="hidden" name="intFormUuid" />' +
        '<div class="dropdown-divider"></div>' +
        '<div id="form-errors" class="form-group">' +
        '	<span class="text-danger"></span>' +
        '</div>' +
        '<div id="form-success" class="form-group">' +
        '	<span class="text-success"></span>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="surveys">Select Survey(s)</label>' +
        '            <select class="form-control" data-live-search="true" id="surveys_' + this.formUuid + '" name="surveyUuids" disabled>' +
        '		     </select>' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for=surveyName>Form Name</label>' +
        '            <input class="form-control py-2" id="intFormName_' + this.formUuid + '" type="text" name="intFormName" placeholder="Enter Form Name" />' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="intFormShortdesc">Form Short Desc.</label>' +
        '            <input class="form-control py-2" id="intFormShortdesc_' + this.formUuid + '" name="intFormShortdesc" type="text" placeholder="Enter Form Short Description" />' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '' +
        '<div class="form-row">' +
        '   <div class="col-md-6">' +
        '       <div class="form-group">' +
        '            <label class="small mb-1" for="intFormDesc">Form Description</label>' +
        '		      <input class="form-control py-2" id="intFormDesc_' + this.formUuid + '" name="intFormDesc" type="text" placeholder="Enter Form Description" />' +
        '       </div>' +
        '    </div>' +
        '   <div class="col-md-6">' +
        '       <div class="form-group">' +
        '            <label class="small mb-1" for="intFormDesc">Questions per page</label>' +
        '		      <input class="form-control py-2" id="questionsPerPage_' + this.formUuid + '" name="intFormPageNoOfQuestions" type="text" placeholder="Enter Questions Per Page" />' +
        '       </div>' +
        '    </div>' +
        '</div>' +
        '<div class="form-group mt-4 mb-0" style="text-align: right;">' +
        '	<a id="form-save-progress" class="btn btn-primary" style="display: none;">' +
        '    	<i id="form-save-progress-icon" class="fas fa-sync fa-spin"></i> Saving ' +
        '    </a>' +
        '	<a id="form-save-button" class="btn btn-primary" href="javascript:void(0);" onclick="$(\'#' + this.formUuid + '\').submit();" style="display: inline;"> ' +
        '		Save Form ' +
        '	</a> &nbsp; &nbsp;' +
        /*
        '	<a id="form-delete-progress" class="btn btn-danger" href="javascript:void(0);" style="display: none;"> '+
        '		<i id="form-delete-progress" class="fas fa-sync fa-spin"></i> Deleting '+
        '	</a> '+
        '	<a id="form-delete-button" class="btn btn-danger" href="javascript:void(0);" style="display: inline;"> '+
        '		Delete Form '+
        '	</a> '+
        */
        '</div>'
  }

  getFormQuestionsFormMarkup() {
    return '<form id="' + this.formUuid + '" >' +
        this.getFormQuestionsMarkup() +
        '</form>';

  }

  render(id) {
    $(id).append(this.getFormQuestionsFormMarkup());
    $("#formUuid_" + this.formUuid).val(this.formUuid);
    $("#intFormName_" + this.formUuid).val(this.formName);
    $("#intFormShortdesc_" + this.formUuid).val(this.formShortDesc);
    $("#intFormDesc_" + this.formUuid).val(this.formDesc);
    $("#questionsPerPage_" + this.formUuid).val(this.noOfQuestionsPerPage);
    this.fetchActiveSurveyList();
    this.registerFormValidation();
    this.registerDeleteButtonHanlder();
  }

  fetchActiveSurveyList() {
    var thisClass = this;
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'survey/activeSurveyList',
      requestBody: '',
      serviceCallback: function (response) {
        if (response.status !== 200) {
          alert("Some error occured while fetching survey(s) information");
        } else {
          var surveyQuestions = response.data.data;
          if (surveyQuestions !== undefined && surveyQuestions.length > 0) {
            surveyQuestions.forEach(question => {
              var surveyUuid = question.intSurveyUuid;
              var surveyName = question.intSurveyName;
              $("#surveys_" + thisClass.formUuid).append($('<option>', {
                value: surveyUuid,
                text: surveyName
              }));
            });
            $("#surveys_" + thisClass.formUuid).prop("disabled", false);
            $("#surveys_" + thisClass.formUuid).addClass("selectpicker");
            $("#surveys_" + thisClass.formUuid).prop("multiple", true);
            $("#surveys_" + thisClass.formUuid).val(thisClass.surveyUuids);
            $("#surveys_" + thisClass.formUuid).selectpicker();
          }
        }

      },
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
  }

  registerDeleteButtonHanlder() {

  }

  registerFormValidation() {
    var thisClass = this;
    $("#" + this.formUuid).validate({
      errorClass: 'text-danger',
      rules: {
        intFormName: {
          required: true
        },
        intFormShortdesc: {
          required: true
        },
        intFormPageNoOfQuestions: {
          required: true,
          number: true
        },
        surveyUuids: {
          required: true
        }
      },
      // Specify validation error messages
      messages: {
        intFormName: {
          required: 'Please enter form name'
        },
        intFormShortdesc: {
          required: 'Please enter form short description'
        },
        intFormPageNoOfQuestions: {
          required: 'Please enter number of questions per page',
          number: 'Number of questions per page should be numeric'
        },
        surveyUuids: {
          required: 'Please select survey(s) for this form'
        }
      },
      submitHandler: function (form) {
        $(form).find("#form-save-progress").show();
        $(form).find("#form-save-button").hide();
        $(form).find("#form-delete-button").hide();
        var formData = new FormData(form);
        const value = Object.fromEntries(formData.entries());
        const jwtToken = JwtDAO.getInstance().getJWT();
        const surveys = $("#surveys_" + thisClass.formUuid).val();
        value['surveyUuids'] = surveys;
        console.log(value);
        const request = {
          api: 'survey/saveForm',
          requestBody: value,
          serviceCallback: function (response) {
            if (response.status !== 200) {
              $(form).find("#form-errors").find("span").text(response.message);
              $(form).find("#form-success").find("span").text("");
            } else {
              $(form).find("#form-errors").find("span").text("");
              $(form).find("#form-success").find("span").text('Form updated successfully');
              var intFormUuid = response.data.data.intFormUuid;
              $("#formUuid_" + thisClass.formUuid).val(intFormUuid);
              location.reload();
            }
            $(form).find("#form-save-progress").hide();
            $(form).find("#form-save-button").show();
            $(form).find("#form-delete-button").show();

          },
          jwt: jwtToken
        }
        RestClient.getInstance().post(request);
      }
    });
  }

}