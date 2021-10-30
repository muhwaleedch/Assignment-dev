/**
 *
 */
class QuestionsComponent {

  constructor(questionUuid, formsUuid, parentQuestionUuid, questionTypeUuid, questionName, questionText, options) {
    this.questionUuid = questionUuid;
    console.log(questionUuid);
    this.formsUuid = formsUuid;
    console.log(formsUuid);
    this.parentQuestionUuid = parentQuestionUuid;
    console.log(parentQuestionUuid);
    this.questionTypeUuid = questionTypeUuid;
    console.log(questionTypeUuid);
    this.questionName = questionName;
    console.log(questionName);
    this.questionText = questionText;
    console.log(questionText);
    this.options = options;
    console.log(options);
  }

  getFormQuestionsMarkup() {
    return '<input id="questionUuid_' + this.questionUuid + '" type="hidden" name="intQuestionUuid" />' +
        '<div class="dropdown-divider"></div>' +
        '<div id="question-errors" class="form-group">' +
        '	<span class="text-danger"></span>' +
        '</div>' +
        '<div id="question-success" class="form-group">' +
        '	<span class="text-success"></span>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="surveys">Select Form(s)</label>' +
        '            <select class="form-control" data-live-search="true" id="form_' + this.questionUuid + '" name="formsUuid" disabled>' +
        '		     </select>' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="surveys">Select Question Type</label>' +
        '            <select class="form-control" data-live-search="true" id="questionType_' + this.questionUuid + '" name="intQuestionIntQuestionTypeuuid" disabled>' +
        '				<option value="">Select Question Type</option>' +
        '		     </select>' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="surveys">Select Parent Question</label>' +
        '            <select class="form-control" data-live-search="true" id="parentQuestion_' + this.questionUuid + '" name="intQuestionParentUuid" disabled>' +
        '				<option value="">Select Parent Question</option>' +
        '		     </select>' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for=surveyName>Question Name</label>' +
        '            <input class="form-control py-2" id="intQuestionName_' + this.questionUuid + '" type="text" name="intQuestionName" placeholder="Enter Question Name" />' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="intFormShortdesc">Question Text</label>' +
        '            <input class="form-control py-2" id="intQuestionText_' + this.questionUuid + '" name="intQuestionCompletequestion" type="text" placeholder="Enter Question Text" />' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-3">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="noOfOptions">No. Of Options</label>' +
        '            <input class="form-control py-2" id="noOfOptions_' + this.questionUuid + '" name="noOfOptions" type="number" placeholder="Enter Number of options" disabled/>' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-3">' +
        '        <div class="form-group">' +
        '           <br/>' +
        '			<a id="optionsCreation_' + this.questionUuid + '" class="btn btn-primary" href="javascript:void(0);" style="display: none;"> ' +
        '				+ Options ' +
        '			</a> &nbsp; &nbsp;' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-12">' +
        '        <div class="form-group">' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '<div id="question-options_' + this.questionUuid + '" class="form-row">' +
        '</div>' +
        '<div class="form-group mt-4 mb-0" style="text-align: right;">' +
        '	<a id="form-save-progress" class="btn btn-primary" style="display: none;">' +
        '    	<i id="form-save-progress-icon" class="fas fa-sync fa-spin"></i> Saving ' +
        '    </a>' +
        '	<a id="form-save-button" class="btn btn-primary" href="javascript:void(0);" onclick="$(\'#' + this.questionUuid + '\').submit();" style="display: inline;"> ' +
        '		Save Question ' +
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
    return '<form id="' + this.questionUuid + '" >' +
        this.getFormQuestionsMarkup() +
        '</form>';

  }


  render(id) {
    $(id).append(this.getFormQuestionsFormMarkup());
    $("#questionUuid_" + this.questionUuid).val(this.questionUuid);
    $("#intQuestionName_" + this.questionUuid).val(this.questionName);
    $("#intQuestionText_" + this.questionUuid).val(this.questionText);
    $("#noOfOptions_" + this.questionUuid).val(this.options.length);
    this.fetchActiveFormList();
    this.registerFormValidation();
    this.fetchActiveParentQuestionsList();
    this.fetchActiveQuestionTypesList();
    this.registerQuestionOptionsButton();
    this.registerQuestionTypeChangeHandler();
    this.fetchDefaultOptionsNumber();
  }

