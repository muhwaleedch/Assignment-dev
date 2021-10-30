/**
 *
 */

const loginDAOResponseCallback = (response) => {
  if (response.status !== 200) {
    $("#login-errors").find("span").text("Invalid Email/Contact No or Password");
    $("#login-progress").hide();
    $("#login-button").show();
  } else {
    const token = response.data.jwt;
    const userName = response.data.userName;
    const userPasswordReset = response.data.userPasswordReset;
    JwtDAO.getInstance().saveJWT(token);
    UserProfileDAO.getInstance().saveUserName(userName);
    UserProfileDAO.getInstance().saveUserResetPassword(userPasswordReset)
    if (userPasswordReset === "N") {
      doRedirect("/views/user/userProfile.jsp");
    } else {
      doRedirect("/views/auth/changePassword.jsp");
    }
  }
};

$(document).ready(function () {
  $("#loginForm").validate({
    errorClass: 'text-danger',
    rules: {
      username: "required",
      password: {
        required: true
        //minlength: 5
      }
    },
    // Specify validation error messages
    messages: {
      username: "Please enter Email address/Contact no.",
      password: {
        required: "Please provide a password"
        //minlength: "Your password must be at least 5 characters long"
      }
    },
    submitHandler: function (form) {
      //form.submit();
      $("#login-progress").show();
      $("#login-button").hide();
      var formData = new FormData(form);
      const value = Object.fromEntries(formData.entries());
      const request = {
        api: 'survey/user/authenticate',
        requestBody: value,
        serviceCallback: loginDAOResponseCallback,
        jwt: ''
      }
      RestClient.getInstance().post(request);
    }
  });
});