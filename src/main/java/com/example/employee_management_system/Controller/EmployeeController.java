package com.example.employee_management_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.employee_management_system.Entity.Employee;
import com.example.employee_management_system.Services.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
	EmployeeService employeeService;
    
    
    @GetMapping("/")
    public String viewHomePage(Model model) {
       //We can use this attribute "listEmployees" to perform server-side rendering of the HTML with using Thymeleaf.
       //We set all employees data to "listEmployees"
    	model.addAttribute("listEmployees", employeeService.getAllEmployees());
    	// shows the index.html template;
    	return "index";
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeForm(Model model) {
    	Employee employee = new Employee();
    	
    	model.addAttribute("employee" , employee);
    	
    	// shows the new_employee.html template
    	return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmpoyee(@ModelAttribute("employee") Employee employee) {
    	employeeService.saveEmployee(employee);
    	return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable Long id , Model model) {
    	Employee employee = employeeService.getEmployeeById(id);
    	
    	// we set employee data to "employee"
    	model.addAttribute("employee" , employee);
    	
    	return "update_employee";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id , Model model) {
    	employeeService.deleteEmployeeById(id);
    	
    	return "redirect:/";
    }
}
