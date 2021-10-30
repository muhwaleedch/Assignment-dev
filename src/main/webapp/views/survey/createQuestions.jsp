<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<html>
<head>
  <stag:pageHead pageTitle="Create Questions"/>
  <script type="text/javascript" src="/resources/js/components/QuestionsComponent.js"></script>
  <script type="text/javascript" src="/resources/js/services/createQuestions.js"></script>
  <link href="/resources/css/modern.css" rel="stylesheet"/>
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
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Questions</h3></div>
          <div class="card-body">
            <util:genericProgressIndicator text="Getting questions data" id="question-progress" display="block"/>
            <div id="form-error-message" style="text-align: center;">
              <span></span>
            </div>
            <div id="questions" style="display: none;">
              <div class="form-group mt-4 mb-0" style="text-align: right;">
                <a id="form-add-button1" class="btn btn-primary" href="javascript:void(0);"
                   onclick="javascript:addNewQuestion();">
                  Add Question
                </a>
              </div>
              <div class="dropdown-divider"></div>
              <table>
                <thead>
                <tr>
                  <th style="width: 44%;">Question Name</th>
                  <th style="width: 44%;">Question Text</th>
                  <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </main>
    <stag:pageFooter/>
  </div>
</div>
<stag:footer/>

<!-- Modal -->
<div id="newForm" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>

      </div>
      <div id="new-form-questions" class="modal-body">

      </div>
      <!--
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
       -->
    </div>

  </div>
</div>
</body>
</html>