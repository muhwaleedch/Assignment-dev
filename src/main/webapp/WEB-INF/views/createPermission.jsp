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
  <h2>New Permission</h2>
  <form:form action="createPermission" method="post" modelAttribute="permission">
    <table border="0" cellpadding="6">
      <tr>
        <td>Permission Name:</td>
        <td><form:input path="permissionName" required="required"/></td>
      </tr>
      <tr>
        <td>Permission Desc:</td>
        <td><form:input path="permissionDesc" required="required"/></td>
      </tr>
      <tr>
        <td>Permission ResourceId:</td>
        <td>
          <form:select path="permissionResourceId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Permission ResourceUuid:</td>
        <td>
          <form:select path="permissionResourceUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceUuids}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Permission AvailableIndicator</td>
        <td><form:input path="permissionAvailableIndicator" required="required"/></td>
      </tr>
      <tr>
        <td>PermissionCreate:</td>
        <td><form:input path="permissionCreate" required="required"/></td>
      </tr>

      <tr>
        <td>Permission CreatePermissionTypeId:</td>
        <td>
          <form:select path="permissionCreatePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission Delete:</td>
        <td><form:input path="permissionDelete" required="required"/></td>
      </tr>

      <tr>
        <td>Permission DeletePermissionTypeId:</td>
        <td>
          <form:select path="permissionDeletePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission Update:</td>
        <td><form:input path="permissionUpdate" required="required"/></td>
      </tr>
      <tr>
        <td>Permission UpdatePermissionTypeId:</td>
        <td>
          <form:select path="permissionUpdatePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission Read:</td>
        <td><form:input path="permissionRead" required="required"/></td>
      </tr>
      <tr>
        <td>Permission ReadPermissionTypeId:</td>
        <td>
          <form:select path="permissionReadPermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>PermissionSoft Delete:</td>
        <td><form:input path="permissionSoftDelete" required="required"/></td>
      </tr>
      <tr>
        <td>Permission SoftDeletePermissionTypeId:</td>
        <td>
          <form:select path="permissionSoftDeletePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>PermissionOperaterId:</td>
        <td><form:input path="permissionOperaterId" required="required"/></td>
      </tr>
      <tr>
        <td>Permission AuthorizeUserId:</td>
        <td><form:input path="permissionAuthorizeUserId" required="required"/></td>
      </tr>
      <tr>
        <td>Created By:</td>
        <td>
          <form:select path="cratedBy">
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
  <h3>Permission</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>Permission Id</th>
      <th>Permission Uuid</th>
      <th>Permission Name</th>
      <th>Permission Desc</th>
      <th>Permission ResourceId</th>
      <th>Permission ResourceUuid</th>
      <th>Permission AvailableIndicator</th>
      <th>Permission Create</th>
      <th>Permission CreatePermissionTypeId</th>
      <th>Permission Delete</th>
      <th>Permission DeletePermissionTypeId</th>
      <th>Permission Update</th>
      <th>Permission UpdatePermissionTypeId</th>
      <th>Permission Read</th>
      <th>Permission ReadPermissionTypeid</th>
      <th>Permission SoftDelete</th>
      <th>Permission SoftDeletePermissionTypeId</th>
      <th>Permission OperaterId</th>
      <th>Permission AuthorizeUserId</th>
      <th>Created Dts</th>
      <th>Created By</th>
      <th>Active Status</th>
      <th>Updated Dts</th>
      <th>Updated By</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${permissionList}" var="permission">
      <tr>
        <td>${permission.permissionId}</td>
        <td>${permission.permissionUuid}</td>
        <td>${permission.permissionName}</td>
        <td>${permission.permissionDesc}</td>
        <td>${permission.permissionResourceId}</td>
        <td>${permission.permissionResourceUuid}</td>
        <td>${permission.permissionAvailableIndicator}</td>
        <td>${permission.permissionCreate}</td>
        <td>${permission.permissionCreatePermissionTypeId}</td>
        <td>${permission.permissionDelete}</td>
        <td>${permission.permissionDeletePermissionTypeId}</td>
        <td>${permission.permissionUpdate}</td>
        <td>${permission.permissionUpdatePermissionTypeId}</td>
        <td>${permission.permissionRead}</td>
        <td>${permission.permissionReadPermissionTypeId}</td>
        <td>${permission.permissionSoftDelete}</td>
        <td>${permission.permissionSoftDeletePermissionTypeId}</td>
        <td>${permission.permissionOperaterId}</td>
        <td>${permission.permissionAuthorizeUserId}</td>
        <td>${permission.createdDts}</td>
        <td>${permission.cratedBy}</td>
        <td>${permission.activeStatus}</td>
        <td>${permission.updatedDts}</td>
        <td>${permission.updatedBy}</td>
        <td>
          <a href="/permissionEdit/${permission.permissionUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/permissionDelete/${permission.permissionUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  &nbsp&nbsp


</div>
</body>
</html>