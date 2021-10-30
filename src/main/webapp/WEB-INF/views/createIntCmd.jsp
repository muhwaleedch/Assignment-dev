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
  <h2>New IntCmd</h2>
  <form:form action="createIntCmd" method="post" modelAttribute="intCmd">
    <table border="0" cellpadding="6">
      <tr>
        <td>IntCmd IntTypeId:</td>
        <td>
          <form:select path="intCmdIntTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intTypeIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmd IntTypeUuId:</td>
        <td>
          <form:select path="intCmdIntTypeUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intTypeUuids}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmdCmd:</td>
        <td><form:input path="intCmdCmd" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmdCmd Userfriendlyname:</td>
        <td><form:input path="intCmdCmdUserfriendlyname" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmd Blog:</td>
        <td><form:input path="intCmdBlog" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmd ZebraId:</td>
        <td><form:input path="intCmdZebraId" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmd ZebraUuid:</td>
        <td><form:input path="intCmdZebraUuid" required="required"/></td>
      </tr>
      <tr>
        <td>Created By</td>
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

  &nbsp&nbsp
  <h1>IntCmd</h1>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>IntCmd Id</th>
      <th>IntCmd Uuid</th>
      <th>IntCmd IntTypeId</th>
      <th>IntCmd IntTypeUuid</th>
      <th>IntCmd Cmd</th>
      <th>IntCmd CmdUserfriendlyname</th>
      <th>IntCmd Blog</th>
      <th>IntCmd ZebraId</th>
      <th>IntCmd ZebraUuid</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${intCmdList}" var="intCmd">
      <tr>
        <td>${intCmd.intCmdId}</td>
        <td>${intCmd.intCmdUuid}</td>
        <td>${intCmd.intCmdIntTypeId}</td>
        <td>${intCmd.intCmdIntTypeUuid}</td>
        <td>${intCmd.intCmdCmd}</td>
        <td>${intCmd.intCmdCmdUserfriendlyname}</td>
        <td>${intCmd.intCmdBlog}</td>
        <td>${intCmd.intCmdZebraId}</td>
        <td>${intCmd.intCmdZebraUuid}</td>
        <td>${intCmd.updatedDts}</td>
        <td>${intCmd.updatedBy}</td>
        <td>${intCmd.createdDts}</td>
        <td>${intCmd.createdBy}</td>
        <td>${intCmd.activeStatus}</td>
        <td>
          <a href="/intCmdEdit/${intCmd.intCmdUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/intCmdDelete/${intCmd.intCmdUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</div>
</body>
</html>