  registerQuestionOptionsButton() {
    var thisClass = this;
    $('#optionsCreation_' + this.questionUuid).click(function () {
      thisClass.createOptions(thisClass);
    });
  }

  createOptions(thisClass) {
    if ($("#questionType_" + thisClass.questionUuid).val() !== "" && ($("#questionType_" + thisClass.questionUuid).find("option:selected").text() === "onechoice" || $("#questionType_" + thisClass.questionUuid).find("option:selected").text() === "manychoice")) {
      var value = $('#noOfOptions_' + thisClass.questionUuid).val();
      var cursor = 0;
      $('#question-options_' + thisClass.questionUuid).html("");
      while (cursor < value) {
        var optionValue = '';
        if (cursor < thisClass.options.length) {
          optionValue = thisClass.options[cursor];
        }
        var input = '<div class="form-group"><div class="col-md-12"><input type="text" placeholder="Enter Option" style="form-control py-2" name="options" value="' + optionValue + '" /></div></div>';
        $('#question-options_' + thisClass.questionUuid).append(input);
        cursor++;
      }
    }
  }

  fetchDefaultOptionsNumber() {
    var thisClass = this;
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'metadata/getSysParamByName?sysParameterName=default_question_options',
      requestBody: '',
      serviceCallback: function (response) {
        if (response.status !== 200 && response.status !== 404) {
          alert("Some error occured while fetching Default question options configuration");
        } else {
          var value = response.data.data.sysParameterValue;
          if (thisClass.options.length > 0) {
            value = thisClass.options.length;
          }
          $("#noOfOptions_" + thisClass.questionUuid).val(value);
          $("#noOfOptions_" + thisClass.questionUuid).prop("disabled", false);
          $("#optionsCreation_" + thisClass.questionUuid).css("display", "inline");
        }

      },
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
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
              $("#form_" + thisClass.questionUuid).append($('<option>', {
                value: intFormUuid,
                text: intFormName
              }));
            });
            $("#form_" + thisClass.questionUuid).prop("disabled", false);
            $("#form_" + thisClass.questionUuid).addClass("selectpicker");
            $("#form_" + thisClass.questionUuid).prop("multiple", true);
            $("#form_" + thisClass.questionUuid).val(thisClass.formsUuid);
            $("#form_" + thisClass.questionUuid).selectpicker();
          }
        }

      },
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
  }

  fetchActiveParentQuestionsList() {
    var thisClass = this;
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'survey/activeParentQuestionsList',
      requestBody: '',
      serviceCallback: function (response) {
        if (response.status !== 200) {
          alert("Some error occured while fetching parent question(s) information");
        } else {
          var parentQuestionData = response.data.data;
          if (parentQuestionData !== undefined && parentQuestionData.length > 0) {
            parentQuestionData.forEach(question => {
              var intQuestionUuid = question.intQuestionUuid;
              var intQuestionCompletequestion = question.intQuestionCompletequestion;
              $("#parentQuestion_" + thisClass.questionUuid).append($('<option>', {
                value: intQuestionUuid,
                text: intQuestionCompletequestion
              }));
            });
            $("#parentQuestion_" + thisClass.questionUuid).prop("disabled", false);
            //$("#form_"+thisClass.questionUuid).addClass("selectpicker");
            //$("#form_"+thisClass.questionUuid).prop( "multiple", true );
            $("#parentQuestion_" + thisClass.questionUuid).val(thisClass.parentQuestionUuid);
            //$("#form_"+thisClass.questionUuid).selectpicker();
          }
        }

      },
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
  }

  fetchActiveQuestionTypesList() {
    var thisClass = this;
    const jwtToken = JwtDAO.getInstance().getJWT();
    const request = {
      api: 'survey/activeQuestionTypes',
      requestBody: '',
      serviceCallback: function (response) {
        if (response.status !== 200) {
          alert("Some error occured while fetching active question types information");
        } else {
          var parentQuestionData = response.data.data;
          if (parentQuestionData !== undefined && parentQuestionData.length > 0) {
            parentQuestionData.forEach(question => {
              var intQuestionTypeUuid = question.intQuestionTypeUuid;
              var intQuestionTypeName = question.intQuestionTypeName;
              $("#questionType_" + thisClass.questionUuid).append($('<option>', {
                value: intQuestionTypeUuid,
                text: intQuestionTypeName
              }));
            });
            $("#questionType_" + thisClass.questionUuid).prop("disabled", false);
            //$("#form_"+thisClass.questionUuid).addClass("selectpicker");
            //$("#form_"+thisClass.questionUuid).prop( "multiple", true );
            $("#questionType_" + thisClass.questionUuid).val(thisClass.questionTypeUuid);
            $("#questionType_" + thisClass.questionUuid).trigger("change");
            //$("#form_"+thisClass.questionUuid).selectpicker();
            //thisClass.createOptions(thisClass);
          }
        }

      },
      jwt: jwtToken
    }
    RestClient.getInstance().get(request)
  }

  registerQuestionTypeChangeHandler() {
    var thisClass = this;
    $("#questionType_" + this.questionUuid).change(function () {
      var value = $(this).find("option:selected").text();
      if (value === parentQuestion) {
        $("#parentQuestion_" + thisClass.questionUuid).prop('disabled', true);
      } else {
        $("#parentQuestion_" + thisClass.questionUuid).prop('disabled', false);
      }

      if (value === oneChoiceQuestion || value === multiChoiceQuestion) {
        var defaultValue = $("#noOfOptions_" + thisClass.questionUuid).val();
        if (defaultValue === "") {
          $("#noOfOptions_" + thisClass.questionUuid).val("0");
        }
        thisClass.createOptions(thisClass);
        $("#noOfOptions_" + thisClass.questionUuid).prop('disabled', false);
      } else {
        $("#noOfOptions_" + thisClass.questionUuid).val("");
        thisClass.createOptions(thisClass);
        $("#noOfOptions_" + thisClass.questionUuid).prop('disabled', true);
      }

    });
  }

  registerFormValidation() {
    var thisClass = this;
    $("#" + this.questionUuid).validate({
      errorClass: 'text-danger',
      rules: {
        formsUuid: {
          required: true
        },
        intQuestionIntQuestionTypeuuid: {
          required: true
        },
        //intQuestionParentUuid: {
        //	required: function(element) {
        //		return $("#questionType_" + thisClass.questionUuid).find("option:selected").text() === 'parent_question';
        //	}
        //},
        intQuestionName: {
          required: true
        },
        intQuestionCompletequestion: {
          required: true
        }
      },
      // Specify validation error messages
      messages: {
        formsUuid: {
          required: 'Please select Form(s)'
        },
        //intQuestionIntQuestionTypeuuid: {
        //		required: 'Please select question type'
        //	},
        intQuestionParentUuid: {
          required: 'Please select Parent Question'
        },
        intQuestionName: {
          required: 'Please enter question name'
        },
        intQuestionCompletequestion: {
          required: 'Please enter question type'
        }
      },
      submitHandler: function (form) {
        var optionsCompeleted = true;
        const options = $("input[name='options']").map(function () {
          return {intQuestionAnsweroptionAnswer: $(this).val()};
        }).get();
        if (options.length > 0) {
          options.forEach(option => {
            if (option.intQuestionAnsweroptionAnswer.trim() === '') {
              optionsCompeleted = false;
            }
          });
        }
        if (optionsCompeleted) {
          $(form).find("#form-save-progress").show();
          $(form).find("#form-save-button").hide();
          $(form).find("#form-delete-button").hide();
          var formData = new FormData(form);
          const value = Object.fromEntries(formData.entries());
          const jwtToken = JwtDAO.getInstance().getJWT();
          const formIds = $("#form_" + thisClass.questionUuid).val();

          value['formsUuid'] = formIds;
          value['intQuestionsAnswerOptionDtos'] = options
          const request = {
            api: 'survey/saveQuestion',
            requestBody: value,
            serviceCallback: function (response) {
              if (response.status !== 200) {
                $(form).find("#form-errors").find("span").text(response.message);
                $(form).find("#form-success").find("span").text("");
              } else {
                $(form).find("#form-errors").find("span").text("");
                $(form).find("#form-success").find("span").text('Question updated successfully');
                var intQuestionUuid = response.data.data.intQuestionUuid;
                $("#questionUuid_" + thisClass.questionUuid).val(intQuestionUuid);
                location.reload();
              }
              $(form).find("#form-save-progress").hide();
              $(form).find("#form-save-button").show();
              $(form).find("#form-delete-button").show();

            },
            jwt: jwtToken
          }
          RestClient.getInstance().post(request);
        } else {
          alert("Please provide text for all options");
        }
      }
    });
  }

}