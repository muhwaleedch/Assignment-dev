<%@ tag language="java" pageEncoding="ISO-8859-1" %>

<script type="text/javascript">
    $(document).ready(function () {
        const userName = UserProfileDAO.getInstance().getUserName();
        $("#userName").text(userName);
    });
</script>

<div id="layoutSidenav_nav">
  <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
      <div class="nav">
        <div class="sb-sidenav-footer">
          <br/>
          <div class="small">Logged in as:</div>
          <span id="userName"></span>
        </div>
        <div class="sb-sidenav-menu-heading" style="display: block">Survey</div>
        <a class="nav-link" href="/views/survey/createSurvey.jsp" style="display: block">
          <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
          Create Survey
        </a>
        <a class="nav-link" href="/views/survey/createForm.jsp" style="display: block">
          <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
          Create Forms
        </a>
        <a class="nav-link" href="/views/survey/createQuestions.jsp" style="display: block">
          <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
          Create Questions
        </a>
        <!--
        <div class="sb-sidenav-menu-heading">Profile Settings</div>
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="true" aria-controls="collapseLayouts">
            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
            User Profile
            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
        </a>
        <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
            <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link" href="/views/user/userProfile.jsp">Personal Information</a>
                <a class="nav-link" href="/views/user/userAddresses.jsp">Address Information</a>
                <a class="nav-link" href="/views/user/userAttachments.jsp">Attachements</a>
            </nav>
        </div>

        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
            <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
            Pages
            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
        </a>

        <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
            <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                    Authentication
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="login.html">Login</a>
                        <a class="nav-link" href="register.html">Register</a>
                        <a class="nav-link" href="password.html">Forgot Password</a>
                    </nav>
                </div>
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                    Error
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="401.html">401 Page</a>
                        <a class="nav-link" href="404.html">404 Page</a>
                        <a class="nav-link" href="500.html">500 Page</a>
                    </nav>
                </div>
            </nav>
        </div>

        <div class="sb-sidenav-menu-heading">Settings</div>
        <a class="nav-link" href="/views/user/userProfile.jsp">
            <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
            User Profile
        </a>
        -->
      </div>
    </div>
  </nav>
</div>
