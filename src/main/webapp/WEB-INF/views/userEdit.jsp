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
  <h2>Edit User</h2>
  <form:form action="/userEdit/${userUuid}" method="post" modelAttribute="user">
    <table border="0" cellpadding="6">
      <tr>
        <td>User FirstName:</td>
        <td><form:input path="userFirstName" required="required"/></td>
      </tr>

      <tr>
        <td>User MiddleName:</td>
        <td><form:input path="userMiddleName" required="required"/></td>
      </tr>

      <tr>
        <td>User LastName:</td>
        <td><form:input path="userLastName" required="required"/></td>
      </tr>


      <tr>
        <td>Address:</td>
        <td><form:input path="address" required="required"/></td>
      </tr>


      <tr>
        <td>User AuthUserId:</td>
        <td><form:input path="userAuthUserId" required="required"/></td>
      </tr>

      <tr>
        <td>User Contactnumber:</td>
        <td><form:input path="userContactnumber" required="required"/></td>
      </tr>

      <tr>
        <td>User Email:</td>
        <td><form:input path="userEmail" required="required"/></td>
      </tr>

      <tr>
        <td>User Groupid:</td>
        <td>
          <form:select path="userGroupid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${groupIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>User JobId:</td>
        <td><form:input path="userjobId" required="required"/></td>
      </tr>

      <tr>
        <td>User OrgId:</td>
        <td>
          <form:select path="userOrgId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${orgIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>UserPassword:</td>
        <td><form:input type="password" path="userPassword" required="required"/></td>
      </tr>

      <tr>
        <td>User RoleId:</td>
        <td><form:input path="userRoleId" required="required"/></td>
      </tr>


      <tr>
        <td>User UserId:</td>
        <td><form:input path="userUserId" required="required"/></td>
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