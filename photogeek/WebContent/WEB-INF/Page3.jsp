<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
InputStream sImage;
	response.setContentType("image/");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","rat");
		
		System.out.println(request.getParameter("id")+":::::::"+request.getParameter("imageid"));
		System.out.println(request.getParameter("imageid"));
		String qry="select * from file where ID="+request.getParameter("imageid")+" and user_ID="+session.getAttribute("id");
		PreparedStatement ps=con.prepareStatement(qry);
		ResultSet rs=ps.executeQuery(qry);
		
		if(rs.next())
		{
			  byte[] bytearray = new byte[1048576];
			  response.setContentLength(bytearray.length);
			  int size=0;
			  sImage = rs.getBinaryStream(1);
			  //response.reset();
			  while((size=sImage.read(bytearray))!= -1)
			  {
			      response.getOutputStream().write(bytearray,0,size);
			
			  }
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
%>
</body>
</html>