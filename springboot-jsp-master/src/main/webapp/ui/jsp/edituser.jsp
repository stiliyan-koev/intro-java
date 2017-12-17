<%@page import="com.markovski.springboot.UserController"%>
<jsp:useBean id="u" class="com.markovski.dto.Employee"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
<%
System.out.println("asd");
//UserController.editUserd(u);
response.sendRedirect("viewusers.jsp");  
%>