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
  <h2>Edit Organization mapping</h2>
  <form:form action="/userOrganizationmappingEdit/${id}" method="post" modelAttribute="userOrganizationMapping">
    <table border="0" cellpadding="6">
      <tr>
        <td>OrgId:</td>
        <td>
          <form:select path="orgId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${organizationIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>UserId:</td>
        <td>
          <form:select path="userId">
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