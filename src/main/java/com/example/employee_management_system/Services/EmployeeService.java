package com.example.employee_management_system.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee_management_system.Entity.Employee;
import com.example.employee_management_system.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;
	
	// Get All Employee
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	// Save an Employee
	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	
	// Get Employee By Id
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		if(emp == null) {
			throw new RuntimeException("Employee not found");
		}
		return emp.get();
	}
	
	// Delete an Employee by Id
	public String deleteEmployeeById(Long id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		if(emp == null) {
			throw new RuntimeException("Employee Not FOund");
		}
		employeeRepo.deleteById(id);
		return "Deleted: " + emp.get().getFirstName() + " " + emp.get().getLastName();
	}
}
