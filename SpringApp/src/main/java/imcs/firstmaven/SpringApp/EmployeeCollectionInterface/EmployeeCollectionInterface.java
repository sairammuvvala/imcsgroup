package imcs.firstmaven.SpringApp.EmployeeCollectionInterface;

import java.util.List;

import arrayOperations.Employee;
import arrayOperations.EmployeeCreationException;
import arrayOperations.InvalidSalaryException;

public interface EmployeeCollectionInterface {
	
	void createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException;

    Employee findEmployee(int empId);

    List<Employee> findAll();

    boolean deleteEmployee(int empId);

    boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException;

}
