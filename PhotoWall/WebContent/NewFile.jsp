<%@page import="java.sql.*"%>
<%@page import="sqlCon.ConnectorClass"%>
<html>
<body>
<%
  Connection con=  ConnectorClass.conn();
  String query="select * from user where user=?";
  PreparedStatement ps=con.prepareStatement(query);
  ps.setString(1, "varun");
  ResultSet rs=ps.executeQuery();
  rs.next();
  System.out.println(rs.getString(1));
%></body>
</html>