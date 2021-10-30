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
  <h2>New User</h2>
  <form:form action="createUser" method="post" modelAttribute="user">
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
  <br><br>
  <h3>User List</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>User Id</th>
      <th>User Uuid</th>
      <th>User FirstName</th>
      <th>User MiddleName</th>
      <th>User LastName</th>
      <th>Address</th>
      <th>User ActivatedDate</th>
      <th>User AuthUserId</th>
      <th>User Contactnumber</th>
      <th>User Email</th>
      <th>User ExpirationDate</th>
      <th>User Groupid</th>
      <th>User JobId</th>
      <th>User LastactivityDate</th>
      <th>User OrgId</th>
      <th>User Password</th>
      <th>User RoleId</th>
      <th>User UserId</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
      <tr>
        <td>${user.userId}</td>
        <td>${user.userUuid}</td>
        <td>${user.userFirstName}</td>
        <td>${user.userMiddleName}</td>
        <td>${user.userLastName}</td>
        <td>${user.address}</td>
        <td>${user.userActivatedDate}</td>
        <td>${user.userAuthUserId}</td>
        <td>${user.userContactnumber}</td>
        <td>${user.userEmail}</td>
        <td>${user.userExpirationDate}</td>
        <td>${user.userGroupid}</td>
        <td>${user.userjobId}</td>
        <td>${user.userLastactivityDate}</td>
        <td>${user.userOrgId}</td>
        <td>${user.userPassword}</td>
        <td>${user.userRoleId}</td>
        <td>${user.userUserId}</td>
        <td>${user.updatedDts}</td>
        <td>${user.updatedBy}</td>
        <td>${user.createdDts}</td>
        <td>${user.createdBy}</td>
        <td>${user.activeStatus}</td>
        <td>
          <a href="/userEdit/${user.userUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/userDelete/${user.userUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <br/><br/>


</div>
</body>
</html>