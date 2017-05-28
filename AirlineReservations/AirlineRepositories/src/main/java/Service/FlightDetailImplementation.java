package Service;

import java.sql.SQLException;


import dAoRepositories.FlightDaoDetailInterface;
import dAoRepositories.FlightDetailsDaoImplementation;
import entities.Flight_details;

public class FlightDetailImplementation implements FlightDetailsInterface {
	
	private FlightDaoDetailInterface flightDetailDaoImplementation;

    public FlightDetailImplementation() {
    	
    	flightDetailDaoImplementation = new FlightDetailsDaoImplementation();
    	
    }

	public boolean createFlightDetails(Flight_details flight_details) {
		boolean status=flightDetailDaoImplementation.save(flight_details);
        return status;
	}

	public Flight_details findFlightDetails(int flight_id) throws SQLException {
		Flight_details flight = flightDetailDaoImplementation.get(flight_id);
        return flight;
	}

	public boolean deleteFlightDetails(int flight_id) throws SQLException {
              boolean flag = flightDetailDaoImplementation.delete(flight_id);
        
        return flag;
	}

	public boolean updateFlightDetails(Flight_details flight_id) throws SQLException {
                  boolean flag = flightDetailDaoImplementation.update(flight_id);
        
        return flag;
	}

}
