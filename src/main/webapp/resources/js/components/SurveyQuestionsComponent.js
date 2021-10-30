/**
 *
 */
class SurveyQuestionsComponent {

  constructor(surveyUuid, surveyName, surveyShortDesc, surveyDesc) {
    this.surveyId = surveyUuid;
    this.surveyUuid = surveyUuid;
    this.surveyName = surveyName;
    this.surveyShortDesc = surveyShortDesc;
    this.surveyDesc = surveyDesc;
  }

  getSurveyQuestionsMarkup() {
    return '<input id="surveyUuid_' + this.surveyUuid + '" type="hidden" name="intSurveyUuid" />' +
        '<div class="dropdown-divider"></div>' +
        '<div id="survey-form-errors" class="form-group">' +
        '	<span class="text-danger"></span>' +
        '</div>' +
        '<div id="survey-form-success" class="form-group">' +
        '	<span class="text-success"></span>' +
        '</div>' +
        /*
        '<div class="form-row">'+
        '    <div class="col-md-6">'+
        '        <div class="form-group">'+
        '            <label class="small mb-1" for=""addressType"">Address Type</label>'+
        '            <select class="form-control" id="addressType" name="addressType">'+
        '		        <!-- <option value="primary">Primary</option> --> '+
        '		        <!-- <option value="billing">Billing</option> --> '+
        '		      </select>'+
        '        </div>'+
        '    </div>'+
        '</div>'+
        ''+
        */
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for=surveyName>Survey Name</label>' +
        '            <input class="form-control py-2" id="intSurveyName_' + this.surveyUuid + '" type="text" name="intSurveyName" placeholder="Enter Survey Name" />' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="intSurveyShortdesc">Survey Short Desc.</label>' +
        '            <input class="form-control py-2" id="intSurveyShortdesc_' + this.surveyUuid + '" name="intSurveyShortdesc" type="text" placeholder="Enter Survey Short Description" />' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '' +
        '<div class="form-row">' +
        '   <div class="col-md-6">' +
        '       <div class="form-group">' +
        '            <label class="small mb-1" for="intSurveyDesc">Survey Description</label>' +
        '		      <input class="form-control py-2" id="intSurveyDesc_' + this.surveyUuid + '" name="intSurveyDesc" type="text" placeholder="Enter Survey Description" />' +
        '       </div>' +
        '    </div>' +
        '</div>' +
        '<div class="form-group mt-4 mb-0" style="text-align: right;">' +
        '	<a id="survey-save-progress" class="btn btn-primary" style="display: none;">' +
        '    	<i id="address-save-progress" class="fas fa-sync fa-spin"></i> Saving ' +
        '    </a>' +
        '	<a id="survey-save-button" class="btn btn-primary" href="javascript:void(0);" onclick="$(\'#' + this.surveyId + '\').submit();" style="display: inline;"> ' +
        '		Save Survey ' +
        '	</a> &nbsp; &nbsp;' +
        /*
        '	<a id="survey-delete-progress_'+this.surveyId+'" class="btn btn-danger" href="javascript:void(0);" style="display: none;"> '+
        '		<i id="address-delete-progress" class="fas fa-sync fa-spin"></i> Deleting '+
        '	</a> '+
        '	<a id="survey-delete-button_'+this.surveyId+'" class="btn btn-danger" href="javascript:void(0);" style="display: inline;"> '+
        '		Delete Survey '+
        '	</a> '+
        */
        '</div>'
  }

  getSurveyQuestionsFormMarkup() {
    return '<form id="' + this.surveyId + '" >' +
        this.getSurveyQuestionsMarkup() +
        '</form>';

  }

  render(id) {
    $(id).append(this.getSurveyQuestionsFormMarkup());
    $("#surveyUuid_" + this.surveyUuid).val(this.surveyUuid);
    $("#intSurveyName_" + this.surveyUuid).val(this.surveyName);
    $("#intSurveyShortdesc_" + this.surveyUuid).val(this.surveyShortDesc);
    $("#intSurveyDesc_" + this.surveyUuid).val(this.surveyDesc);

    this.registerFormValidation();
    this.registerDeleteButtonHanlder();
  }

  registerDeleteButtonHanlder() {
    var thisClass = this;
    $("#survey-delete-button_" + thisClass.surveyId).click(function () {
      var form = $("#" + thisClass.surveyId);
      var surveyUuid = $("#surveyUuid_" + thisClass.surveyId).val();
      if (surveyUuid.endsWith("_new")) {
        $(form).remove();
      } else {
        $("#survey-delete-progress_" + thisClass.surveyId).show();
        $("#survey-delete-button_" + thisClass.surveyId).hide();
        $("#survey-save-button_" + thisClass.surveyId).hide();
        const jwtToken = JwtDAO.getInstance().getJWT();
        const request = {
          api: 'survey/deleteSurvey?surveyUuid=' + surveyUuid,
          requestBody: '',
          serviceCallback: function (response) {
            if (response.status !== 200) {
              $(form).find("#survey-form-errors").find("span").text(response.message);
              $(form).find("#survey-form-success").find("span").text("");
            } else {
              $(form).remove();
            }
            $("#survey-delete-progress_" + thisClass.surveyId).hide();
            $("#survey-delete-button_" + thisClass.surveyId).show();
            $("#survey-save-button_" + thisClass.surveyId).show();
          },
          jwt: jwtToken
        }
        RestClient.getInstance().get(request);
      }
    });
  }

  registerFormValidation() {
    var thisClass = this;
    $("#" + this.surveyId).validate({
      errorClass: 'text-danger',
      rules: {
        intSurveyName: {
          required: true
        }
      },
      // Specify validation error messages
      messages: {
        intSurveyName: {
          required: 'Please enter survey name'
        },
      },
      submitHandler: function (form) {
        $(form).find("#survey-save-progress").show();
        $(form).find("#survey-save-button").hide();
        $(form).find("#survey-delete-button").hide();
        var formData = new FormData(form);
        const value = Object.fromEntries(formData.entries());
        const jwtToken = JwtDAO.getInstance().getJWT();
        const request = {
          api: 'survey/saveUpdateSurvey',
          requestBody: value,
          serviceCallback: function (response) {
            if (response.status !== 200) {
              $(form).find("#survey-form-errors").find("span").text(response.message);
              $(form).find("#survey-form-success").find("span").text("");
            } else {
              $(form).find("#survey-form-errors").find("span").text("");
              $(form).find("#survey-form-success").find("span").text('Survey updated successfully');
              var intSurveyUuid = response.data.data.intSurveyUuid;
              $("#surveyUuid_" + thisClass.surveyUuid).val(intSurveyUuid);
              location.reload();
            }
            $(form).find("#survey-save-progress").hide();
            $(form).find("#survey-save-button").show();
            $(form).find("#survey-delete-button").show();

          },
          jwt: jwtToken
        }
        RestClient.getInstance().post(request);
      }
    });

  }

}