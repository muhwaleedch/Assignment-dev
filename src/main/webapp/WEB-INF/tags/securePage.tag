<%@ tag language="java" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<%@ attribute name="loginPage" required="true" %>


<script type="text/javascript">
    if (JwtDAO.getInstance().getJWT() === null) {
        doRedirect("${loginPage}");
    } else if (JwtDAO.getInstance().getJWT() !== null && UserProfileDAO.getInstance().getUserResetPassword() !== "N" && window.location.href.indexOf("changePassword.jsp") === -1) {
      doRedirect("/views/auth/changePassword.jsp");
    } else {
        //extract info from JWT
    }
</script>