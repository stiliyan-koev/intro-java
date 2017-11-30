<%@page import="com.jsp.project.dao.UserDao"%>
<jsp:useBean id="u" class="com.jsp.project.user.User"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%  
int i=UserDao.save(u);  
if(i>0){  
response.sendRedirect("adduser-success.jsp");  
}else{  
response.sendRedirect("adduser-error.jsp");  
}  
%>
