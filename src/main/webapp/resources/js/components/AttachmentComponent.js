/**
 *
 */
class AttachmentComponent {

  static attachmentsCollection;

  constructor(menuItemDetailsUuid, userAttachTypeUuid, displayLabel, defaultView, attachmentFileName, attachmentFileLimit) {
    this.menuItemDetailsUuid = menuItemDetailsUuid;
    this.userAttachTypeUuid = userAttachTypeUuid;
    this.displayLabel = displayLabel;
    this.attachmentsFormId = 'attachments_form_' + menuItemDetailsUuid;
    this.defaultView = defaultView;
    this.attachmentFileName = attachmentFileName;
    this.attachmentFileLimit = attachmentFileLimit;
    if (AttachmentComponent.attachmentsCollection === undefined) {
      AttachmentComponent.attachmentsCollection = {};
    }
    if (this.userAttachTypeUuid !== '') {
      AttachmentComponent.attachmentsCollection[this.userAttachTypeUuid] = this;
    } else {
      this.userAttachTypeUuid = "000";
    }
    this.attachmentExtensions = "*";
  }

  getAttachmentsMarkup() {
    return '<input id="menuItemDetailsUuid" type="hidden" name="menuItemDetailsUuid" />' +
        '<input id="userAttachTypeUuid" type="hidden" name="userAttachTypeUuid" />' +
        '<div id="attachment-errors" class="form-group">' +
        '	<span class="text-danger"></span>' +
        '</div>' +
        '<div id="attachment-success" class="form-group">' +
        '	<span class="text-success"></span>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-12 card">' +
        '		  <div id="attachment_header_' + this.menuItemDetailsUuid + '" class="card-header" style="padding: 0px;"><div class="row">' +
        '			  <div class="col-6"><h6 class="text-center font-weight-bold my-1" style="display: inline;">' + this.displayLabel +
        '             </h6></div>' +
        '            <div class="col-6" style="text-align: right;"> <a title="Delete Attachment" id="delete-attachment-button_' + this.menuItemDetailsUuid + '" class="btn btn-primary text-center" href="javascript:void(0);">X</a></div>' +
        '			</div>' +
        '		  </div> ' +
        '         <div class="card-body row">' +
        '         <div class="col-4 attach-icon" style="text-align: center;" >' +
        '            <select class="form-control" id="attachmentType_' + this.menuItemDetailsUuid + '" name="attachmentType" style="display: none;">' +
        '		     	<option value="000">Select Type</option>' +
        '		     </select>' +
        '             <br/><i class="fa fa-paperclip fa-w-14 fa-2x attach" title="Click to attach document" onclick=\'javascript: $("#attachment-upload_' + this.menuItemDetailsUuid + '").click();\'></i>' +
        '         </div>' +
        '		  <input id="attachment-upload_' + this.menuItemDetailsUuid + '" type="file" accept="*" style="display: none;"/>' +
        '         <div class="col-8" style="border-left: 1px dashed #333; text-align: center;">' +
        '         	<img download id="attachment-pic_' + this.menuItemDetailsUuid + '" style="max-height: 100px; width: 100%; cursor: pointer;" alt="Loading Attachment..." src="abc.jpg" />' +
        '         	<a download id="attachment-link_' + this.menuItemDetailsUuid + '" style="max-height: 100px; width: 100%; cursor: pointer; display: none" a> Download Attachment</a>' +
        '			<span></span>' +
        '         </div>' +
        '         </div>' +
        '    </div>' +
        '</div>' +
        '</div>'
  }

  getAttachmentsFormMarkup() {
    return '<div id="' + this.attachmentsFormId + '" class="col-xs-12 col-sm-12 col-md-6 col-lg-6">' +
        this.getAttachmentsMarkup() +
        '</div>';

  }

