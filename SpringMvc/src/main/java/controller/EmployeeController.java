package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import arrayOperations.Employee;
import arrayOperations.EmployeeCreationException;
import arrayOperations.InvalidSalaryException;
import imcs.firstmaven.SpringApp.EmployeeServiceInterface.EmployeeServiceInterface;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceInterface employeeservice;
	
	
	@RequestMapping(value="/newEmployee")
	public String createEmployee(Model model) {
		model.addAttribute(new Employee());
		return "createemployee";
	}
	
	@RequestMapping(value="/createemployee", method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute Employee employee) throws EmployeeCreationException, InvalidSalaryException {
		ModelAndView model = new ModelAndView();
		employeeservice.createEmployee(employee);
		model.addObject("message", "employee created successfully");
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value="/updateEmployee")
	public String updateEmployee(Model model){
		return "updateEmployee";
	}
	@RequestMapping(value="/updateEmployee",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute Employee employee){
		ModelAndView model = new ModelAndView();
		try {
			employeeservice.updateEmployee(employee);
			model.addObject("message", "Employee updated Successfully");	
		} catch (InvalidSalaryException e) {
			e.printStackTrace();
		} catch (EmployeeCreationException e) {
			e.printStackTrace();
		} 		
		return model;
	}
	 
	 @RequestMapping(value="/deleteEmployee",method=RequestMethod.POST)
		public ModelAndView deleteEmployee(@ModelAttribute Employee employee){
			ModelAndView model = new ModelAndView();
				try {
				employeeservice.deleteEmployee(employee.getId());
				model.addObject("message", "Employee deleted Successfully");	
			} catch (NumberFormatException e){
				e.printStackTrace();
			} 	
			model.setViewName("updateEmployee");
			return model;
		}
	 @ModelAttribute
	 public Model modelEmployee(Model model){
		 model.addAttribute(new Employee());
		 return model;
	 }

}
