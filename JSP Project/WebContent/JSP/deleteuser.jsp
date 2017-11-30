<%@page import="com.jsp.project.dao.UserDao"%>
<jsp:useBean id="u" class="com.jsp.project.user.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
UserDao.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  