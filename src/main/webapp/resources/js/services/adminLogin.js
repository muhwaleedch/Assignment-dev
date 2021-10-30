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
    JwtDAO.getInstance().saveJWT(token);
    UserProfileDAO.getInstance().saveUserName(userName);
    doRedirect("/views/survey/createSurvey.jsp");
    //alert('Redirect in progress');
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
        api: 'survey/admin/authenticate',
        requestBody: value,
        serviceCallback: loginDAOResponseCallback,
        jwt: ''
      }
      RestClient.getInstance().post(request);
    }
  });
});