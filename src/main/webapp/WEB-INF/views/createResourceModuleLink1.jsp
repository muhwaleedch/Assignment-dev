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
  <h2>Resource Module</h2>
  <form:form action="createResourceModuleLink1" method="post" modelAttribute="resourceModule">
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
  <br><br>
  <h3>Resource Module</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>ResourceModule Id</th>
      <th>ResourceModule Uuid</th>
      <th>Resource Uuid</th>
      <th>Module Uuid</th>
      <th>Created By</th>
      <th>Created Date</th>
      <th>Active Status</th>
      <th>Updated Date</th>
      <th>Updated By</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${resourceModuleList}" var="resourceModule">
      <tr>
        <td>${resourceModule.resourceModuleId}</td>
        <td>${resourceModule.resourceModuleUuid}</td>
        <td>${resourceModule.resourceUuid}</td>
        <td>${resourceModule.moduleUuid}</td>
        <td>${resourceModule.createdBy}</td>
        <td>${resourceModule.createdDts}</td>
        <td>${resourceModule.activeStatus}</td>
        <td>${resourceModule.updatedDts}</td>
        <td>${resourceModule.updatedBy}</td>
        <td>
          <a href="/resourceModuleLinkEdit/${resourceModule.resourceModuleUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/resourceModuleLinkDelete/${resourceModule.resourceModuleUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>