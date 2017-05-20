package employeeApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import employeeOperations.EmployeeOperationImplementation;
import employeeOperations.EmployeeOperationInterface;
import employeeUtils.UserUtil;
import pojo.Employee;

public class EmployeeApplication {
	
	 private EmployeeOperationInterface employeeOperations;
	    public EmployeeApplication(){
	    	employeeOperations=new EmployeeOperationImplementation();
	    	
	    }
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
	        EmployeeApplication employeeApplication = new EmployeeApplication();
	        
	        System.out.println("************Employee System**********");
	        
	               
	        int choice = 0;
	        @SuppressWarnings("unused")
			int operations=0;
	        boolean flag=true;
	        while(flag==true){
	        	try{
	        		choice = UserUtil.chooseOperation();
	        		
	        	}
	        	catch(InputMismatchException exception){
	        		System.out.println(exception + " Please enter the valid choice");
	        		continue;
	        		
	        	}
	            switch (choice) {
	                case 1:
	                		employeeApplication.add();
	                    break;
	                case 2:
	                    employeeApplication.display();
	                      break;
	                case 3:
	                    employeeApplication.displayAll();
	                    break;
	                case 4:
	                		employeeApplication.update();
	                    break;
	                case 5:
	                		employeeApplication.delete();
	                    break;
	                default:
	                    System.out.println("Invalid Choice");
	            }
	        } 

	        scanner.close();
	    }
	    
	    

	    private void delete() throws SQLException {
	        System.out.println("Enter the employee id to delete :");
	        try{
	        	int empId = scanner.nextInt();
	        
	        boolean flag = employeeOperations.deleteEmployee(empId);
	        if (flag) {
	            System.out.println("Deleted successfully");
	        } else {
	            System.out.println("No employee found with given number : " + empId);
	        }
	        }
	        catch(InputMismatchException e){
	        	System.out.println(e + " Please enter the valid id");
	        }
	    }

	    private void update() throws SQLException{
	        System.out.println("Enter Employees data for update:");
	        Employee employee = UserUtil.readEmployee();
	        employeeOperations.updateEmployee(employee);
	    }

	    private void displayAll() throws SQLException {
	        System.out.println("Employees in the system are :");
	        List<Employee> employees = employeeOperations.findAll();
	        for (Employee employee : employees) {
	            System.out.println(employee);
	        }
	    }

	    private void display() throws SQLException {
	        System.out.println("Enter the employee id to view employee info :");
	        try{
	        	int empId = scanner.nextInt();
	        	Employee employee = employeeOperations.findEmployee(empId);
	        	System.out.println(employee);
	        }
	        catch(InputMismatchException e){
	        	System.out.println(e + " Please enter valid data");
	        }
	    }

	    private void add()  {
	        Employee employee = UserUtil.readEmployee();
	        boolean flag=employeeOperations.createEmployee(employee);
	        if(flag==true){
	        	System.out.println("Employee created successfully");
	        }
	    }


}
