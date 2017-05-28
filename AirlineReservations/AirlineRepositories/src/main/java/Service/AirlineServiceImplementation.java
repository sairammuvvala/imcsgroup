package Service;

import java.sql.SQLException;

import dAoRepositories.AirlineDaoImplementation;
import dAoRepositories.AirlineDaoInterface;
import entities.Flight;


public class AirlineServiceImplementation implements AirlineServiceInterface {
	
	private AirlineDaoInterface airlineDaoImplementation;

    public AirlineServiceImplementation() {
    	
    	airlineDaoImplementation = new AirlineDaoImplementation();
    	
    }

	public boolean createFlight(Flight flight) {
		 boolean status=airlineDaoImplementation.save(flight);
	        return status;
	}

	public Flight findFlight(int flight_id) throws SQLException {
		Flight flight = airlineDaoImplementation.get(flight_id);
        return flight;
	}

	public boolean deleteFlight(int flight_id) throws SQLException {
		boolean flag = airlineDaoImplementation.delete(flight_id);
        
        return flag;
	}

	public boolean updateFlight(Flight flight) throws SQLException {
		boolean flag = airlineDaoImplementation.update(flight);
        return flag;
	}

}
