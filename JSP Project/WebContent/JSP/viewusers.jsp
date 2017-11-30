<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
<link href="../CSS/viewusers.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%@page
		import="com.jsp.project.dao.UserDao,com.jsp.project.user.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<%
		List<User> list = UserDao.getAllRecords();
		request.setAttribute("list", list);
	%>

	<form action="">
		Search by: <input type="radio" name="a" id="fName" value="first">
		First name <input type="radio" name="a" id="lName" value="second">
		Last name<br>
	</form>

	<input type="text" id="searchInput" onkeyup="searchForRecord()"
		placeholder="Search for names.." title="Type in a name"
		style="width: 90%">
	<br></br>
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
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getFirstName()}</td>
				<td>${u.getLastName()}</td>
				<td>${u.getDob()}</td>
				<td>${u.getPhone()}</td>
				<td>${u.getEmail()}</td>
				<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
				<td><a href="#" onclick="deletePost(${u.getId()})">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="adduserform.jsp" class="button">Add New User</a>

</body>
<script>
	function sortTableByOption(option) {
		var table, rows, switching, i, firstRecord, secondRecord, shouldSwitch;
		table = document.getElementById("usersTable");
		switching = true;
		while (switching) {
			switching = false;
			rows = table.getElementsByTagName("TR");
			for (i = 1; i < (rows.length - 1); i++) {
				shouldSwitch = false;
				firstRecord = rows[i].getElementsByTagName("TD")[option];
				secondRecord = rows[i + 1].getElementsByTagName("TD")[option];
				if (firstRecord.innerHTML.toLowerCase() > secondRecord.innerHTML.toLowerCase()) {
					shouldSwitch = true;
					break;
				}
			}
			if (shouldSwitch) {
				rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
				switching = true;
			}
		}
	}
</script>
<script>
	function searchForRecord() {
		var input, filter, table, tr, td, i;
		input = document.getElementById("searchInput");
		filter = input.value.toUpperCase();
		table = document.getElementById("usersTable");
		tr = table.getElementsByTagName("tr");

		if (document.getElementById('fName').checked) {

			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
				if (td) {
					if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		} else if (document.getElementById('lName').checked) {
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[2];
				if (td) {
					if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	}
</script>
<script>
function deletePost(id) {
    var ask = window.confirm("Are you sure you want to delete user with id=" + id);
    if (ask) {
		window.location.href = "deleteuser.jsp?id="+ id;

    }
}</script>
</html>
