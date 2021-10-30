<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<html>
<head>
  <stag:pageHead pageTitle="Profile"/>
  <script type="text/javascript" src="/resources/js/components/AddressComponent.js"></script>
  <script type="text/javascript" src="/resources/js/services/userAddresses.js"></script>
</head>
<body>
<stag:securePage loginPage="/views/auth/login.jsp"/>
<stag:topNavigation/>
<div id="layoutSidenav">
  <stag:navigation/>
  <div id="layoutSidenav_content">
    <main>
      <div class="container-fluid">
        <div class="card mb-4">
          <div class="card-header"><h3 class="text-center font-weight-light my-1">Address details</h3></div>
          <div class="card-body">
            <util:genericProgressIndicator text="Getting address data" id="address-progress" display="block"/>
            <div id="address-error-message" style="text-align: center;">
              <span></span>
            </div>
            <form id="addressForm" style="display:none;">
              <input type="hidden" id="userUuid" name="userUuid"/>
              <div id="address-form-body">
                <div class="form-group mt-4 mb-0" style="text-align: right;">
                  <a id="profile-save-button" class="btn btn-primary" href="javascript:void(0);"
                     onclick="javascript:addNewAddress();">
                    Additional Addresses
                  </a>
                </div>
              </div>
              <div class="dropdown-divider"></div>
              <div class="form-group mt-4 mb-0" style="text-align: right;">
                <a id="profile-save-button" class="btn btn-primary" href="javascript:void(0);"
                   onclick="javascript:addNewAddress();">
                  Additional Addresses
                </a>
              </div>

            </form>
          </div>
        </div>
      </div>
    </main>
    <stag:pageFooter/>
  </div>
</div>
<stag:footer/>
</body>
</html>