<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="stag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <stag:pageHead pageTitle="User Attachment"></stag:pageHead>

  <script type="text/javascript">

      $(document).ready(function () {
          var urlParams = new URLSearchParams(window.location.search);
          var opener = window.opener;
          if (opener) {
              var oDom = opener.document;
              var elem = oDom.getElementById(urlParams.get("attachment"));
              if (elem) {
                  $("#attachment_zoom_pic").attr("src", elem.src);
              }
          }
      });
  </script>

</head>
<body>

<img id="attachment_zoom_pic"/>

</body>
</html>