<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<html>
<head>
  <stag:pageHead pageTitle="Admin"/>
  <script type="text/javascript" src=""></script>
</head>
<body>
<stag:securePage loginPage="/views/auth/adminLogin.jsp"/>
<stag:topNavigation/>
<div id="layoutSidenav">
  <admin:navigation/>
  <div id="layoutSidenav_content">
    <main>

      <div class="container-fluid">

        <div class="card mb-4">
          
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Admin details</h3></div>
          <div class="card-body">
            <util:genericProgressIndicator text="Getting profile data" id="profile-progress" display="none"/>
            <div id="admin-error-message" style="text-align: center;">
              <span></span>
            </div>

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
