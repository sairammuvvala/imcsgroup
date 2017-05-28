package Service;

import java.sql.SQLException;

import entities.Flight_details;



public interface FlightDetailsInterface {

	boolean createFlightDetails(Flight_details flight_details);

	Flight_details findFlightDetails(int flight_id) throws SQLException;

    boolean deleteFlightDetails(int flight_id) throws SQLException;

    boolean updateFlightDetails(Flight_details flight_details) throws SQLException;
}
