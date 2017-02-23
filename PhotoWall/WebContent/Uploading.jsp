<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.InputStream"%>
<%@page import="sqlCon.ConnectorClass" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	Connection con = ConnectorClass.conn();

	String qry[] = {"update table user set image_c=? where user=?","insert into file values(?,?,?)"};
	
	PreparedStatement ps;
	InputStream is  = null;
	
	Part imgPart = request.getPart("imagefile");
	
	System.out.println(imgPart);
	
	System.out.println(imgPart.getName());
	
	if(imgPart!=null)
	{
		ps = con.prepareStatement(qry[1]);
		int flag1 = ps.executeUpdate();
		
		is = imgPart.getInputStream();
		
		int temp=(int)session.getAttribute("Image_c");
		
		ps.setBlob(1,is);
		ps.setInt(2,temp);
		ps.setInt(3,(int)session.getAttribute("User_ID"));
		
		session.removeAttribute("Image_c");
		session.setAttribute("Image_c",++temp);
		
		ps = con.prepareStatement(qry[0]);
		
		int flag2 = ps.executeUpdate();
		
		ps.setInt(1, temp);
		
		if(flag1*flag2!=0)
		{
			System.out.println("Success....");
		}
	}
	
	

	%>


</body>
</html>