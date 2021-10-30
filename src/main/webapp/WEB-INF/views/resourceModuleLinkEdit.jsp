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
  <h2>Resource Module</h2>
  <form:form action="/resourceModuleLinkEdit/${resourceModuleUuid}" method="post" modelAttribute="resourceModule">
    <table border="0" cellpadding="5">
      <tr>
        <td>Organization Uuid:</td>
        <td>
          <form:select path="resourceUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>ModuleLookup Uuid:</td>
        <td>
          <form:select path="moduleUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${moduleLookupIds}"/>
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