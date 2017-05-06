<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>

	<c:if
		test="${actionName.equals('edit') || actionName.equals('update')}">
		<tr>
			<td><form:label path="id">Id:</form:label></td>
			<td><form:input path="id" value="${employee.id}" readonly="true" /></td>
		</tr>
	</c:if>
	<tr>
		<td><form:label path="firstName">First Name:</form:label></td>
		<td><form:input path="firstName" value="${employee.firstName}" /></td>
	</tr>
	<tr>
		<td><form:label path="lastName">Last Name:</form:label></td>
		<td><form:input path="lastName" value="${employee.lastName}" /></td>
	</tr>
	<tr>
		<td><form:label path="email">Email:</form:label></td>
		<td><form:input path="email" value="${employee.email}" /></td>
	</tr>

	<tr>
		<td colspan="2"></td>
	</tr>
</table>