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
  <h2>Edit IntType</h2>
  <form:form action="/intTypeEdit/${intTypeUuid}" method="post" modelAttribute="intType">
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
        <td>Updated By</td>
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