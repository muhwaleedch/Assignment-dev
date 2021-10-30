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
  <h2>New IntCmdImp</h2>
  <form:form action="createIntCmdImp" method="post" modelAttribute="intCmdImp">
    <table border="0" cellpadding="6">
      <tr>
        <td>IntCmdImp IntCmdId:</td>
        <td>
          <form:select path="intCmdImpIntCmdId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdIds}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmdImp IntCmdUuid:</td>
        <td>
          <form:select path="intCmdImpIntCmdUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdUuids}"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>IntCmdImp IntCmdParamId:</td>
        <td>
          <form:select path="intCmdImpIntCmdParamId">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdParamIds}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>IntCmdImp IntCmdParamUuid:</td>
        <td>
          <form:select path="intCmdImpIntCmdParamUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${intCmdParamUuids}"/>
          </form:select>
        </td>
      </tr>

      <tr>
        <td>IntCmdImp IntCmdParamValue:</td>
        <td><form:input path="intCmdImpIntCmdParamValue" required="required"/></td>
      </tr>

      <tr>
        <td>IntCmdImp UserUuid:</td>
        <td>
          <form:select path="intCmdImpUserUuid">
            <form:option value="NONE" label="--- Select ---"/>
            <form:options items="${userUUIDs}"/>
          </form:select>
        </td>
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

  <br/><br/>
  <h1>IntCmdImp</h1>
  <table border="1" cellpadding="10">
    <thead>
    <tr>
      <th>IntCmdImp Id</th>
      <th>IntCmdImp Uuid</th>
      <th>IntCmdImp IntCmdId</th>
      <th>IntCmdImp IntCmdUuid</th>
      <th>IntCmdImp IntCmdParamId</th>
      <th>IntCmdImp IntCmdParamUuid</th>
      <th>IntCmdImp IntCmdParamValue</th>
      <th>IntCmdImp UserUuid</th>
      <th>UpdatedDts</th>
      <th>UpdatedBy</th>
      <th>CreatedDts</th>
      <th>CreatedBy</th>
      <th>ActiveStatus</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${intCmdImpList}" var="intCmdImp">
      <tr>
        <td>${intCmdImp.intCmdImpId}</td>
        <td>${intCmdImp.intCmdImpUuid}</td>
        <td>${intCmdImp.intCmdImpIntCmdId}</td>
        <td>${intCmdImp.intCmdImpIntCmdUuid}</td>
        <td>${intCmdImp.intCmdImpIntCmdParamId}</td>
        <td>${intCmdImp.intCmdImpIntCmdParamUuid}</td>
        <td>${intCmdImp.intCmdImpIntCmdParamValue}</td>
        <td>${intCmdImp.intCmdImpUserUuid}</td>
        <td>${intCmdImp.updatedDts}</td>
        <td>${intCmdImp.updatedBy}</td>
        <td>${intCmdImp.createdDts}</td>
        <td>${intCmdImp.createdBy}</td>
        <td>${intCmdImp.activeStatus}</td>
        <td>
          <a href="/intCmdImpEdit/${intCmdImp.intCmdImpUuid}">Edit</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/intCmdImpDelete/${intCmdImp.intCmdImpUuid}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</div>
</body>
</html>