package employeeOperations;

import java.sql.SQLException;
import java.util.List;

import employeeDaoOperations.EmployeeDaoImplementation;
import employeeDaoOperations.EmployeeDaoInterface;
import pojo.Employee;

public class EmployeeOperationImplementation implements EmployeeOperationInterface {
	
	private EmployeeDaoInterface employeeDaoImplementation;

    public EmployeeOperationImplementation() {
    	
    	employeeDaoImplementation = new EmployeeDaoImplementation();
    	
    }

    
	public boolean createEmployee(Employee employee) {
        boolean status=employeeDaoImplementation.save(employee);
       
        return status;
    }
	
	 public Employee findEmployee(int empId) throws SQLException {
	        Employee employee = employeeDaoImplementation.get(empId);
	        return employee;
	    }

	    public List<Employee> findAll() throws SQLException {
	    	List<Employee> employees = employeeDaoImplementation.getAll();
	        return employees;
	    }

	    public boolean deleteEmployee(int empId) throws SQLException{
	        boolean flag = employeeDaoImplementation.delete(empId);
	        
	        return flag;
	    }

	    public boolean updateEmployee(Employee employee) throws SQLException{
	    	
	        boolean flag = employeeDaoImplementation.update(employee);
	        return flag;
	    }

	

}
