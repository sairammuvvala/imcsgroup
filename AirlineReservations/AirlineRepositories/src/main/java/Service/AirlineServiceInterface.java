package Service;

import java.sql.SQLException;

import entities.Flight;


public interface AirlineServiceInterface {
	
	boolean createFlight(Flight flight);

    Flight findFlight(int flight_id) throws SQLException;

    boolean deleteFlight(int flight_id) throws SQLException;

    boolean updateFlight(Flight flight) throws SQLException;

}
