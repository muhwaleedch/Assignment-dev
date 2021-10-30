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
  <h2>New IntParams</h2>
  <form:form action="/intParamsEdit/${intParamsUuid}" method="post" modelAttribute="intParams">
  <table border="0" cellpadding="6">
    <table border="0" cellpadding="6">
      <tr>
        <td>IntParams Name:</td>
        <td><form:input path="intParamsName" required="required"/></td>
      </tr>

      <tr>
        <td>IntParams Value:</td>
        <td><form:input path="intParamsValue" required="required"/></td>
      </tr>

      <tr>
        <td>IntParams TypeId:</td>
        <td>
          <form:select path="intParamsTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>IntParams TypeuuId:</td>
        <td>
          <form:select path="intParamsTypeuuId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intTypeUuids}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>IntParams Label:</td>
        <td><form:input path="intParamsLabel" required="required"/></td>
      </tr>

      <tr>
        <td>IntParams ParamTypeId:</td>
        <td><form:input path="intParamsParamTypeId" required="required"/></td>
      </tr>

      <tr>
        <td>IntParams ParamTypeuuid:</td>
        <td><form:input path="intParamsParamTypeuuid" required="required"/></td>
      </tr>
      <tr>
        <td>Created By</td>
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