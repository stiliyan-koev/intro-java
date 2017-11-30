<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
<link href="../CSS/editform.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@page import="com.jsp.project.dao.UserDao,com.jsp.project.user.User"%>

	<%
		String id = request.getParameter("id");
		User u = UserDao.getRecordById(Integer.parseInt(id));
	%>

	<h1>Edit Form</h1>
	<form action="edituser.jsp" method="post">
		<input type="hidden" name="id" value="<%=u.getId()%>" />
		<table>

			<tr>
				<td>First name:</td>
				<td><input type="text" name="firstName"
					value="<%=u.getFirstName()%>" /></td>
			</tr>

			<tr>
				<td>Last name:</td>
				<td><input type="text" name="lastName"
					value="<%=u.getLastName()%>" /></td>
			</tr>

			<tr>
				<td>Date of birth:</td>
				<td><input type="date" name="dob" value="<%=u.getDob()%>" /></td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="<%=u.getPhone()%>" /></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=u.getEmail()%>" /></td>
			</tr>


		</table>
		<input type="submit" value="Edit User" />
	</form>
	<a href="viewusers.jsp" class="button">Back to all Records</a>
</body>
</html>
