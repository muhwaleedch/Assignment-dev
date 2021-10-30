/**
 *
 */
$(document).ready(function () {
  if (MetadataDAO.getInstance().getMenuItemTypes() === null) {
    fetchAttachmentDetails();
  } else {
    initializeAttachmentComponents();
  }
});

//####################### ATTACHMENTS BUSINESS DETAILS ####################################################

function fetchAttachmentDetails() {

  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'metadata/findAllUserMenuItemDetails',
    requestBody: '',
    serviceCallback: attachmentDetailsCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)

}

function fetchUserSavedAttachments() {
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/user/findUserAttachments',
    requestBody: '',
    serviceCallback: userSavedAttachmentsDetailsCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)
}

attachmentDetailsCallback = (response) => {
  if (response.status !== 200) {
    $("#attachment-error-message").find("span").text(response.message);
  } else {
    var attachmentsTypes = response.data.data;
    MetadataDAO.getInstance().saveMenuItemTypes(attachmentsTypes);
    initializeAttachmentComponents();
  }

}

userSavedAttachmentsDetailsCallback = (response) => {
  if (response.status !== 200) {
    $("#attachment-error-message").find("span").text(response.message);
  } else {
    var attachments = response.data.data;
    attachments.forEach(function (attachment, index) {
      if (!(attachment.userAttachTypeUuid in AttachmentComponent.attachmentsCollection)) {
        var attachment = new AttachmentComponent(new Date().getTime() + '_saved', attachment.userAttachTypeUuid, '', false, attachment.userAttachOrgFilenamePath, '-1');
        attachment.render("#attachmentsForm");
      }
    });
  }

}

function initializeAttachmentComponents() {
  var attachments = MetadataDAO.getInstance().getMenuItemTypes();
  attachments.forEach(element => {
    if (element.uiMenuItemDetailsOnScreenDisplayOption === 'Y' && element.uiMenuItemDetailsName.indexOf('profile_') !== -1) {
      var attachment = new AttachmentComponent(element.uiMenuItemDetailsUuid, element.uiMenuItemDetailsAttachmentTypeUuid, element.uiMenuItemDetailsFrontDispName, true, element.userAttachOrgFilenamePath, element.uiMenuItemDetailsSizeInMb);
      attachment.render("#attachmentsForm");
    }
  });
  $("#attachmentsForm").show();
  $("#attachment-progress").hide();
  fetchUserSavedAttachments();
}

function addNewAttachment() {
  var attachment = new AttachmentComponent(new Date().getTime() + '_new', '', '', false, '');
  attachment.render("#attachmentsForm");
}