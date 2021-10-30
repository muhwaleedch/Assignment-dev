<!DOCTYPE html>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
  <stag:pageHead pageTitle="Survey Login"/>
  <script type="text/javascript" src="/resources/js/services/adminLogin.js"></script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
  <div id="layoutAuthentication_content">
    <main>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
              <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
              <div class="card-body">

                <form id="loginForm" action="/action">
                  <div id="login-errors" class="form-group">
                    <span class="text-danger"></span>
                  </div>
                  <div class="form-group">
                    <label class="small mb-1" for="inputEmailAddress">Email/Contact Number</label>
                    <input class="form-control py-2" id="inputEmailAddress" name="username"
                           placeholder="Enter email address or contact no."/>
                  </div>
                  <div class="form-group">
                    <label class="small mb-1" for="inputPassword">Password</label>
                    <input class="form-control py-2" id="inputPassword" type="password" name="password"
                           placeholder="Enter password"/>
                  </div>
                  <%--
                  <div class="form-group">
                      <div class="custom-control custom-checkbox">
                          <input class="custom-control-input" id="rememberPasswordCheck" type="checkbox" />
                          <label class="custom-control-label" for="rememberPasswordCheck">Remember password</label>
                      </div>
                  </div>
                   --%>
                  <div class="form-group mt-4 mb-0">
                    <a id="login-progress" class="btn btn-primary btn-block" style="display: none;">
                      <i id="login-progress" class="fas fa-sync fa-spin"></i>
                    </a>
                    <a id="login-button" class="btn btn-primary btn-block" href="javascript:void(0)"
                       onclick="$('#loginForm').submit()">
                      Login
                    </a>
                  </div>
                </form>
              </div>
              <div class="card-footer text-center">
                <div class="small"><a href="adminRegister.jsp">Need an admin account? Sign up!</a></div>
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
