<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<html>
<head>
  <stag:pageHead pageTitle="Profile"/>
  <script type="text/javascript" src="/resources/js/lib/survey.jquery.min.js"></script>
  <script type="text/javascript" src="/resources/js/services/surveyMain.js"></script>
  <link href="/resources/css/modern.css" rel="stylesheet"/>
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
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Survey</h3></div>
          <div class="card-body">
            <util:genericProgressIndicator text="Getting survey data" id="survey-progress" display="block"/>
            <form id="surveyForm" style="display:none;">
              <div id="survey-errors" class="form-group">
                <span class="text-danger"></span>
              </div>
              <div id="survey-success" class="form-group">
                <span class="text-success"></span>
              </div>
              <div class="form-row">
                <ul id="surveys">

                </ul>
              </div>
              <%--
              <div class="form-row">
                <div class="col-md-12">
                  <util:genericProgressIndicator text="Getting survey questions" id="survey-questions-progress" display="none"/>
                    <div id="surveyQuestions">

                    </div>
                  </div>
              </div>
               --%>
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