$(document).ready(() => {
  $("#forgotPasswordForm").validate({
    errorClass: "text-danger",
    rules: {
      userEmail: {
        required: "#registerByEmail:checked",
        email: true
      },
      userContactnumber: {
        required: "#registerByContactNo:checked",
      }
    },
    messages: {
      userEmail: {
        required: "Please provide your email address",
        email: "Please provide valid email address"
      },
      userContactnumber: {
        required: "Please provide a contact number"
      }
    },
    submitHandler: (form) => {
      $("#sendingProgress").show();
      $("#sendMessage").hide();
      const value = Object.fromEntries(new FormData(form).entries());
      const request = {
        api: `survey/user/forgot-password?userEmail=${value.userEmail}&type=${value.registerBy}`,
        serviceCallback: (response) => {
          $("#sendingProgress").hide();
          $("#sendMessage").show();
          console.log('response', response);
          if (response.status !== 200) {
            $("#loginError").find("span").text(response.message)
          } else {
            $("#loginError").find("span").text(response.data.message)
            doRedirect("/views/auth/login.jsp");
          }
        },
        jwt: ''
      }
      RestClient.getInstance().get(request);
    }
  });
});