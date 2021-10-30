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
  <h2>Edit IntCmdParam</h2>
  <form:form action="/intCmdParamEdit/${intCmdParamUuid}" method="post" modelAttribute="intCmdParam">
    <table border="0" cellpadding="6">
      <tr>
        <td>IntCmdParam IntCmdUuid:</td>
        <td>
          <form:select path="intCmdParamIntCmdUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdUuids}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmdParam IntCmdId:</td>
        <td>
          <form:select path="intCmdParamIntCmdId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmdParam Name:</td>
        <td><form:input path="intCmdParamName" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmdParam Defaultvalue:</td>
        <td><form:input path="intCmdParamDefaultvalue" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmdParam Description:</td>
        <td><form:input path="intCmdParamDescription" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmdParam Shortdescription:</td>
        <td><form:input path="intCmdParamShortdescription" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmd ParamPosition:</td>
        <td><form:input path="intCmdParamPosition" required="required"/></td>
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