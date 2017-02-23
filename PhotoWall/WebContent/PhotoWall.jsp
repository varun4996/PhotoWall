<%@page import="java.sql.*,java.io.*"%>
<%@ page errorPage="error.jsp" isErrorPage="true" %>

<html>
<head>
<meta http-equiv=Content-Type content=text/html; charset=iso-8859-1 />
<title>Get Image</title>
</head>

<body>


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="30%">&nbsp;</td>
    <td width="70%">Images Stored By <%=session.getAttribute("uname") %></td>
  </tr>
  
    <%
    //System.out.println("PhotoWall");
    //System.out.println(request.getParameter("Image_c"));
	    int i=1;
	    if((int)session.getAttribute("Image_c")!=0){
	    while(i<=(int)session.getAttribute("Image_c"))
	    {
    %>
  <tr>
    <td>Upload Image </td>
    <td height="200" width="300"><img src="Loader.jsp?imageid=<%=i%>" width="400" height="400"/></td>
  </tr>
  <%i++;
  		}
	 }
    else{
    	%>
    		<jsp:include page="Error.jsp"></jsp:include>
	<%
	 }
	 %>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="Submit" value="Value"></td>
  </tr>
</table>
</body>
</html>
