<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>New Customer</title>
</head>
<body>
<div align="center">
  <h2>Edit IntCmd</h2>
  <form:form action="/intCmdEdit/${intCmdUuid}" method="post" modelAttribute="intCmd">
    <table border="0" cellpadding="6">
      <tr>
        <td>IntCmd IntTypeId:</td>
        <td>
          <form:select path="intCmdIntTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intTypeIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmd IntTypeUuId:</td>
        <td>
          <form:select path="intCmdIntTypeUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intTypeUuids}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>IntCmdCmd:</td>
        <td><form:input path="intCmdCmd" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmdCmd Userfriendlyname:</td>
        <td><form:input path="intCmdCmdUserfriendlyname" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmd Blog:</td>
        <td><form:input path="intCmdBlog" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmd ZebraId:</td>
        <td><form:input path="intCmdZebraId" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmd ZebraUuid:</td>
        <td><form:input path="intCmdZebraUuid" required="required"/></td>
      </tr>
      <tr>
        <td>Updated By</td>
        <td>
          <form:select path="updatedBy">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${userIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Active Status:</td>
        <td>
          <form:select path="activeStatus">
            <form:option value="Y" label="Yes"/>
            <form:option value="N" label="No"/>
          </form:select>
        </td>
      </tr>


      <tr>
        <td colspan="2"><input type="submit" value="Save"></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>