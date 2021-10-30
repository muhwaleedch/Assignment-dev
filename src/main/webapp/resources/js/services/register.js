/**
 *
 */

const registerDAOResponseCallback = (response) => {
  if (response.status !== 200) {
    $("#register-errors").show();
    $("#register-success").hide();
    $("#register-errors").find("span").text(response.message);
    $("#register-progress").hide();
    $("#register-button").show();
  } else {
    $("#register-errors").hide();
    $("#register-success").show();
    $("#register-success").find("span").text("User has been registered successfully");
    $("#register-progress").hide();
    $("#register-button").show();
  }
};

function onClickByEmailOption() {
  $("#userEmailContainer").show();
  $("#userContactNoContainer").hide();
}

function onClickByContactNoOption() {
  $("#userEmailContainer").hide();
  $("#userContactNoContainer").show();
}

$(document).ready(function () {


  $("#registerForm").validate({
    errorClass: 'text-danger',
    rules: {
      userEmail: {
        required: "#registerByEmail:checked",
        email: true
      },
      userContactnumber: {
        required: "#registerByContactNo:checked"
      },
      userPassword: {
        required: true
      },
      confirmPassword: {
        required: true,
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
      $("#register-progress").show();
      $("#register-button").hide();
      var formData = new FormData(form);
      const value = Object.fromEntries(formData.entries());
      const request = {
        api: 'survey/user/register',
        requestBody: value,
        serviceCallback: registerDAOResponseCallback,
        jwt: ''
      }
      RestClient.getInstance().post(request);
    }
  });
});