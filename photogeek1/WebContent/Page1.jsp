<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="30%">&nbsp;</td>
    <td width="70%">&nbsp;</td>
  </tr>
  
    <% 
    session.setAttribute("uname",request.getParameter("uname"));
    try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","rat");
		
		String qry="select id,image_c from user where user='"+(String)session.getAttribute("uname")+"'";
		PreparedStatement ps=con.prepareStatement(qry);
		//ps.setString(1, (String)session.getAttribute("uname"));
		ResultSet rs=ps.executeQuery(qry);
		
		if(rs.next())
		{
	      session.setAttribute("id",rs.getInt(1));
	      session.setAttribute("image_c",rs.getInt(2));
  		}
  else{
    response.sendRedirect("Error.jsp");
  }
  }
	catch(Exception e)
	{
		System.out.println(e);
	}
	 %>
  <tr>
    <td>&nbsp;</td>
    <td><a href="Page2.jsp">Load</a></td>
  </tr>
  </table>
</body>
</html>