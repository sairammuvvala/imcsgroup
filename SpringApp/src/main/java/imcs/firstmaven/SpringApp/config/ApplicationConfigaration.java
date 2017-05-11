package imcs.firstmaven.SpringApp.config;


import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.ComponentScan; 
import org.springframework.context.annotation.Configuration;

import imcs.firstmaven.SpringApp.EmployeeCollectionImplementation.EmployeeCollectionImplementation;
import imcs.firstmaven.SpringApp.EmployeeCollectionInterface.EmployeeCollectionInterface;
import imcs.training.employeeapp.employeeApp.Employee; 


public class ApplicationConfigaration {
	
	@Configuration
	@ComponentScan(basePackages={"imcs.firstmaven.SpringApp.*"})


	public class ApplicationConfiguration {
			@Bean
			public EmployeeCollectionInterface getCollectionObject(){
				return new EmployeeCollectionImplementation();
			}
			
			@Bean
			public Employee getEmployee(){
				return new Employee();
			}

		}
	

}
