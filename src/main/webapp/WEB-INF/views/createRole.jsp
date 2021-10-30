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
  <h2>New Role</h2>
  <form:form action="createRole" method="post" modelAttribute="role">
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
  <h3>Role List</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>RoleId</th>
      <th>RoleUuid</th>
      <th>RoleName</th>
      <th>RoleType</th>
      <th>RoleLabel</th>
      <th>RoleIndicator</th>
      <th>RoleAuthUserId</th>
      <th>RoleComments</th>
      <th>RoleGroup</th>
      <th>UpdatedDts</th>
      <th>CreatedDts</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${roleList}" var="role">
      <tr>
        <td>${role.roleId}</td>
        <td>${role.roleUuid}</td>
        <td>${role.roleName}</td>
        <td>${role.roleType}</td>
        <td>${role.roleLabel}</td>
        <td>${role.roleIndicator}</td>
        <td>${role.roleAuthUserId}</td>
        <td>${role.roleComments}</td>
        <td>${role.roleGroup}</td>
        <td>${role.updatedDts}</td>
        <td>${role.createdDts}</td>
        <td>${role.activeStatus}</td>
        <td>
          <a href="/roleEdit/${role.roleUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/roleDelete/${role.roleUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>