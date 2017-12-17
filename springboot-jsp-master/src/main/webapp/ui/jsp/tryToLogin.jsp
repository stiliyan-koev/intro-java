
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<form method="get" action="/menu">
<% 
	String accname = request.getParameter("uname");
	String password = request.getParameter("pass");
	
	//if(DataBase.checkForUserCreditinals(accname, password)){
		//session.setAttribute("userId", 2);
		
		response.sendRedirect("/menu");
//	} else {
	//	out.println("Error");
	//}
	
%>
</form>