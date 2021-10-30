<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<html>
<head>
  <stag:pageHead pageTitle="Profile"/>
  <script type="text/javascript" src="/resources/js/components/AttachmentComponent.js"></script>
  <script type="text/javascript" src="/resources/js/services/userAttachments.js"></script>
</head>
<body>
<stag:securePage loginPage="/views/auth/login.jsp"/>
<stag:topNavigation/>
<div id="layoutSidenav">
  <stag:navigation/>
  <div id="layoutSidenav_content">
    <main>
      <div class="container-fluid">
        <div class="card mb-4">
          <div class="card-header"><h3 class="text-center font-weight-light my-1">Attachments details</h3></div>
          <div class="card-body">
            <util:genericProgressIndicator text="Getting attachments data" id="attachment-progress" display="block"/>
            <div id="attachment-error-message" style="text-align: center;">
              <span></span>
            </div>
            <div class="form-group mt-4 mb-0" style="text-align: right;">
              <a id="add-attachment-button" class="btn btn-primary" href="javascript:void(0);"
                 onclick="javascript:addNewAttachment();">
                Additional Attachments
              </a>
            </div>
            <div class="dropdown-divider"></div>
            <div id="attachmentsForm" class="row" style="display:none;">
              <div id="address-form-body">

              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <stag:pageFooter/>
  </div>
</div>
<stag:footer/>
</body>
</html>