  render(id) {
    $(id).append(this.getAttachmentsFormMarkup());

    //----------------- POPULATING ATTACHMENT TYPES OF "O" TYPE OF ATTACHMENTS
    if (!this.defaultView) {
      $("#attachment_header_" + this.menuItemDetailsUuid).find("h6").text("Additional Attachment");
      $("#attachmentType_" + this.menuItemDetailsUuid).show();
      if (MetadataDAO.getInstance().getMenuItemTypes() !== null) {
        var attachments = MetadataDAO.getInstance().getMenuItemTypes();
        attachments.forEach(element => {
          if (element.uiMenuItemDetailsOnScreenDisplayOption === 'O') {
            $("#attachmentType_" + this.menuItemDetailsUuid).append($('<option>', {
              value: element.uiMenuItemDetailsAttachmentTypeUuid,
              text: element.uiMenuItemDetailsAttachmentTypeName
            }));
            this.attachmentFileLimit = element.uiMenuItemDetailsSizeInMb;
          }
        });
        if (this.userAttachTypeUuid !== '') {
          $("#attachmentType_" + this.menuItemDetailsUuid).val(this.userAttachTypeUuid);
        }
      }
    }

    //------------ SETTING EXTENSION TYPES -----------------------
    if (MetadataDAO.getInstance().getMenuItemTypes() !== null) {
      var attachments = MetadataDAO.getInstance().getMenuItemTypes();
      attachments.forEach(element => {
        if (element.uiMenuItemDetailsExtOfAttachments !== undefined) {
          var array = element.uiMenuItemDetailsExtOfAttachments.split("|");
          if (array.length > 0) {
            var extensions = "";
            array.forEach(function (item, index) {
              extensions += "." + item + ", ";
            })
            this.attachmentExtensions = extensions;
            $('#attachment-upload_' + this.menuItemDetailsUuid).attr("accept", this.attachmentExtensions);
          }
        }
      });
    }

    this.fetchUserAttachment();
    this.registerOnChangeAttachmentType();
    this.registerDeleteButtonOnClick();

  }

  fetchUserAttachment() {

    if (this.userAttachTypeUuid !== '') {
      const jwtToken = JwtDAO.getInstance().getJWT();
      this.unRegisterOnChangeOnImg();
      var thisClass = this;
      const request = {
        api: 'survey/user/getUserAttachment?attachmentTypeUuid=' + this.userAttachTypeUuid,
        requestBody: '',
        serviceCallback: function (response) {
          $('#attachment-pic_' + thisClass.menuItemDetailsUuid).attr('src', '/resources/assets/img/attachments/attachment-default.jpg');
          if (response.status !== 200 && response.status !== 404) {
            alert('Error fetching Attachment Document. Contact support.');
          } else if (response.status === 200) {
            var contentType = response.responseObj.headers['content-type'];
            if (contentType.indexOf("image") !== -1) {
              $('#attachment-pic_' + thisClass.menuItemDetailsUuid).attr('src', 'data:' + contentType + ';base64,' + response.data);
              thisClass.registerImageOnClick();
            } else {
              $('#attachment-link_' + thisClass.menuItemDetailsUuid).attr('href', 'data:' + contentType + ';base64,' + response.data);
              $('#attachment-pic_' + thisClass.menuItemDetailsUuid).hide();
              $('#attachment-link_' + thisClass.menuItemDetailsUuid).show();

            }
          }
          thisClass.registerOnChangeOnImg();
        },
        jwt: jwtToken
      }
      //console.log('Request json', request);
      RestClient.getInstance().get(request);
    } else {
      this.registerOnChangeOnImg();
      $('#attachment-pic_' + this.menuItemDetailsUuid).attr('src', '/resources/assets/img/attachments/attachment-default.jpg');
    }
  }

  registerOnChangeAttachmentType() {
    var thisClass = this;
    $('#attachmentType_' + this.menuItemDetailsUuid).on('change', function () {
      thisClass.userAttachTypeUuid = $(this).val();
      if (thisClass.userAttachTypeUuid in AttachmentComponent.attachmentsCollection) {
        $('#attachmentType_' + thisClass.menuItemDetailsUuid).val("000").attr('selected', 'selected');
        alert("This attachment type already exists.");
        thisClass.userAttachTypeUuid = "000";
      } else {
        if (thisClass.userAttachTypeUuid !== "000") {
          AttachmentComponent.attachmentsCollection[thisClass.userAttachTypeUuid] = thisClass;
        }
      }
    });
  }

  unRegisterOnChangeOnImg() {
    $('#attachment-upload_' + this.menuItemDetailsUuid).off('change');
  }

