<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/menu.css" rel="stylesheet" type="text/css">
</head>
<body>
<table border="1" style="width: 90%" id="usersTable" class="usersTable">
		<tr>
			<th><a id="firstNameSort" title="Click to sort by ID" href="#"
				onclick="sortTableByOption(0);return false;">ID</a></th>
			<th><a id="firstNameSort" title="Click to sort by First name"
				href="#" onclick="sortTableByOption(1);return false;">First name</a></th>
			<th><a id="lastNameSort" title="Click to sort by Last name"
				href="#" onclick="sortTableByOption(2);return false;">Last name</a></th>
			<th><a id="dobSort" title="Click to sort by DOB" href="#"
				onclick="sortTableByOption(3);return false;">Date of birth</a></th>
			<th>Phone</th>
			<th>Email</th>
			<th>Account name</th>
			<th>Password </th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getFirstName()}</td>
				<td>${u.getLastName()}</td>
				<td>${u.getDob()}</td>
				<td>${u.getPhone()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getAccountName()}</td>
				<td>${u.getPassword()}</td>
				<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
				<td><a href="#" onclick="deletePost(${u.getId()})">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>