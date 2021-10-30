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
  <h2>Edit Resource</h2>
  <form:form action="/resourceEdit/${resourceUuid}" method="post" modelAttribute="resource">
    <table border="0" cellpadding="6">
      <tr>
        <td>Name:</td>
        <td><form:input path="resourceName" required="required"/></td>
      </tr>
      <tr>
        <td>Type:</td>
        <td><form:input path="resourceType" required="required"/></td>
      </tr>
      <tr>
        <td>Description:</td>
        <td><form:input path="resourceDesc" required="required"/></td>
      </tr>
      <tr>
        <td>VersionNumber:</td>
        <td><form:input path="resourceVersionNumber" required="required"/></td>
      </tr>
      <tr>
        <td>TypeDesc:</td>
        <td><form:input path="resourceTypeDesc" required="required"/></td>
      </tr>
      <tr>
        <td>AvailableIndicator:</td>
        <td><form:input path="resourceAvailableIndicator" required="required"/></td>
      </tr>
      <tr>
        <td>ParentId:</td>
        <td><form:input path="resourceParentId" required="required"/></td>
      </tr>
      <tr>
        <td>AuthUserId:</td>
        <td><form:input path="resourceAuthUserId" required="required"/></td>
      </tr>
      <tr>
        <td>Resource ResourceTypeUuid:</td>
        <td>
          <form:select path="resourceResourceTypeUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceTypeIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Updated By:</td>
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