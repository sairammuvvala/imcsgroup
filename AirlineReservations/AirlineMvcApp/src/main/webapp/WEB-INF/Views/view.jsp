<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Flight Id: ${flight.flight_id}<br>
Airline Id: ${flight.airline_id}<br>
Airline Name: ${flight.airlineName}<br>
Origin: ${flight.from_location}<br>
Destination : ${flight.to_location}<br>
departureTime: ${flight.departure_time}<br>
Arivaltime: ${flight.arrival_time}<br>
duation: ${flight.duation}<br>
price: ${flight.flightDetail.price}<br>
availableseat: ${flight.flightDetail.availableseat}<br>
</body>
</html>