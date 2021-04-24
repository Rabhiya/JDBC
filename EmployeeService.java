package com.services;
import com.models.Employee;

public interface EmployeeService {

			boolean addDetails(Employee emp);
			void displayDetails();
			boolean removeDetails(Employee emp);
			boolean updateDetails(Employee oldemp, Employee newemp);
	}

