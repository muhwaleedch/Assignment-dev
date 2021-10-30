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
  <h2>New Resource</h2>
  <form:form action="createResource" method="post" modelAttribute="resource">
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
  <h3>Resource List</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>Resource ID</th>
      <th>Resource Uuid</th>
      <th>Resource Name</th>
      <th>Resource Type</th>
      <th>Resource Description</th>
      <th>Resource Type Description</th>
      <th>Resource Version Number</th>
      <th>Resource Available Indicator</th>
      <th>ParentId</th>
      <th>AuthUserId:</th>
      <th>Created By</th>
      <th>Created Date</th>
      <th>Active Status</th>
      <th>Updated Date</th>
      <th>Updated By</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${resourceList}" var="resource">
      <tr>
        <td>${resource.resourceId}</td>
        <td>${resource.resourceUuid}</td>
        <td>${resource.resourceName}</td>
        <td>${resource.resourceType}</td>
        <td>${resource.resourceDesc}</td>
        <td>${resource.resourceTypeDesc}</td>
        <td>${resource.resourceVersionNumber}</td>
        <td>${resource.resourceAvailableIndicator}</td>
        <td>${resource.resourceParentId}</td>
        <td>${resource.resourceAuthUserId}</td>
        <td>${resource.createdBy}</td>
        <td>${resource.createdDts}</td>
        <td>${resource.activeStatus}</td>
        <td>${resource.updatedDts}</td>
        <td>${resource.updatedBy}</td>
        <td>
          <a href="/resourceEdit/${resource.resourceUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/resourceDelete/${resource.resourceUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  &nbsp&nbsp

</div>
</body>
</html>