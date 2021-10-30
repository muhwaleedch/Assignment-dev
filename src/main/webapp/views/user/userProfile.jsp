<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<html>
<head>
  <stag:pageHead pageTitle="Profile"/>
  <script type="text/javascript" src="/resources/js/services/userProfile.js"></script>
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
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Profile details</h3></div>
          <div class="card-body">
            <util:genericProgressIndicator text="Getting profile data" id="profile-progress" display="block"/>
            <div id="profile-error-message" style="text-align: center;">
              <span></span>
            </div>
            <form id="profileForm" style="display:none;">
              <br/>
              <div id="profile-errors" class="form-group">
                <span class="text-danger"></span>
              </div>
              <div id="profile-success" class="form-group">
                <span class="text-success"></span>
              </div>
              <input type="hidden" id="userUuid" name="userUuid"/>
              <div class="form-row">
                <div class="col-md-4">
                  <div class="form-group">
                    <label class="small mb-1" for="userFirstName">First name</label>
                    <input class="form-control py-2" id="userFirstName" type="text" name="userFirstName"
                           placeholder="Enter first name"/>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="form-group">
                    <label class="small mb-1" for="userMiddleName">Middle name</label>
                    <input class="form-control py-2" id="userMiddleName" name="userMiddleName" type="text"
                           placeholder="Enter middle name"/>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="form-group">
                    <label class="small mb-1" for="userLastName">Last name</label>
                    <input class="form-control py-2" id="userLastName" name="userLastName" type="text"
                           placeholder="Enter last name"/>
                  </div>
                </div>
              </div>

              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="small mb-1" for="userEmail">Email</label>
                    <input class="form-control py-2" id="userEmail" type="text" name="userEmail"
                           placeholder="Enter email address"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="small mb-1" for="userContactnumber">Contact No.</label>
                    <input class="form-control py-2" id="userContactnumber" name="userContactnumber" type="text"
                           placeholder="Enter contact number"/>
                  </div>
                </div>
              </div>
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="small mb-1" for="userPassword">Password</label>
                    <input class="form-control py-2" id="userPassword" type="password" name="userPassword"
                           placeholder="Enter password"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="small mb-1" for="inputConfirmPassword">Confirm Password</label>
                    <input class="form-control py-2" id="inputConfirmPassword" type="password" name="confirmPassword"
                           placeholder="Confirm password"/>
                  </div>
                </div>
              </div>
              <div class="form-group mt-4 mb-0" style="text-align: right;">
                <a id="profile-save-progress" class="btn btn-primary" style="display: none;">
                  <i id="profile-save-progress" class="fas fa-sync fa-spin"></i>
                  Saving
                </a>
                <a id="profile-save-button" class="btn btn-primary" href="javascript:void(0);"
                   onclick="$('#profileForm').submit()">
                  Save Profile
                </a>
              </div>
            </form>
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