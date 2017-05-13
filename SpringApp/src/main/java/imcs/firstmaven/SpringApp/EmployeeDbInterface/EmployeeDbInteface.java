package imcs.firstmaven.SpringApp.EmployeeDbInterface;

import java.sql.SQLException;
import java.util.List;

import imcs.training.employeeapp.employeeApp.Employee;

public interface EmployeeDbInteface {
	
	void create(Employee employee) throws SQLException;

	Employee read(int id) throws SQLException;

	boolean update(Employee employee) throws SQLException;

	boolean delete(int id2) throws SQLException;
	
	
	List<Employee> displayAl() throws SQLException;

}
