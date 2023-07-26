<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" action="showDetails"
		modelAttribute="studentBean" align="center">
		<div class="container mt-5">
			<span><h3>Welcome, Enter The Employee Details</h3></span>
			<table class="table table-striped">
				<tr>
					<td><form:hidden path="id" /></td>
				</tr>

				<tr>
					<td>StudentName</td>
					<td><form:input path="name" /></td>
					<form:errors path="name" cssStyle="color:red;"></form:errors>
				</tr>

				<tr>
					<td>Age</td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td>Branch</td>
					<td><form:input path="branch" /></td>
				</tr>
				<tr>
					<td>Maths</td>
					<td><form:input path="maths" /></td>
				</tr>

				<tr>
					<td>English</td>
					<td><form:input path="english" /></td>
				</tr>
				<tr>
					<td>Social</td>
					<td><form:input path="social" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:button class="btn btn-primary">Submit</form:button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>
