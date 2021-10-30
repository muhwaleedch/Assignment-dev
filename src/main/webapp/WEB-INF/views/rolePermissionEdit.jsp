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
  <h2>Edit Role Permission</h2>
  <form:form action="/rolePermissionEdit/${rolePermission.rolePermissionUuid}" method="post"
             modelAttribute="rolePermission">
    <table border="0" cellpadding="6">
      <tr>
        <td>Role Id:</td>
        <td>
          <form:select path="roleId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${roleIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission Id:</td>
        <td>
          <form:select path="permissionId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Role PermissionAuthorizationUserId:</td>
        <td><form:input path="rolePermissionAuthorizationUserId" required="required"/></td>
      </tr>

      <tr>
        <td>Role PermissionAvailableIndicator:</td>
        <td><form:input path="rolePermissionAvailableIndicator" required="required"/></td>
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