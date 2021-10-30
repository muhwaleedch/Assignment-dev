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
  <h2>New Group</h2>
  <form:form action="createGroups" method="post" modelAttribute="group">
    <table border="0" cellpadding="6">
      <tr>
        <td>Group Name:</td>
        <td><form:input path="groupName" required="required"/></td>
      </tr>

      <tr>
        <td>Group ShortName:</td>
        <td><form:input path="groupShortName" required="required"/></td>
      </tr>

      <tr>
        <td>Group Desc:</td>
        <td><form:input path="groupDesc" required="required"/></td>
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
  <h3>Groups List</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>GroupId</th>
      <th>GroupUuid</th>
      <th>GroupName</th>
      <th>GroupShortName</th>
      <th>GroupDesc</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groupList}" var="group">
      <tr>
        <td>${group.groupId}</td>
        <td>${group.groupUuid}</td>
        <td>${group.groupName}</td>
        <td>${group.groupShortName}</td>
        <td>${group.groupDesc}</td>
        <td>${group.updatedBy}</td>
        <td>${group.updatedDts}</td>
        <td>${group.createdDts}</td>
        <td>${group.createdBy}</td>
        <td>${group.activeStatus}</td>
        <td>
          <a href="/groupsEdit/${group.groupUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/groupsDelete/${group.groupUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</div>
</body>
</html>