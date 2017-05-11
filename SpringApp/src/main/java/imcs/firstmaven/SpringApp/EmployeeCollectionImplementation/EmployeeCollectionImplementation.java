package imcs.firstmaven.SpringApp.EmployeeCollectionImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import arrayOperations.Employee;
import arrayOperations.EmployeeCreationException;
import arrayOperations.InvalidSalaryException;
import imcs.firstmaven.SpringApp.EmployeeCollectionInterface.EmployeeCollectionInterface;


@Repository()
public class EmployeeCollectionImplementation implements EmployeeCollectionInterface {

	 private List<Employee> employees;

	    private int size;

	    @Autowired
	    public EmployeeCollectionImplementation() {
	    	employees=new ArrayList<Employee>();
	       
	    }

		public void createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException {
			 validateData(employee);
			
	        
			employees.add(employee);
			size++;
	        //employees[size++] = employee;
	    }

	    private void validateData(Employee employee) throws EmployeeCreationException, InvalidSalaryException {
			// TODO Auto-generated method stub
	    	
	    		if(employee.getId() <= 0){
	    			throw new EmployeeCreationException("Invalid id please enter the valid positive id");
	    		}
	    		if(employee.getFirstName() ==null || employee.getFirstName().equals("")){
	    			throw new EmployeeCreationException("Invalid first name, Please enter the valid first name ");
	    		}
	    		if(employee.getLastName() ==null || employee.getLastName().equals("")){
	    			throw new EmployeeCreationException("Invalid last name, Please enter the valid last name ");
	    		}
	    		if(employee.getSalary() <0 || employee.getSalary() > 100000){
	    			throw new InvalidSalaryException("Invalid salary, Please enter the salary in range of 1 and 100000  ");
	    		}
	    			    			
		}

	    public Employee findEmployee(int empId) {
	        for (Employee e : employees) {
	            if (e.getId() == empId) {
	                return e;
	            }
	        }
	        return null;
	    }

	    public List<Employee> findAll() {
	        return employees;
	    }

	    public boolean deleteEmployee(int empId) {
	        boolean flag = false;
	        int index=-1;
	        for (int i=0;i<employees.size();i++) {

	            if (employees.get(i).getId() == empId) {
	                index=i;                                    //delete by making it null
	                
	                flag = true;
	                break;
	            }
	        }
	        
	        if(index!=-1){
	        	employees.remove(index);
	        }
	        return flag;
	    }

	    public boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException {
	    	
	    	validateData(employee);
	    	int index=-1;
	        boolean flag = false;
	        for (int i = 0; i < size; i++) {
	            if (employees.get(i).getId() == employee.getId()) {
	            	if(Math.abs((employees.get(i).getSalary()+employee.getSalary()) - employees.get(i).getSalary()) > 5000 ){
	            		throw new InvalidSalaryException("Salary cannot be incremented beyond 5000$");
	            	}
	                index=i;
	                flag = true;
	                break;
	            }
	        }
	        employees.set(index, employee);
	        return flag;
	    }
	    public double displayHRA(int empId) {
	        double hra = 0;
	        for (Employee employee: employees) {
	            if (employee.getId() == empId) {
	                hra = employee.calculateHRA();
	                break;
	            }
	        }

	        return hra;
	    }

	    public Double calculateGrossSal(int empId) {
	        for (Employee employee: employees) {
	            if (employee.getId() == empId) {
	                return employee.calculateGrossSal();
	            }
	        }
	        return null;
	    }

		public List<Employee> SortByName() {
			// TODO Auto-generated method stub
			List<Employee> sortEmployees=employees;
			Collections.sort(sortEmployees,Employee.EmployeeNameComparator);
			return sortEmployees;
		}
		
		public List<Employee> sortBySalary() {
			// TODO Auto-generated method stub
			List<Employee> sortedEmployees = employees;
			Collections.sort(sortedEmployees);
			return sortedEmployees;			
		}

		public Set<Employee> uniqueEmployees() {
			// TODO Auto-generated method stub
			Set<Employee> unique = new HashSet<Employee>(employees);
			return unique;
		}
		
		public Map<Double,Integer> salaryCount(){
			Map<Double,Integer> count = new HashMap<Double,Integer>();
			for(Employee e:employees){
				if(count.containsKey(e.getSalary())){
					count.put(e.getSalary(), count.get(e.getSalary())+1);
				}
				else{
					count.put(e.getSalary(), 1);
				}
			}
			return count;
		}
}
