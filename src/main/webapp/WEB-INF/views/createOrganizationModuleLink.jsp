<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>New Customer</title>
</head>
<body>
<div align="center">
  <h2>New Organization Module</h2>
  <form:form action="createOrganizationModuleLink" method="post" modelAttribute="organizationModule">
    <table border="0" cellpadding="5">
      <tr>
        <td>Organization Uuid:</td>
        <td>
          <form:select path="organizationUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${organizationIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>ModuleLookup Uuid:</td>
        <td>
          <form:select path="moduleLookupUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${moduleLookupIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Created By:</td>
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
  <h3>Link Organization-Module</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>Organisation Module Id</th>
      <th>Organization Module Uuid</th>
      <th>Organization Uuid</th>
      <th>ModulesLookup Uuid</th>
      <th>Created By</th>
      <th>Created Date</th>
      <th>Active Status</th>
      <th>Updated Date</th>
      <th>Updated By</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${organizationModuleList}" var="organizationModule">
      <tr>
        <td>${organizationModule.organizationModuleId}</td>
        <td>${organizationModule.organizationModuleUuid}</td>
        <td>${organizationModule.organizationUuid}</td>
        <td>${organizationModule.moduleLookupUuid}</td>
        <td>${organizationModule.createdBy}</td>
        <td>${organizationModule.createdDts}</td>
        <td>${organizationModule.activeStatus}</td>
        <td>${organizationModule.updatedDts}</td>
        <td>${organizationModule.updatedBy}</td>
        <td>
          <a href="/organizationModuleLinkEdit/${organizationModule.organizationModuleUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/organizationModuleLinkDelete/${organizationModule.organizationModuleUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</div>
</body>
</html>