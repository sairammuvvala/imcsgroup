package dAoRepositories;

import java.sql.SQLException;


import entities.Flight_details;

public interface FlightDaoDetailInterface {

	public boolean save(Flight_details flight);
	public Flight_details get(int id) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public boolean update(Flight_details flight) throws SQLException;
	
}
