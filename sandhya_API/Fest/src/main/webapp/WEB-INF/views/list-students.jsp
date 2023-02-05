<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
#modifyTable {
	padding: 10px;
}

.tableheading {
	align-content: center;
}
</style>
<title>Registered Students</title>
</head>
<body>
	<div class="w3-container w3-orange">
		<h2>Student's Registered for College Fest</h2>
	</div>
	<a href="/StudentManagement/student/addRegistration" class="btn btn-primary">Add New
		Registration</a>
	<a href="/StudentManagement/logout" class="btn btn-success">Logout</a>
	<br>
	<table border="1" class="table" id="modifyTable">
		<thead class="thead-light">
			<tr>
				<th class="tableheading" scope="col" width="5%">ID</th>
				<th class="tableheading" scope="col" width="30%">FIRST NAME</th>
				<th class="tableheading" scope="col" width="20%">LAST NAME</th>
				<th class="tableheading" scope="col" width="20%">COURSE</th>
				<th class="tableheading" scope="col" width="20%">COUNTRY</th>
				<th class="tableheading" scope="col" width="20%">ACTIONS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Students}" var="stud">
				<tr>
					<th scope="row"><c:out value="${stud.id}" /></th>
					<td><c:out value="${stud.firstName}" /></td>
					<td><c:out value="${stud.lastName}" /></td>
					<td><c:out value="${stud.course}" /></td>
					<td><c:out value="${stud.country}" /></td>
					<td><a href="/StudentManagement/student/updateDetails?id=${stud.id}"
						class="btn btn-success">Update</a> <a
						href="/StudentManagement/student/deleteDetails?id=${stud.id}" class="btn btn-danger"
						onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>