package imcs.firstmaven.SpringApp.EmployeeCollectionImplementation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import imcs.training.employeeapp.employeeApp.Employee;
import imcs.training.employeeapp.employeeApp.Jdbcinterface;
import imcs.firstmaven.SpringApp.EmployeeDbInterface.EmployeeDbInteface;

@Repository("Employeedbrepo")
public class EmployeeDbImplementation implements EmployeeDbInteface {
	
	private Jdbcinterface jdbcimplementation;
	
	@Autowired
	public EmployeeDbImplementation(Jdbcinterface jdbcimplementation){
		this.jdbcimplementation=jdbcimplementation;
	}

	public void create(Employee employee) throws SQLException {
	           jdbcimplementation.create(employee);
		
	}
	public Employee read(int id) throws SQLException {
		Employee employee = jdbcimplementation.read(id) ;
		return employee; 

	}
	public boolean update(Employee employee) throws SQLException {
		boolean flag = jdbcimplementation.update(employee) ;
		return flag; 
	
	}
	public List<Employee> displayAl() throws SQLException {
		List<Employee> employees =jdbcimplementation.displayAl();
		return employees;
	}
	public boolean delete(int id2) throws SQLException {
		boolean flag = jdbcimplementation.delete(id2) ;
		          
		      return flag; 
	}
	}
