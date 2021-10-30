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
  <h2>Edit Role</h2>
  <form:form action="/roleEdit/${role.roleUuid}" method="post" modelAttribute="role">
    <table border="0" cellpadding="6">
      <tr>
        <td>Role Name:</td>
        <td><form:input path="roleName" required="required"/></td>
      </tr>

      <tr>
        <td>Role Type:</td>
        <td><form:input path="roleType" required="required"/></td>
      </tr>

      <tr>
        <td>Role Label:</td>
        <td><form:input path="roleLabel" required="required"/></td>
      </tr>

      <tr>
        <td>Role Indicator:</td>
        <td><form:input path="roleIndicator" required="required"/></td>
      </tr>

      <tr>
        <td>Role AuthUserId:</td>
        <td><form:input path="roleAuthUserId" required="required"/></td>
      </tr>

      <tr>
        <td>RoleComments:</td>
        <td><form:input path="roleComments" required="required"/></td>
      </tr>

      <tr>
        <td>RoleGroup:</td>
        <td>
          <form:select path="roleGroup">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${groupIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>UpdatedBy:</td>
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