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
  <h2>Edit IntCmdImp</h2>
  <form:form action="/intCmdImpEdit/${intCmdImpUuid}" method="post" modelAttribute="intCmdImp">
    <table border="0" cellpadding="6">
      <tr>
        <td>IntCmdImp IntCmdId:</td>
        <td>
          <form:select path="intCmdImpIntCmdId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmdImp IntCmdUuid:</td>
        <td>
          <form:select path="intCmdImpIntCmdUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdUuids}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmdImp IntCmdParamId:</td>
        <td>
          <form:select path="intCmdImpIntCmdParamId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdParamIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>IntCmdImp IntCmdParamUuid:</td>
        <td>
          <form:select path="intCmdImpIntCmdParamUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdParamUuids}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>IntCmdImp IntCmdParamValue:</td>
        <td><form:input path="intCmdImpIntCmdParamValue" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmdImp UserUuid:</td>
        <td>
          <form:select path="intCmdImpUserUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${userUUIDs}"/>
          </form:select>
        </td>
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