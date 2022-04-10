<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/nam";
String userid = "root";
String password = "Suresh@1997";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>


<!DOCTYPE html>
<html>
<body bgcolor="skyblue">
<h1>FLY AWAY</h1>
<h4>Flights available</h4>
<table border="1">
<tr>
<td>source</td>
			<td>clock</td>
			<td>destination</td>
			<td>journeyday</td>
			<td>price</td>
			<td>ticket</td>
			
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from flight";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<tr>
<td><%=resultSet.getString("source") %></td>
<td><%=resultSet.getString("clock") %></td>
<td><%=resultSet.getString("destination") %></td>
<td><%=resultSet.getString("journeyday") %></td>
<td><%=resultSet.getString("price") %></td>
<td><%=resultSet.getString("ticket") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<a href="Adminhome.html">back</a>
</body>
</html>