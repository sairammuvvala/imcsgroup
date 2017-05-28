package dAoRepositories;

import java.sql.SQLException;

import entities.Flight;

public interface AirlineDaoInterface {
	
	public boolean save(Flight flight);
	public Flight get(int id) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public boolean update(Flight flight) throws SQLException;

}
