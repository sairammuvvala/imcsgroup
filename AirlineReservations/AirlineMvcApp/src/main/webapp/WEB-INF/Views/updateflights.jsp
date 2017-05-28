<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="updateFlight" commandName="flightInformation" method="post">
		

		<%
			if (request.getAttribute("FlightData") != null) {
		%>	
			Saved Successfully!!	
		
		<%
			}
		%>

		<table>
			<tr>
				<td><form:input path="flightId" /></td>
			</tr>
			<tr>
				<td><form:input path="airlineId" /></td>
			</tr>
			<tr>
				<td><form:input path="airlineName" /></td>
			</tr>
			<tr>
				<td><form:input path="origin" /></td>
			</tr>
			<tr>
				<td><form:input path="destination" /></td>
			</tr>
			<tr>
				<td><form:input path="departureTime" /></td>
			</tr>
			<tr>
				<td><form:input path="arrivaltime" /></td>
			</tr>
			<tr>
				<td><form:input path=" duation" /></td>
			</tr>
			<tr>
				<td><form:input path="totalseats" /></td>
			</tr>
			<tr>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>