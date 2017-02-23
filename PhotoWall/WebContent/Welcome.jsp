<%@page import="java.sql.*"%>
<%@page import="sqlCon.ConnectorClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME</title>
</head>
<body>

<%
	    session.setAttribute("uname",request.getParameter("Uname")); 	
		//System.out.println(uname);
		Connection con = ConnectorClass.conn();
		String qury = "Select id,image_c from user where user=?";
		PreparedStatement ps = con.prepareStatement(qury);
		//System.out.println((String)session.getAttribute("uname"));
		ps.setString(1,(String)session.getAttribute("uname"));
		ResultSet rs =ps.executeQuery();
		if(rs.next())
		{
			session.setAttribute("User_ID",rs.getInt(1));
			session.setAttribute("Image_c",rs.getInt(2));
			
		}
		else{
			response.sendRedirect("Error.jsp");
		}
	%>

<center><h1>WELCOME <%=(String)session.getAttribute("uname") %> </h1>
<br><br><br>
<a href="PhotoWall.jsp"><button >Gallery</button></a>
<a href="UploadImage.jsp"><button>Upload</button></a>
</center>
</body>
</html>