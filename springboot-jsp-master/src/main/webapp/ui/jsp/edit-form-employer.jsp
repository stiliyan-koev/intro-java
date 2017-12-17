<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Form</h1>
	AAAAAA
	<form:form action="send-update" commandName="person" method="post">
		<input type="hidden" name="id" value="${person.getId()}" />
		<div>
			<form:label path="departmentId">
				DepartmentId:</form:label>
			<form:input path="departmentId" />
			<form:errors path="departmentId" cssClass="error" element="div" />
		</div>
		<div>
			<form:label path="job">
				JOB:</form:label>
			<form:input path="job" />
			<form:errors path="job" cssClass="error" element="div" />
		</div>
		<div>
			<form:label path="salary">
				Salary:</form:label>
			<form:input path="salary" />
			<form:errors path="salary" cssClass="error" element="div" />
		</div>
		<div>
			<form:label path="bonus">
				Bonus:</form:label>
			<form:input path="bonus" />
			<form:errors path="bonus" cssClass="error" element="div" />
		</div>
		<div>
			<form:label path="comission">
				Commission:</form:label>
			<form:input path="comission" />
			<form:errors path="comission" cssClass="error" element="div" />
		</div>
		<input type="submit" value="Edit User" />
	</form:form>
</body>
</html>