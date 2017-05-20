package employeeUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

import pojo.Employee;

public class UserUtil {
	
	 private static Scanner scanner ;//= new Scanner(System.in);

	    public static int chooseOperation() throws InputMismatchException {
	    	scanner  = new Scanner(System.in);
	        System.out.println();
	        System.out.println("   ||| MENU |||   ");
	        System.out.println("1. Create trng.Employee");
	        System.out.println("2. Read(View) trng.Employee");
	        System.out.println("3. View all Employees");
	        System.out.println("4. Update trng.Employee");
	        System.out.println("5. Delete trng.Employee");
	       
	        System.out.print("Select a choice :");
	        int id=scanner.nextInt();
	        	return id;
	    }

	    public static Employee readEmployee() {
	    	scanner = new Scanner(System.in);
	    	boolean flag=true;
	    	while(flag==true){
	    		
	    	try{
	        System.out.print("Enter trng.Employee id:");
	        int id = scanner.nextInt();

	        System.out.print("Enter trng.Employee firstname:");
	        String firstName = scanner.next();

	        System.out.print("Enter trng.Employee lastname:");
	        String lastName = scanner.next();

	        

	        System.out.println("Enter the gender male or female");
	        String gender = scanner.next();
	        
	        System.out.print("Enter trng.Employee Salary: between (1 and 100000)");
	        int salary = scanner.nextInt();
	        
	        return new Employee(id, firstName, lastName, gender,salary);
	        }
	    	catch(InputMismatchException e){
	    	}
	    	}
			return null;	
	        
	    }

}
