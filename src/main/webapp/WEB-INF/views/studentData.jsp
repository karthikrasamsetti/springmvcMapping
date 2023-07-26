<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<form:form method="POST">
		<div class="container mt-5">
			<span><h1 class="text-center mb-4">Student List</h1> </span> <span>
				<h1>
					<a href="insert"><button type="button" class="btn btn-primary">Add
							Student</button></a>
				</h1>
				<h2> Total Students : ${studentBean.size()}</h2>
			</span>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Branch</th>
						<th>Maths</th>
						<th>English</th>
						<th>Social</th>
						<th>TotalMarks</th>
						<th>Percentage</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stu" items="${studentBean}">
						<!--  construct an "update" link with customer id -->
						 <c:url var="updateLink" value="/update">
							<c:param name="stuId" value="${stu.id}" />
						</c:url> 
            <!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/delete">
							<c:param name="stuId" value="${stu.id}" />
						</c:url> 
						<tr>
							<td>${stu.getId()}</td>
							<td>${stu.getName()}</td>
							<td>${stu.getAge()}</td>
							<td>${stu.getBranch()}</td>
							<td>${stu.getMaths()}</td>
							<td>${stu.getEnglish()}</td>
							<td>${stu.getSocial()}</td>
							<td>${stu.getTotalMarks()}</td>
							<td>${stu.getPercentage()}</td>
							<td> <a href="${updateLink}"><button type="button" class="btn btn-warning">Edit</button></a>
	        			<a href="${deleteLink}"onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false"><button type="button" class="btn btn-danger">delete</button></a></td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form:form>
	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
</body>
</html>