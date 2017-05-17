package EmployeeController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import arrayOperations.Employee;
import arrayOperations.EmployeeCreationException;
import arrayOperations.InvalidSalaryException;
import imcs.firstmaven.SpringApp.EmployeeServiceInterface.EmployeeServiceInterface;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceInterface employeeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}
	
	@RequestMapping(value="/{empId}", method=RequestMethod.GET)
	public ResponseEntity<?> getDepartment(@PathVariable String empId) {
		Employee employee = null;
		try {
			employee = employeeService.findEmployee(Integer.parseInt(empId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (employee == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes={"application/json"})
	public ResponseEntity<?> createDepartment(@RequestBody Employee employee) {
	
		try {
			 employeeService.createEmployee(employee);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/{empId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteDepartment(@PathVariable String empId) {
		boolean flag=false;
		try {
			flag = employeeService.deleteEmployee(Integer.parseInt(empId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, consumes={"application/json"})
	public ResponseEntity<?> updateDepartment(@RequestBody Employee employee) {
		try {
			boolean  flag = employeeService.updateEmployee(employee);
			
			if (flag == false) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
