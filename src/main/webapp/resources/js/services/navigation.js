/**
 *
 */
$(document).ready(function () {
  checkProfileCompleteness();
  const userName = UserProfileDAO.getInstance().getUserName();
  $("#userName").text(userName);
});

forceCheckProfileCompleteness = () => {
  const jwtToken = JwtDAO.getInstance().getJWT();
  if (jwtToken !== null) {
    const request = {
      api: 'survey/user/findUserAddress',
      requestBody: '',
      serviceCallback: profileCompletenessRequestCallback,
      jwt: jwtToken
    }
    RestClient.getInstance().get(request);
  }
}

profileCompletenessRequestCallback = (response) => {
  if (response.status !== 200) {
    alert("Some error occurred while checking profile completeness. Please contact support.");
    console.error(response.message);
    UserProfileDAO.getInstance().profileCompletedFalse();
    profileCompletenessActions("false");
  } else {

    var profileCompleted = "false";
    var addresses = response.data.data;
    addresses.forEach(element => {
      if (element.addressType === defaultAddressTypeUuid) {
        profileCompleted = "true";
      }
    });

    profileCompletenessActions(profileCompleted);
  }
}

checkProfileCompleteness = () => {
  if (UserProfileDAO.getInstance().getProfileCompletedStatus() !== null) {
    profileCompletenessActions(UserProfileDAO.getInstance().getProfileCompletedStatus());
  } else {
    forceCheckProfileCompleteness();
  }
}

profileCompletenessActions = (profileCompleted) => {
  if (profileCompleted === "true") {
    $(".profile-completeness-dependent").show();
    UserProfileDAO.getInstance().profileCompletedTrue();
  } else {
    $(".profile-completeness-dependent").hide();
    UserProfileDAO.getInstance().profileCompletedFalse();
  }
}
