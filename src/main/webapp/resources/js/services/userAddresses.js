/**
 *
 */

$(document).ready(function () {

  if (MetadataDAO.getInstance().getCountries() === null) {
    fetchMetadata('findAllCountries', countryFetchCallback);
  } else if (MetadataDAO.getInstance().getAddressTypes() === null) {
    fetchMetadata('findAllAddressTypes', addressTypeFetchCallback);
  } else {
    fetchAddressDetails();
  }
});

//####################### ADDRESS BUSINESS DETAILS ####################################################

countryFetchCallback = (response) => {

  if (response.status !== 200) {
    $("#address-error-message").find("span").text(response.message);
  } else {

    MetadataDAO.getInstance().saveCountries(response.data.data);
    fetchMetadata('findAllAddressTypes', addressTypeFetchCallback);
  }
}

addressTypeFetchCallback = (response) => {
  if (response.status !== 200) {
    $("#address-error-message").find("span").text(response.message);
  } else {
    MetadataDAO.getInstance().saveAddressTypes(response.data.data);
    fetchAddressDetails();
  }
}

function fetchMetadata(api, callback) {
  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'metadata/' + api,
    requestBody: '',
    serviceCallback: callback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request);
}

function fetchAddressDetails() {
  //addressDetailsCallback({status: 200});

  const jwtToken = JwtDAO.getInstance().getJWT();
  const request = {
    api: 'survey/user/findUserAddress',
    requestBody: '',
    serviceCallback: addressDetailsCallback,
    jwt: jwtToken
  }
  RestClient.getInstance().get(request)

}


//########################## PROFILE CALLBACKS ################################

const addressDetailsCallback = (response) => {
  if (response.status !== 200) {
    $("#address-error-message").find("span").text(response.message);
  } else {
    var addresses = response.data.data;
    //var address;
    var createEmptyPrimaryAddress = true;
    addresses.forEach(element => {
      if (element.addressType === defaultAddressTypeUuid) {
        createEmptyPrimaryAddress = false;
      }
    });
    if (createEmptyPrimaryAddress) {
      var addressPrimary = new AddressComponent(new Date().getTime() + '_new', '', '', 'N/A', '', '', defaultCountryUuid, '', defaultAddressTypeUuid);
      addressPrimary.render("#address-form-body");
    }
    addresses.forEach(element => {
      var address = new AddressComponent(element.addressUuid, element.addressLine1, element.addressLine2, element.addressLine3, element.state, element.city, element.country, element.zipcode, element.addressType);
      address.render("#address-form-body");
    });

    $("#addressForm").show();
  }
  $("#address-progress").hide();
}

const addNewAddress = () => {
  var address1 = new AddressComponent(new Date().getTime() + '_new', '', '', 'N/A', '', '', defaultCountryUuid, '', '');
  address1.render("#address-form-body");
}