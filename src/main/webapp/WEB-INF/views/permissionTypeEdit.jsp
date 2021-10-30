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
  <h2>Edit PermissionType</h2>
  <form:form action="/permissionTypeEdit/${permissionTypeUuid}" method="post" modelAttribute="permissionType">
    <table border="0" cellpadding="6">
      <tr>
        <td>Permission TypeName:</td>
        <td><form:input path="permissionTypeName" required="required"/></td>
      </tr>

      <tr>
        <td>Permission TypeShortDescription:</td>
        <td><form:input path="permissionTypeShortDescription" required="required"/></td>
      </tr>

      <tr>
        <td>Permission TypeDescription:</td>
        <td><form:input path="permissionTypeDescription" required="required"/></td>
      </tr>
      <tr>
        <td>Updated By:</td>
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