package com.example.employee_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_management_system.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
