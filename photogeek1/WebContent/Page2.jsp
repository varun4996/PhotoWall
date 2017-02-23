<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,java.io.*"%>
    <%@page errorPage="error.jsp" isErrorPage="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Images Of <%=session.getAttribute("uname") %>
<%
    int i=1;
    if((int)session.getAttribute("image_c")!=0)
    {
    	while(i<=(int)session.getAttribute("image_c"))
    	{
  %><img src="Page3.jsp?imageid=<%=i%>"/>
  <% i++;
    	}
    }
    else
    {%>
    <jsp:include page="Error.jsp"></jsp:include>
    <%
    	
    }
	%>
	<input type="submit" name="submit" value="value"/>
</body>
</html>