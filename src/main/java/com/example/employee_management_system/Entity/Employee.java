package com.example.employee_management_system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee Details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
	
	@Column(name = "First Name")
     private String firstName;
	@Column(name = "Last Name")
     private String lastName;
	@Column(name = "Email Id)")
     private String email;
     
     public Employee() {
    	 
     }
     
     public Employee(String firstName, String lastName, String email) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.email = email;
     }
     
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}  
	
	@Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
