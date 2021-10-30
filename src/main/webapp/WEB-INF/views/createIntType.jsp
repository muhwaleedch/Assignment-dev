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
  <h2>New IntType</h2>
  <form:form action="createIntType" method="post" modelAttribute="intType">
    <table border="0" cellpadding="6">
      <tr>
        <td>IntType Name:</td>
        <td><form:input path="intTypeName" required="required"/></td>
      </tr>


      <tr>
        <td>IntType ShortDescription:</td>
        <td><form:input path="intTypeShortDescription" required="required"/></td>
      </tr>


      <tr>
        <td>IntType Description:</td>
        <td><form:input path="intTypeDescription" required="required"/></td>
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
  <h1>IntType</h1>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>IntType Id</th>
      <th>IntType Uuid</th>
      <th>IntType Name</th>
      <th>IntType ShortDescription</th>
      <th>IntType Description</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${intTypeList}" var="intType">
      <tr>
        <td>${intType.intTypeId}</td>
        <td>${intType.intTypeUuid}</td>
        <td>${intType.intTypeName}</td>
        <td>${intType.intTypeShortDescription}</td>
        <td>${intType.intTypeDescription}</td>
        <td>${intType.updatedDts}</td>
        <td>${intType.updatedBy}</td>
        <td>${intType.createdDts}</td>
        <td>${intType.createdBy}</td>
        <td>${intType.activeStatus}</td>
        <td>
          <a href="/intTypeEdit/${intType.intTypeUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/intTypeDelete/${intType.intTypeUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>