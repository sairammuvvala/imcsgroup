package employeeDaoOperations;

import java.sql.SQLException;
import java.util.List;

import pojo.Employee;

public interface EmployeeDaoInterface {
	
	public boolean save(Employee employee);
	public Employee get(int id) throws SQLException;
	public List<Employee> getAll() throws SQLException;
	public boolean delete(int id) throws SQLException;
	public boolean update(Employee employee) throws SQLException;


}
