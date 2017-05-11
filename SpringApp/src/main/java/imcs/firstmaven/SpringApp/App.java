package imcs.firstmaven.SpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import imcs.firstmaven.SpringApp.EmployeeServiceImplementation.EmployeeServiceImplements;
import imcs.firstmaven.SpringApp.config.ApplicationConfigaration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfigaration.class); 
        EmployeeServiceImplements employeeService = appContext.getBean(EmployeeServiceImplements.class); 
    	employeeService.findAll(); 

    }
}
