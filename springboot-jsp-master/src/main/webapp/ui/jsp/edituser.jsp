<%@page import="com.controllers.springboot.UserController"%>
<jsp:useBean id="u" class="com.models.dto.Employee"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
<%
System.out.println("asd");
//UserController.editUserd(u);
response.sendRedirect("viewusers.jsp");  
%>