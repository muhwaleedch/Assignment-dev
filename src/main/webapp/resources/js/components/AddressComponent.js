/**
 *
 */
class AddressComponent {

  constructor(addressUuid, addressLine1, addressLine2, addressLine3, state, city, country, zipCode, addressType) {
    this.addressUuid = addressUuid;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.addressLine3 = addressLine3;
    this.state = state;
    this.city = city;
    this.country = country;
    this.zipCode = zipCode;
    this.addressFormId = 'address_form_' + addressUuid;
    this.addressType = addressType;
    this.defaultAddressTypeUuid = defaultAddressTypeUuid;
  }

  static loadStatesByCountryId(countryDropdown) {
    const jwtToken = JwtDAO.getInstance().getJWT();
    $(countryDropdown).closest("form").find("#state").prop("disabled", true);
    $(countryDropdown).closest("form").find("#state").html("");
    const request = {
      api: encodeURI('metadata/findStatesByCountryUuid/' + $(countryDropdown).val()),
      requestBody: '',
      serviceCallback: function (response) {
        if (response.status !== 200 && response.status !== 404) {
          alert("Some error occured while fetching states information");
        } else if (response.status === 404) {
          $(countryDropdown).closest("form").find("#state").append($('<option>', {
            value: 'n/a',
            text: 'N/A'
          }));
        } else {
          response.data.data.forEach(element => {
            $(countryDropdown).closest("form").find("#state").append($('<option>', {
              value: element.statesUuid,
              text: element.name
            }));
          });
        }
        $(countryDropdown).closest("form").find("#state").prop("disabled", false);
        $(countryDropdown).closest("form").find("#state").val($(countryDropdown).closest("form").find("#stateUuidHidden").val());
      },
      jwt: jwtToken
    };
    RestClient.getInstance().get(request);
  }

  registerDeleteButtonHanlder() {
    $("#" + this.addressFormId).find("#address-delete-button").click(function () {
      var form = $(this).closest("form");
      var addressUuid = $(form).find("#addressUuid").val();
      if (addressUuid.endsWith("_new")) {
        $(form).remove();
      } else {
        $(form).find("#address-delete-progress").show();
        $(form).find("#address-delete-button").hide();
        $(form).find("#address-save-button").hide();
        const jwtToken = JwtDAO.getInstance().getJWT();
        const request = {
          api: 'survey/user/deleteUserAddress/' + addressUuid,
          requestBody: '',
          serviceCallback: function (response) {
            if (response.status !== 200) {
              $(form).find("#address-errors").find("span").text(response.message);
            } else {
              $(form).remove();
            }
            $(form).find("#address-delete-progress").hide();
            $(form).find("#address-delete-button").show();
            $(form).find("#address-save-button").show();
            forceCheckProfileCompleteness();
          },
          jwt: jwtToken
        }
        RestClient.getInstance().get(request);
      }
    });
  }

  registerFormValidation() {

    $("#" + this.addressFormId).validate({
      errorClass: 'text-danger',
      rules: {
        addressType: {
          required: true
        },
        zipcode: {
          required: true,
          digits: true
        },
        addressLine1: {
          required: true
        },
        addressLine2: {
          required: false
        },
        addressLine3: {
          required: false
        },
        city: {
          required: true
        },
        state: {
          required: true
        },
        country: {
          required: true
        }
      },
      // Specify validation error messages
      messages: {
        addressType: {
          required: 'Please select address type'
        },
        zipcode: {
          required: 'Please enter zip code'
        },
        addressLine1: {
          required: 'Please enter address line 1'
        },
        city: {
          required: 'Please enter city'
        },
        state: {
          required: 'Please select a state'
        },
        country: {
          required: 'Please select a country'
        }
      },
      submitHandler: function (form) {
        $(form).find("#address-save-progress").show();
        $(form).find("#address-save-button").hide();
        $(form).find("#address-delete-button").hide();
        var formData = new FormData(form);
        const value = Object.fromEntries(formData.entries());
        const jwtToken = JwtDAO.getInstance().getJWT();
        const request = {
          api: 'survey/user/saveUserAddress',
          requestBody: value,
          serviceCallback: function (response) {
            if (response.status !== 200) {
              $(form).find("#address-errors").find("span").text(response.message);
              $(form).find("#address-success").find("span").text("");
            } else {
              $(form).find("#address-errors").find("span").text("");
              $(form).find("#address-success").find("span").text('Address updated successfully');
              var newAddressUuid = response.data.addressUuid;
              $(form).find("#addressUuid").val(newAddressUuid);
            }
            $(form).find("#address-save-progress").hide();
            $(form).find("#address-save-button").show();
            $(form).find("#address-delete-button").show();
            forceCheckProfileCompleteness();
          },
          jwt: jwtToken
        }
        RestClient.getInstance().post(request);
      }
    });

  }

