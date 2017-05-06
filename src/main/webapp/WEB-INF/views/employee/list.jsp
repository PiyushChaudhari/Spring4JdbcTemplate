<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
<script type="text/javascript">
	function deleteEmployee(id) {
		var txt = "";
		if (confirm("Are you sure you want to delete this employee?") == true) {
			window.location.href = '${pageContext.request.contextPath}/employee/delete/'
					+ id;
		}

	}
</script>
</head>
<body>
	<h1 align="center">Employee List</h1>

	<table align="center" border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>

				<c:when test="${!empty employees}">
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td>
								<%-- <c:out value="${employee.id}" /> --%> <a
								href="${pageContext.request.contextPath}/employee/edit/${employee.id}">
									<c:out value="${employee.id}" />
							</a>
							</td>
							<td><c:out value="${employee.firstName}" /></td>
							<td><c:out value="${employee.lastName}" /></td>
							<td><c:out value="${employee.email}" /></td>
							<td><a href="javascript:void('0')"
								onclick="deleteEmployee('${employee.id}')">Delete</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5" align="center">No, recored found</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" align="center"><a
					href="${pageContext.request.contextPath}/employee/create">New
						Employee</a></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>