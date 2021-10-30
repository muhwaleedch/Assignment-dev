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
  <h2>New UserRoleMapping</h2>
  <form:form action="createUserRolemapping" method="post" modelAttribute="userRoleMapping">
    <table border="0" cellpadding="6">
      <tr>
        <td>RoleId:</td>
        <td>
          <form:select path="roleId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${roleIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>UserId:</td>
        <td>
          <form:select path="userId">
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
  <h3>User Role Mapping Mapping List</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>Id</th>
      <th>Role Id</th>
      <th>UserId</th>
      <th>UpdatedDts</th>
      <th>CreatedDts</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userRoleMappingList}" var="userRoleMapping">
      <tr>
        <td>${userRoleMapping.id}</td>
        <td>${userRoleMapping.roleId}</td>
        <td>${userRoleMapping.userId}</td>
        <td>${userRoleMapping.updatedDts}</td>
        <td>${userRoleMapping.createdDts}</td>
        <td>${userRoleMapping.activeStatus}</td>
        <td>
          <a href="/userRolemappingEdit/${userRoleMapping.id}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/userRolemappingDelete/${userRoleMapping.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>