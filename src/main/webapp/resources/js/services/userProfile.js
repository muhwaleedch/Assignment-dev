/**
 *
 */

$(document).ready(function () {
  fetchProfileDetails();
});

//########################## PROFILE CALLBACKS ################################
const updateProfileCallBack = (response) => {
  if (response.status !== 200) {
    $("#profile-errors").show();
    $("#profile-success").hide();
    $("#profile-errors").find("span").text(response.message);
    $("#profile-save-progress").hide();
    $("#profile-save-button").show();
  } else {
    $("#profile-errors").hide();
    $("#profile-success").show();
    $("#profile-success").find("span").text("User profile updated successfully.");
    $("#profile-save-progress").hide();
    $("#profile-save-button").show();
  }
};

const profileDetailsCallback = (response) => {
  $("#profile-progress").hide();
  if (response.status !== 200) {
    $("#profile-error-message").find("span").text(response.message);
  } else {
    $("#profileForm").show();
    $("#userFirstName").val(response.data.data.userFirstName);
    $("#userLastName").val(response.data.data.userLastName);
    $("#userMiddleName").val(response.data.data.userMiddleName);
    $("#userEmail").val(response.data.data.userEmail);
    $("#userContactnumber").val(response.data.data.userContactnumber);
    $("#userUuid").val(response.data.data.userUuid);
    registerProfileValidation();
  }
}

//####################### PROFILE BUSINESS DETAILS ####################################################

function fetchProfileDetails() {
  const jwtToken = JwtDAO.getInstance().getJWT();
  const userAuthUserId = parseJwt(jwtToken).sub;
  const request = {
    api: 'survey/user/findUserByUserUserId?userUserId=' + userAuthUserId,
    requestBody: '',
    serviceCallback: profileDetailsCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)

}


function registerProfileValidation() {

  $("#profileForm").validate({
    errorClass: 'text-danger',
    rules: {
      userEmail: {
        required: true,
        email: true
      },
      userContactnumber: {
        required: true
      },
      userPassword: {
        required: false
      },
      confirmPassword: {
        required: false,
        equalTo: "#userPassword"
      },
      userFirstName: {
        required: true
      },
      userLastName: {
        required: true
      }
    },
    // Specify validation error messages
    messages: {
      userEmail: {
        required: "Please provide your email address",
        email: "Please provide valid email address"
      },
      userContactnumber: {
        required: "Please provide a contact number"
      },
      userPassword: {
        required: "Please provide a password"
      },
      confirmPassword: {
        required: "Please provide confirm password",
        equalTo: "Please enter same password"
      },
      userFirstName: {
        required: "Please provide First name"
      },
      userLastName: {
        required: "Please provide Last name"
      }
    },
    submitHandler: function (form) {
      $("#profile-save-progress").show();
      $("#profile-save-button").hide();
      var formData = new FormData(form);
      const value = Object.fromEntries(formData.entries());
      const jwtToken = JwtDAO.getInstance().getJWT();
      const request = {
        api: 'survey/user/updateUser',
        requestBody: value,
        serviceCallback: updateProfileCallBack,
        jwt: jwtToken
      }
      //console.log('Request json', request);
      RestClient.getInstance().post(request);
    }
  });

}