  getAddressMarkup() {
    return '<input id="addressUuid" type="hidden" name="addressUuid" />' +
        '<input id="stateUuidHidden" type="hidden" name="stateUuidHidden" />' +
        '<input id="addressSourceSystem" type="hidden" name="addressSourceSystem" value="WEB" />' +
        '<input id="addressSourceType" type="hidden" name="addressSourceType" value="SURVEY" />' +
        '<input id="stateUuidHidden" type="hidden" name="stateUuidHidden" />' +
        '<input id="addressLine3" name="addressLine3" type="hidden" value="N/A" />' +
        '<div class="dropdown-divider"></div>' +
        '<div id="address-errors" class="form-group">' +
        '	<span class="text-danger"></span>' +
        '</div>' +
        '<div id="address-success" class="form-group">' +
        '	<span class="text-success"></span>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for=""addressType"">Address Type</label>' +
        '            <select class="form-control" id="addressType" name="addressType">' +
        '		        <!-- <option value="primary">Primary</option> --> ' +
        '		        <!-- <option value="billing">Billing</option> --> ' +
        '		      </select>' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for=addressLine1>Address Line 1</label>' +
        '            <input class="form-control py-2" id="addressLine1" type="text" name="addressLine1" placeholder="Enter Address line 1" />' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="addressLine2">Address Line 2</label>' +
        '            <input class="form-control py-2" id="addressLine2" name="addressLine2" type="text" placeholder="Enter Address line 2" />' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '' +
        '<div class="form-row">' +
        '   <div class="col-md-6">' +
        '       <div class="form-group">' +
        '            <label class="small mb-1" for="city">City</label>' +
        '		      <input class="form-control py-2" id="city" name="city" type="text" placeholder="Enter city" />' +
        '       </div>' +
        '    </div>' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="zipcode">Zip Code</label>' +
        '            <input class="form-control py-2" id="zipcode" type="text" name="zipcode" placeholder="Enter zip code" />' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '<div class="form-row">' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="state">State/Province</label>' +
        '		      <select class="form-control" id="state" name="state">' +
        '		        <option value="" selected>Select State</option>' +
        '		        <! --<option value="dl">DL</option> -->' +
        '		      </select>' +
        '        </div>' +
        '    </div>' +
        '    <div class="col-md-6">' +
        '        <div class="form-group">' +
        '            <label class="small mb-1" for="country">Country</label>' +
        '		      <select class="form-control" id="country" name="country" onchange="javascript:AddressComponent.loadStatesByCountryId(this)">' +
        '		         <option value="" selected>Select Country</option>' +
        '		        <!-- <option value="pakistan">Pakistan</option> -->' +
        '		      </select>' +
        '        </div>' +
        '    </div>' +
        '</div>' +
        '<div class="form-group mt-4 mb-0" style="text-align: right;">' +
        '	<a id="address-save-progress" class="btn btn-primary" style="display: none;">' +
        '    	<i id="address-save-progress" class="fas fa-sync fa-spin"></i> Saving ' +
        '    </a>' +
        '	<a id="address-save-button" class="btn btn-primary" href="javascript:void(0);" onclick="$(\'#' + this.addressFormId + '\').submit();" style="display: inline;"> ' +
        '		Save Address ' +
        '	</a> &nbsp; &nbsp;' +
        '	<a id="address-delete-progress" class="btn btn-danger" href="javascript:void(0);" style="display: none;"> ' +
        '		<i id="address-delete-progress" class="fas fa-sync fa-spin"></i> Deleting ' +
        '	</a> ' +
        '	<a id="address-delete-button" class="btn btn-danger" href="javascript:void(0);" style="display: inline;"> ' +
        '		Delete Address ' +
        '	</a> ' +
        '</div>'
  }

  getAddressFormMarkup() {
    return '<form id="' + this.addressFormId + '" >' +
        this.getAddressMarkup() +
        '</form>';

  }

  render(id) {
    $(id).append(this.getAddressFormMarkup());
    var countries = MetadataDAO.getInstance().getCountries();
    var addressTypes = MetadataDAO.getInstance().getAddressTypes();
    if (countries !== undefined) {
      countries.forEach(element => {
        $("#" + this.addressFormId).find("#country").append($('<option>', {
          value: element.countriesUuid + '|' + element.iso3,
          text: element.name
        }));
      });
    }

    if (addressTypes !== undefined) {
      addressTypes.forEach(element => {
        if (this.addressType === this.defaultAddressTypeUuid) {
          $("#" + this.addressFormId).find("#addressType").append($('<option>', {
            value: element.addressTypeUuid,
            text: element.addressTypeName
          }));
        } else {
          if (element.addressTypeUuid !== this.defaultAddressTypeUuid) {
            $("#" + this.addressFormId).find("#addressType").append($('<option>', {
              value: element.addressTypeUuid,
              text: element.addressTypeName
            }));
          }
        }
      });
    }

    this.registerFormValidation();
    this.registerDeleteButtonHanlder();

    $("#" + this.addressFormId).find("#addressType").val(this.addressType);
    $("#" + this.addressFormId).find("#addressLine1").val(this.addressLine1);
    $("#" + this.addressFormId).find("#addressLine2").val(this.addressLine2);
    $("#" + this.addressFormId).find("#addressLine3").val(this.addressLine3);
    if (this.state !== '') {
      $("#" + this.addressFormId).find("#state").val(this.state);
      $("#" + this.addressFormId).find("#stateUuidHidden").val(this.state);
    }
    $("#" + this.addressFormId).find("#city").val(this.city);
    if (this.country !== '') {
      $("#" + this.addressFormId).find("#country").val(this.country).trigger('change');
    }
    $("#" + this.addressFormId).find("#zipcode").val(this.zipCode);
    $("#" + this.addressFormId).find("#addressUuid").val(this.addressUuid);
  }

}