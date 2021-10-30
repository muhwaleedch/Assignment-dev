<!DOCTYPE html>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
  <stag:pageHead pageTitle="Survey Registration"/>
  <script type="text/javascript" src="/resources/js/services/adminRegister.js"></script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
  <div id="layoutAuthentication_content">
    <main>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-7">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
              <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
              <div class="card-body">
                <form id="registerForm">
                  <input name="userType" value="admin" type="hidden"/>
                  <div id="register-errors" class="form-group">
                    <span class="text-danger"></span>
                  </div>
                  <div id="register-success" class="form-group">
                    <span class="text-success"></span>
                  </div>

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
                        <label class="small mb-1" for="registerBy">Register By</label>
                        <div class="form-control py-2">
                          <div class="form-check form-check-inline" style="vertical-align: top;">
                            <input class="form-check-input" type="radio" name="registerBy" id="registerByEmail"
                                   value="byEmail" onclick="javascript:onClickByEmailOption()" checked>
                            <label class="form-check-label" for="registerByEmail">By Email</label>
                          </div>
                          <div class="form-check form-check-inline" style="vertical-align: top;">
                            <input class="form-check-input" type="radio" name="registerBy" id="registerByContactNo"
                                   value="byPhone" onclick="onClickByContactNoOption()">
                            <label class="form-check-label" for="registerByContactNo">By Contact number</label>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="form-group" id="userEmailContainer">
                        <label class="small mb-1" for="userEmail">Email</label>
                        <input class="form-control py-2" id="userEmail" type="text" name="userEmail"
                               placeholder="Enter email address"/>
                      </div>
                      <div class="form-group" id="userContactNoContainer" style="display: none;">
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
                        <input class="form-control py-2" id="inputConfirmPassword" type="password"
                               name="confirmPassword" placeholder="Confirm password"/>
                      </div>
                    </div>
                  </div>
                  <div class="form-group mt-4 mb-0">
                    <a id="register-progress" class="btn btn-primary btn-block" style="display: none;">
                      <i id="register-progress" class="fas fa-sync fa-spin"></i>
                    </a>
                    <a id="register-button" class="btn btn-primary btn-block" href="javascript:void(0);"
                       onclick="$('#registerForm').submit()">
                      Create Account
                    </a>
                  </div>
                </form>
              </div>
              <div class="card-footer text-center">
                <div class="small"><a href="adminLogin.jsp">Have an admin account? Go to login</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
  <stag:pageFooter/>
</div>
<stag:footer/>
</body>
</html>
