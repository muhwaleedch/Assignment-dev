/**
 *
 */
class AttachFormsAndQuestions {

  constructor(componentUuid, attachedUuids, attachmentType) {
    this.componentUuid = componentUuid;
    this.attachedUuids = attachedUuids;
    this.attachmentType = attachmentType;
  }

  getMarkup() {
    return '<input id="componentUuid_' + this.componentUuid + '" type="hidden" name="componentUuid" />' +
        '<div id="question-errors" class="form-group">' +
        '	<span class="text-danger"></span>' +
        '</div>' +
        '<div id="question-success" class="form-group">' +
        '	<span class="text-success"></span>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-12">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="surveys">Select Form(s)</label>' +
        '            <select class="form-control" data-live-search="true" id="attachComponent_' + this.componentUuid + '" name="uuidsToAssociate" disabled>' +
        '		     </select>' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '<div class="form-group mt-4 mb-0" style="text-align: right;">' +
        '	<a id="form-save-progress" class="btn btn-primary" style="display: none;">' +
        '    	<i id="form-save-progress-icon" class="fas fa-sync fa-spin"></i> Saving ' +
        '    </a>' +
        '	<a id="form-save-button" class="btn btn-primary" href="javascript:void(0);" onclick="$(\'#' + this.componentUuid + '\').submit();" style="display: inline;"> ' +
        '		Save ' +
        '	</a> &nbsp; &nbsp;' +
        '</div>'
  }

  getCompleteMarkup() {
    return '<form id="' + this.componentUuid + '" >' +
        this.getMarkup() +
        '</form>';

  }


  render(id) {
    $(id).append(this.getCompleteMarkup());
    $("#componentUuid_" + this.componentUuid).val(this.componentUuid);
    if (this.attachmentType === 'form') {
      this.fetchActiveFormList();
    } else if (this.attachmentType === 'questions') {

    }
  }

  fetchActiveFormList() {
    var thisClass = this;
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'survey/activeFormList',
      requestBody: '',
      serviceCallback: function (response) {
        if (response.status !== 200) {
          alert("Some error occured while fetching form(s) information");
        } else {
          var formData = response.data.data;
          if (formData !== undefined && formData.length > 0) {
            formData.forEach(question => {
              var intFormUuid = question.intFormUuid;
              var intFormName = question.intFormName;
              $("#attachComponent_" + thisClass.componentUuid).append($('<option>', {
                value: intFormUuid,
                text: intFormName
              }));
            });
            $("#attachComponent_" + thisClass.componentUuid).prop("disabled", false);
            $("#attachComponent_" + thisClass.componentUuid).addClass("selectpicker");
            $("#attachComponent_" + thisClass.componentUuid).prop("multiple", true);
            $("#attachComponent_" + thisClass.componentUuid).val(thisClass.formsUuid);
            $("#attachComponent_" + thisClass.componentUuid).selectpicker();
          }
        }

      },
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
  }

  registerFormValidation() {
    var thisClass = this;
    $("#" + this.questionUuid).validate({
      errorClass: 'text-danger',
      rules: {
        uuidsToAssociate: {
          required: true
        }
      },
      // Specify validation error messages
      messages: {
        uuidsToAssociate: {
          required: 'Please select from options'
        },
      },
      submitHandler: function (form) {


      }
    });
  }

}