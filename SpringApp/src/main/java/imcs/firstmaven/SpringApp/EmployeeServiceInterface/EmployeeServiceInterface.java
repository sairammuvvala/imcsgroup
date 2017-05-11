package imcs.firstmaven.SpringApp.EmployeeServiceInterface;

import java.util.List;

import arrayOperations.Employee;
import arrayOperations.EmployeeCreationException;
import arrayOperations.InvalidSalaryException;

public interface EmployeeServiceInterface {
	
	void createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException;

    Employee findEmployee(int empId);

    List<Employee> findAll();

    boolean deleteEmployee(int empId);

    boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException;

}
