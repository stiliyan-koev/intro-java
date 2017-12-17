<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Number of employees managed by this employer: <c:out value = "${employeeCount}"/> </p>
	<table border=1px>
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Mid name</th>
			<th>Family name</th>
			<th>Job</th>
			<th>Birth day</th>
			<th>Salary</th>
			<th>Active</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${employeesList}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getFirstName()}</td>
				<td>${u.getMidName()}</td>
				<td>${u.getFamilyName()}</td>
				<td>${u.getJob()}</td>
				<td><fmt:formatDate type = "date" 
         value = "${u.getBirthDate()}" /></td>
				<td>${u.getSalary()}$</td>
				<td>${u.isActive()}</td>
				<td><a href="edit-form-employer?id=${u.getId()}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

