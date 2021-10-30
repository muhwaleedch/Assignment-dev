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
  <h2>Edit Permission</h2>
  <form:form action="/permissionEdit/${permissionUuid}" method="post" modelAttribute="permission">
    <table border="0" cellpadding="6">
      <tr>
        <td>Permission Name:</td>
        <td><form:input path="permissionName" required="required"/></td>
      </tr>
      <tr>
        <td>Permission Desc:</td>
        <td><form:input path="permissionDesc" required="required"/></td>
      </tr>
      <tr>
        <td>Permission ResourceId:</td>
        <td>
          <form:select path="permissionResourceId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Permission ResourceUuid:</td>
        <td>
          <form:select path="permissionResourceUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceUuids}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Permission AvailableIndicator</td>
        <td><form:input path="permissionAvailableIndicator" required="required"/></td>
      </tr>
      <tr>
        <td>PermissionCreate:</td>
        <td><form:input path="permissionCreate" required="required"/></td>
      </tr>

      <tr>
        <td>Permission CreatePermissionTypeId:</td>
        <td>
          <form:select path="permissionCreatePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission Delete:</td>
        <td><form:input path="permissionDelete" required="required"/></td>
      </tr>

      <tr>
        <td>Permission DeletePermissionTypeId:</td>
        <td>
          <form:select path="permissionDeletePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission Update:</td>
        <td><form:input path="permissionUpdate" required="required"/></td>
      </tr>
      <tr>
        <td>Permission UpdatePermissionTypeId:</td>
        <td>
          <form:select path="permissionUpdatePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission Read:</td>
        <td><form:input path="permissionRead" required="required"/></td>
      </tr>
      <tr>
        <td>Permission ReadPermissionTypeId:</td>
        <td>
          <form:select path="permissionReadPermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>PermissionSoft Delete:</td>
        <td><form:input path="permissionSoftDelete" required="required"/></td>
      </tr>
      <tr>
        <td>Permission SoftDeletePermissionTypeId:</td>
        <td>
          <form:select path="permissionSoftDeletePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>PermissionOperaterId:</td>
        <td><form:input path="permissionOperaterId" required="required"/></td>
      </tr>
      <tr>
        <td>Permission AuthorizeUserId:</td>
        <td><form:input path="permissionAuthorizeUserId" required="required"/></td>
      </tr>
      <tr>
        <td>Edit By:</td>
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