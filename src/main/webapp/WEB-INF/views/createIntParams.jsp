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
  <h2>New IntParams</h2>
  <form:form action="createIntParams" method="post" modelAttribute="intParams">
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

  &nbsp&nbsp
  <h1>IntParams</h1>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>IntParams Id</th>
      <th>IntParams Uuid</th>
      <th>IntParams Name</th>
      <th>IntParams Value</th>
      <th>IntParams TypeId</th>
      <th>IntParams TypeuuId</th>
      <th>IntParams Label</th>
      <th>IntParams ParamTypeId</th>
      <th>IntParams ParamTypeuuid</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${intParamsList}" var="intParams">
      <tr>
        <td>${intParams.intParamsId}</td>
        <td>${intParams.intParamsUuid}</td>
        <td>${intParams.intParamsName}</td>
        <td>${intParams.intParamsValue}</td>
        <td>${intParams.intParamsTypeId}</td>
        <td>${intParams.intParamsTypeuuId}</td>
        <td>${intParams.intParamsLabel}</td>
        <td>${intParams.intParamsParamTypeId}</td>
        <td>${intParams.intParamsParamTypeuuid}</td>
        <td>${intParams.updatedDts}</td>
        <td>${intParams.updatedBy}</td>
        <td>${intParams.createdDts}</td>
        <td>${intParams.createdBy}</td>
        <td>${intParams.activeStatus}</td>
        <td>
          <a href="/intParamsEdit/${intParams.intParamsUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/intParamsDelete/${intParams.intParamsUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>