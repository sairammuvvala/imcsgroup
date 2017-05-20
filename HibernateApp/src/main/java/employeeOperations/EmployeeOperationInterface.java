package employeeOperations;

import java.sql.SQLException;
import java.util.List;

import pojo.Employee;

public interface EmployeeOperationInterface {
	
	boolean createEmployee(Employee employee);

    Employee findEmployee(int empId) throws SQLException;

    List<Employee> findAll() throws SQLException;

    boolean deleteEmployee(int empId) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;


}
