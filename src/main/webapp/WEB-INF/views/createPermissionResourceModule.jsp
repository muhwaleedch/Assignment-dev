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
  <h2>New Permission Resource Module</h2>
  <form:form action="createPermissionResourceModule" method="post" modelAttribute="permissionResourceModule">
    <table border="0" cellpadding="6">
      <tr>
        <td>Permission ResourceModuleName:</td>
        <td><form:input path="permissionResourceModuleName" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleDesc:</td>
        <td><form:input path="permissionResourceModuleDesc" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleResourceId:</td>
        <td>
          <form:select path="permissionResourceModuleResourceId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission ResourceModuleResourceUuid:</td>
        <td>
          <form:select path="permissionResourceModuleResourceUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${resourceUuids}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission ResourceModuleAvailableIndicator:</td>
        <td><form:input path="permissionResourceModuleAvailableIndicator" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleCreate:</td>
        <td><form:input path="permissionResourceModuleCreate" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleCreatePermissionTypeId:</td>
        <td>
          <form:select path="permissionResourceModuleCreatePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission ResourceModuleDelete:</td>
        <td><form:input path="permissionResourceModuleDelete" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleDeletePermissionTypeId:</td>
        <td>
          <form:select path="permissionResourceModuleDeletePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission ResourceModuleUpdate:</td>
        <td><form:input path="permissionResourceModuleUpdate" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleUpdatePermissionTypeId:</td>
        <td>
          <form:select path="permissionResourceModuleUpdatePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission ResourceModuleRead:</td>
        <td><form:input path="permissionResourceModuleRead" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleReadPermissionTypeId:</td>
        <td>
          <form:select path="permissionResourceModuleReadPermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission ResourceModuleSoftDelete:</td>
        <td><form:input path="permissionResourceModuleSoftDelete" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleSoftDeletePermissionTypeId:</td>
        <td>
          <form:select path="permissionResourceModuleSoftDeletePermissionTypeId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${permissionTypeIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>Permission ResourceModuleOperaterId:</td>
        <td><form:input path="permissionResourceModuleOperaterId" required="required"/></td>
      </tr>

      <tr>
        <td>Permission ResourceModuleAuthorizeUserId:</td>
        <td><form:input path="permissionResourceModuleAuthorizeUserId" required="required"/></td>
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

  <h3>Permission Resource Module</h3>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>Permission ResourceModuleId</th>
      <th>Permission ResourceModuleUuid</th>
      <th>Permission ResourceModuleName</th>
      <th>Permission ResourceModuleDesc</th>
      <th>Permission ResourceModuleResourceId</th>
      <th>Permission ResourceModuleResourceUuid</th>
      <th>Permission ResourceModuleAvailableIndicator</th>
      <th>Permission ResourceModuleCreate</th>
      <th>Permission ResourceModuleCreatePermissionTypeId</th>
      <th>Permission ResourceModuleDelete</th>
      <th>Permission ResourceModuleDeletePermissionTypeId</th>
      <th>Permission ResourceModuleUpdate</th>
      <th>Permission ResourceModuleUpdatePermissionTypeId</th>
      <th>Permission ResourceModuleRead</th>
      <th>Permission ResourceModuleReadPermissionTypeid</th>
      <th>Permission ResourceModuleSoftDelete</th>
      <th>Permission ResourceModuleSoftDeletePermissionTypeId</th>
      <th>Permission ResourceModuleOperaterId</th>
      <th>Permission ResourceModuleAuthorizeUserId</th>
      <th>createdDts</th>
      <th>createdBy</th>
      <th>activeStatus</th>
      <th>updatedDts</th>
      <th>updatedBy</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${permissionResourceModuleList}" var="permissionResourceModule">
      <tr>
        <td>${permissionResourceModule.permissionResourceModuleId}</td>
        <td>${permissionResourceModule.permissionResourceModuleUuid}</td>
        <td>${permissionResourceModule.permissionResourceModuleName}</td>
        <td>${permissionResourceModule.permissionResourceModuleDesc}</td>
        <td>${permissionResourceModule.permissionResourceModuleResourceId}</td>
        <td>${permissionResourceModule.permissionResourceModuleResourceUuid}</td>
        <td>${permissionResourceModule.permissionResourceModuleAvailableIndicator}</td>
        <td>${permissionResourceModule.permissionResourceModuleCreate}</td>
        <td>${permissionResourceModule.permissionResourceModuleCreatePermissionTypeId}</td>
        <td>${permissionResourceModule.permissionResourceModuleDelete}</td>
        <td>${permissionResourceModule.permissionResourceModuleDeletePermissionTypeId}</td>
        <td>${permissionResourceModule.permissionResourceModuleUpdate}</td>
        <td>${permissionResourceModule.permissionResourceModuleUpdatePermissionTypeId}</td>
        <td>${permissionResourceModule.permissionResourceModuleRead}</td>
        <td>${permissionResourceModule.permissionResourceModuleReadPermissionTypeId}</td>
        <td>${permissionResourceModule.permissionResourceModuleSoftDelete}</td>
        <td>${permissionResourceModule.permissionResourceModuleSoftDeletePermissionTypeId}</td>
        <td>${permissionResourceModule.permissionResourceModuleOperaterId}</td>
        <td>${permissionResourceModule.permissionResourceModuleAuthorizeUserId}</td>
        <td>${permissionResourceModule.createdDts}</td>
        <td>${permissionResourceModule.cratedBy}</td>
        <td>${permissionResourceModule.activeStatus}</td>
        <td>${permissionResourceModule.updatedDts}</td>
        <td>${permissionResourceModule.updatedBy}</td>
        <td>
          <a href="/permissionResourceModuleEdit/${permissionResourceModule.permissionResourceModuleUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/permissionResourceModuleDelete/${permissionResourceModule.permissionResourceModuleUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>