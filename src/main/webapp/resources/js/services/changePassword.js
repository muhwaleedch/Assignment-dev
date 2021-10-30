let isResetCall = "n";

//########################## PROFILE CALLBACKS ################################
const updateProfileCallBack = (response) => {
  if (response.status !== 200) {
    $("#change-success").find("span").text(response.message)
  } else {
    $("#changePassword-progress").hide();
    $("#changePasswordButton").show();
    UserProfileDAO.getInstance().saveUserResetPassword("N");
    doRedirect("/views/user/userProfile.jsp");
  }
};

$(document).ready(function () {
  $("#changePassword").validate({
    errorClass: 'text-danger',
    rules: {
      userPassword: {
        required: true
      },
      confirmPassword: {
        required: true,
        equalTo: "#userPassword"
      },
    },
    // Specify validation error messages
    messages: {

      userPassword: {
        required: "Please provide a password"
      },
      confirmPassword: {
        required: "Please provide confirm password",
        equalTo: "Please enter same password"
      },

    },
    submitHandler: function (form) {
      console.log('this is called')
      $("#changePassword-progress").show();
      $("#changePasswordButton").hide();
      var formData = new FormData(form);
      const value = Object.fromEntries(formData.entries());
      const jwtToken = JwtDAO.getInstance().getJWT();
      if (isResetCall && value.userPassword.length !== 0) {
        value.userPasswordReset = "N"
      }
      const request = {
        api: 'survey/user/change-password',
        requestBody: value,
        serviceCallback: updateProfileCallBack,
        jwt: jwtToken
      }
      //console.log('Request json', request);
      RestClient.getInstance().post(request);
    }
  });
})