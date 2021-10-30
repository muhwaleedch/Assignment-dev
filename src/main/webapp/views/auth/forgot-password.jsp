<!DOCTYPE html>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
  <stag:pageHead pageTitle="Forgot Password"/>
  <script type="text/javascript" src="/resources/js/services/forgotPassword.js"></script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
  <div id="layoutAuthentication_content">
    <main>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
              <div class="card-header"><h3 class="text-center my-2">Find Your Account</h3></div>
              <div class="card-body">
                <form id="forgotPasswordForm" action="">
                  <div id="loginError" class="form-group">
                    <span class="text-danger"></span>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label class="small mb-1">Search By</label>
                      <div>
                        <div style="vertical-align: top;">
                          <input class="form-check-input" type="radio" name="registerBy" id="registerByEmail"
                                 value="byEmail" checked>
                          <label class="form-check-label" for="registerByEmail">By Email</label>
                        </div>
                        <div style="vertical-align: top;">
                          <input class="form-check-input" type="radio" name="registerBy" id="registerByContactNo"
                                 value="byPhone">
                          <label class="form-check-label" for="registerByContactNo">By Contact number</label>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-12 px-0">
                    <div class="form-group" id="userEmailContainer">
                      <label class="small mb-1" for="userEmail">Email</label>
                      <input class="form-control py-2" id="userEmail" type="text" name="userEmail"
                             placeholder="Enter email address"/>
                    </div>
<%--                    <div class="form-group" id="userContactNoContainer" style="display: none;">--%>
<%--                      <label class="small mb-1" for="userContactnumber">Contact No.</label>--%>
<%--                      <input class="form-control py-2" id="userContactnumber" name="userContactnumber" type="text"--%>
<%--                             placeholder="Enter contact number"/>--%>
<%--                    </div>--%>
                  </div>
                  <div class="form-group mt-4 mb-0">
                    <a id="sendingProgress" class="btn btn-primary btn-block" style="display: none;">
                      <i id="sendingProgressIcon" class="fas fa-sync fa-spin"></i>
                    </a>
                    <a id="sendMessage" class="btn btn-primary btn-block" href="javascript:void(0)"
                       onclick="$('#forgotPasswordForm').submit()">
                      Reset Password
                    </a>
                  </div>
                </form>
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
