<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">
	<sql:setDataSource 
	user="root" 
	password="Suresh@1997"
		url="jdbc:mysql://localhost:3306/nam"
		driver="com.mysql.cj.jdbc.Driver" />

	<h1>FLY AWAY</h1>
	<sql:query var="rSet" sql="select * from flight">
	</sql:query>
	<table border="2">
		<tr>
			<td>source</td>
			<td>clock</td>
			<td>destionaion</td>
			<td>journeydate</td>
			<td>price</td>
			<td>ticket</td>
		</tr>
		<!--Iterating over a resultset  -->
		<c:forEach var="row" items="${rSet.rows}">
			<tr>
				<td><c:out value="${row.source}" /></td>
				<td><c:out value="${row.clock}" /></td>
				<td><c:out value="${row.destionaion}" /></td>
				<td><c:out value="${row.journeydate}" /></td>
				<td><c:out value="${row.price}" /></td>
				<td><c:out value="${row.ticket}" /></td>
			</tr>
		</c:forEach>
	</table>



	<form style="text-align: center;" action="searchflight" method="post">
		<br /> From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
			name="from" id="from" placeholder="Enter Source" /><br /> <br />
		To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
			name="to" id="to" placeholder="Enter Destination" /><br /> <br />
		Departure:<input type="date" name="departure" id="departure" /><br />
		<br /> Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
			type="time" name="time" id="time" placeholder="Enter time" /><br />
		<input type="submit" value="submit" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="reset" value="reset" />
	</form>
</body>
</html>