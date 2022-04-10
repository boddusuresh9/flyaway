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
			<td>airline</td>
			
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
<td><%=resultSet.getString("airline") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
<h4>Book Flight</h4>
<form style="text-align: center;" action="booksession" method="post">
		<br /> From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
			name="from" id="from" placeholder="Enter Source" /><br />
		<br />
		To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
			name="to" id="to" placeholder="Enter Destination" /><br />
		<br /> Departure:<input type="text" name="departure" id="departure"placeholder="Enter Date" /><br />
		<br /> Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
			type="text" name="time" id="time" placeholder="Enter time" /><br />
		<br /> Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text"
			name="price" id="price" placeholder="Enter price" /><br /><br />
			Ticket&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text"
			name="ticket" id="ticket" placeholder="Enter price" /><br />
		<br />Airline&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text"
			name="airline" id="airline" placeholder="Enter airline" /><br />
			<br/>Passengers&nbsp;:<input type="text"
			name="passengers" id="passengers" placeholder="No of passengers" /><br /><br />
			 <input type="submit" value="submit" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="reset" value="reset" />
	</form>
</body>
</html>