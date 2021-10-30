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
  <h2>New User Role</h2>
  <form:form action="createUserRole" method="post" modelAttribute="userRole">
    <table border="0" cellpadding="6">
      <tr>
        <td>Permission Id:</td>
        <td><form:input path="permissionId" required="required"/></td>
      </tr>

      <tr>
        <td>UserId:</td>
        <td><form:input path="userId" required="required"/></td>
      </tr>

      <tr>
        <td>User RoleAuthorizationUserId:</td>
        <td><form:input path="userRoleAuthorizationUserId" required="required"/></td>
      </tr>

      <tr>
        <td>User RoleAvailableIndicator:</td>
        <td><form:input path="userRoleAvailableIndicator" required="required"/></td>
      </tr>
      <tr>
        <td>Created By:</td>
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
  <br><br>
  <h3>User Role List</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>User RoleId</th>
      <th>User RoleUuid</th>
      <th>PermissionId</th>
      <th>UserId</th>
      <th>User RoleAuthorizationUserId</th>
      <th>User RoleAvailableIndicator</th>
      <th>User RoleExpirationDate</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userRoleList}" var="userRole">
      <tr>
        <td>${userRole.userRoleId}</td>
        <td>${userRole.userRoleUuid}</td>
        <td>${userRole.permissionId}</td>
        <td>${userRole.userId}</td>
        <td>${userRole.userRoleAuthorizationUserId}</td>
        <td>${userRole.userRoleAvailableIndicator}</td>
        <td>${userRole.userRoleExpirationDate}</td>
        <td>${userRole.updatedDts}</td>
        <td>${userRole.updatedBy}</td>
        <td>${userRole.createdDts}</td>
        <td>${userRole.createdBy}</td>
        <td>${userRole.activeStatus}</td>
        <td>
          <a href="/userRoleEdit/${userRole.userRoleUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/userRoleDelete/${userRole.userRoleUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</div>
</body>
</html>