  registerOnChangeOnImg() {
    var thisClass = this;
    $('#attachment-upload_' + this.menuItemDetailsUuid).on('change', function () {
      thisClass.readURL(this, thisClass);
    });
  }

  registerImageOnClick() {
    $('#attachment-pic_' + this.menuItemDetailsUuid).click(function () {
      window.open('userAttachmentsZoom.jsp?attachment=' + $(this).attr("id"), 'popUpWindow', 'height=700,width=1200,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
    });
  }

  registerDeleteButtonOnClick() {
    var thisClass = this;
    $('#delete-attachment-button_' + this.menuItemDetailsUuid).click(function () {
      if (thisClass.menuItemDetailsUuid.endsWith("_new")) {
        $("#" + thisClass.attachmentsFormId).remove();
        thisClass.removeKeyFromMap(thisClass.userAttachTypeUuid);
      } else {
        const jwtToken = JwtDAO.getInstance().getJWT();
        thisClass.unRegisterOnChangeOnImg();
        const request = {
          api: 'survey/user/deleteUserAttachment?attachmentTypeUuid=' + thisClass.userAttachTypeUuid,
          requestBody: '',
          serviceCallback: function (response) {
            $('#attachment-pic_' + thisClass.menuItemDetailsUuid).attr('src', '/resources/assets/img/attachments/attachment-default.jpg');
            if (response.status !== 200) {
              alert('Error Deleting Attachment Document. Contact support.');
            } else if (response.status === 200) {
              if (thisClass.menuItemDetailsUuid.endsWith("_saved")) {
                $("#" + thisClass.attachmentsFormId).remove();
                thisClass.removeKeyFromMap(thisClass.userAttachTypeUuid);
              }
            }
            thisClass.registerOnChangeOnImg();
          },
          jwt: jwtToken
        }
        //console.log('Request json', request);
        RestClient.getInstance().get(request);
      }

    });
  }

  removeKeyFromMap(keyToRemove) {
    var map = {};
    for (var key in AttachmentComponent.attachmentsCollection) {
      if (key !== keyToRemove) {
        map[key] = AttachmentComponent.attachmentsCollection[key];
      }
    }
    AttachmentComponent.attachmentsCollection = map;
  }

  readURL(input, thisClass) {

    if (input.files && input.files[0]) {
      var contentType = input.files[0].type;
      var fileSizeInMB = (parseInt(input.files[0].size) / 1024) / 1024;
      var allowedFileSize = parseInt(thisClass.attachmentFileLimit);
      if (fileSizeInMB <= allowedFileSize) {
        var reader = new FileReader();

        var postAttachmentUploadCallback = (response) => {
          if (response.status !== 200) {
            alert("Something gone wrong while changing Profile Picture. Contact Support");
          }
        }

        reader.onload = function (e) {
          if (thisClass.userAttachTypeUuid !== '000') {
            if (contentType.indexOf("image") !== -1) {
              $('#attachment-pic_' + thisClass.menuItemDetailsUuid).attr('src', e.target.result);
              $('#attachment-pic_' + thisClass.menuItemDetailsUuid).show();
              $('#attachment-link_' + thisClass.menuItemDetailsUuid).hide();
            } else {
              $('#attachment-link_' + thisClass.menuItemDetailsUuid).attr('href', e.target.result);
              $('#attachment-pic_' + thisClass.menuItemDetailsUuid).hide();
              $('#attachment-link_' + thisClass.menuItemDetailsUuid).show();
            }
            thisClass.registerImageOnClick();
            var formData = new FormData();
            formData.append("file", input.files[0]);
            formData.append("attachmentTypeUuid", thisClass.userAttachTypeUuid);
            const jwtToken = JwtDAO.getInstance().getJWT();
            const request = {
              api: 'survey/user/saveUserAttachment',
              requestBody: formData,
              serviceCallback: postAttachmentUploadCallback,
              jwt: jwtToken,
              multipartRequest: 'yes'
            }
            //console.log('Request json', request);
            RestClient.getInstance().post(request);
          } else {
            alert("Please select attachment type.");
          }
        }

        reader.readAsDataURL(input.files[0]);
      } else {
        alert("Upto " + allowedFileSize + " MB of file size is allowed to upload.");
      }
    }
  }

}