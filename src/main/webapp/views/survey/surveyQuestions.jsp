<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<html>
<head>
  <stag:pageHead pageTitle="Profile"/>
  <script type="text/javascript" src="/resources/js/lib/survey.jquery.min.js"></script>
  <script type="text/javascript" src="/resources/js/services/surveyQuestions.js"></script>
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
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Survey Form</h3></div>
          <div class="card-body">
            <div id="survey-errors" class="form-group">
              <span class="text-danger"></span>
            </div>
            <div id="survey-success" class="form-group">
              <span class="text-success"></span>
            </div>
            <div class="row" id="surveyNameDiv" style="margin-left: 4.30rem;">
              <div class="col-md-8">
                <div class="form-group">
                  <label class="small mb-1" for="surveyName">Set your form Name</label>
                  <input class="form-control py-2" id="surveyName" type="text" name="surveyName"
                         placeholder="Enter your form name"/>
                </div>
              </div>
              <div class="col-md-2">
                <div class="form-group" style="margin-top: 1.3rem;">
                  <label class="small mb-1" for="surveyName">&nbsp;</label>
                  <a id="profile-save-button" class="btn btn-primary" href="javascript:void(0);"
                     onclick="javascript:clearFormName();">
                    Change form name
                  </a>
                </div>
              </div>
              <div class="col-md-2">
                <div class="form-group" style="margin-top: 1.3rem;">
                  <label class="small mb-1" for="surveyName">&nbsp;</label>
                  <a id="profile-save-button" class="btn btn-primary" href="javascript:void(0);"
                     onclick="javascript:preFetchSurveyQuestions();">
                    Pull survey form
                  </a>
                </div>
              </div>
            </div>
            <util:genericProgressIndicator text="Getting survey questions" id="survey-questions-progress"
                                           display="none"/>
            <div id="surveyQuestions" style="display:none;">
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