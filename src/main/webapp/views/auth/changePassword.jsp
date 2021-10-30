<!DOCTYPE html>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
    <stag:pageHead pageTitle="Change Password"/>
    <script type="text/javascript" src="/resources/js/services/changePassword.js"></script>
</head>
<stag:securePage loginPage="/views/auth/login.jsp"/>
<body class="bg-primary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Change Password</h3></div>
                            <div class="card-body">
                                <form id="changePassword">
                                    <input name="userType" value="user" type="hidden"/>
                                    <div id="change-errors" class="form-group">
                                        <span class="text-danger"></span>
                                    </div>
                                    <div id="change-success" class="form-group">
                                        <span class="text-success"></span>
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
                                        <a id="changePassword-progress" class="btn btn-primary btn-block" style="display: none;">
                                            <i id="changePassword-progress" class="fas fa-sync fa-spin"></i>
                                        </a>
                                        <a id="changePasswordButton" class="btn btn-primary btn-block" href="javascript:void(0);"
                                           onclick="$('#changePassword').submit()">
                                            Change Password
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
