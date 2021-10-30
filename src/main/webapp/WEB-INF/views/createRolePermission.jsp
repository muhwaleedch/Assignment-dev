<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <h2>New Role Permission</h2>
  <form:form action="createRolePermission" method="post" modelAttribute="rolePermission">
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
        <td>CreatedBy:</td>
        <td>
          <form:select path="createdBy">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${userIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="Save"></td>
      </tr>
    </table>
  </form:form>
  <br/><br/>
  <h3>Role Permission List</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>Role PermissionId</th>
      <th>Role PermissionUuid</th>
      <th>RoleId</th>
      <th>PermissionId</th>
      <th>Role PermissionAuthorizationUserId</th>
      <th>Role PermissionAvailableIndicator</th>
      <th>Role PermissionExpirationDate</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${rolePermissionList}" var="rolePermission">
      <tr>
        <td>${rolePermission.rolePermissionId}</td>
        <td>${rolePermission.rolePermissionUuid}</td>
        <td>${rolePermission.roleId}</td>
        <td>${rolePermission.permissionId}</td>
        <td>${rolePermission.rolePermissionAuthorizationUserId}</td>
        <td>${rolePermission.rolePermissionAvailableIndicator}</td>
        <td>${rolePermission.rolePermissionExpirationDate}</td>
        <td>${rolePermission.updatedDts}</td>
        <td>${rolePermission.updatedBy}</td>
        <td>${rolePermission.createdDts}</td>
        <td>${rolePermission.createdBy}</td>
        <td>${rolePermission.activeStatus}</td>
        <td>
          <a href="/rolePermissionEdit/${rolePermission.rolePermissionUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/rolePermissionDelete/${rolePermission.rolePermissionUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</div>
</body>
</html>