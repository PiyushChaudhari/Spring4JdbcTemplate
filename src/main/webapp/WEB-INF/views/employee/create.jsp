<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.center {
	margin: auto;
	width: 50%;
	border: 3px solid green;
	padding: 10px;
}
</style>
<title>Create employee</title>
</head>
<body>
	<h1 align="center">Employee</h1>

	<dir class="center">
		<form:form method="POST"
			action="${pageContext.request.contextPath}/employee/save"
			commandName="employee">
			<jsp:include page="_form.jsp"></jsp:include>

			<input type="submit" value="Save" />
			<input type="button" value="Cancle"
				onclick="window.location.href='${pageContext.request.contextPath}/employee/list'" />
		</form:form>
	</dir>
</body>
</html>