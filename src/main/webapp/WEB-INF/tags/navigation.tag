<%@ tag language="java" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<script src="/resources/js/services/navigation.js"></script>
<div id="layoutSidenav_nav">
  <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
      <div class="nav">
        <div class="sb-sidenav-footer">
          <util:profilePicture/>
          <br/>
          <div class="small">Logged in as:</div>
          <span id="userName"></span>
        </div>
        <div class="sb-sidenav-menu-heading profile-completeness-dependent" style="display: none">Survey</div>
        <a class="nav-link profile-completeness-dependent" href="/views/survey/surveyMain.jsp" style="display: none">
          <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
          Answer Survey
        </a>
        <div class="sb-sidenav-menu-heading">Profile Settings</div>
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts"
           aria-expanded="true" aria-controls="collapseLayouts">
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
        <!--
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
