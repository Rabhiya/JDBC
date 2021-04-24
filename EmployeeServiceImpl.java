package com.services;

import java.util.ArrayList;
import java.util.List;

import com.models.*;

public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> empList=new ArrayList<Employee>();


	public boolean addDetails(Employee Emp) {
			empList.add(Emp);
			return true;

	}
	private int intEmployee(int EmpId) {

		for (int i = 0; i < empList.size(); i++) {
			Employee employee = empList.get(i);
			if (employee.getId() == EmpId) {
				return i;
			}

		}
		return -1;

	}


	private int index(Employee Emp) {
		return this.empList.indexOf(Emp);
	}

	private int equalsEmployee(String EmpName) {

		for (int i = 0; i < empList.size(); i++) {
			Employee employee = empList.get(i);
			if (employee.getName().equals(EmpName)) {
				return i;
			}

		}
		return -1;

	}

	
	public Employee search(int EmpID) {
		int index =intEmployee(EmpID);

		if (index >= 0) {
			return this.empList.get(index);
		} else {
			return null;
		}
	}

	public void displayDetails() {
		System.out.println("Employee List");

		for (int i = 0; i < empList.size(); i++) {
			System.out.println("Employee Id: " + empList.get(i).getId() + ", Employee Name: "+ empList.get(i).getName() + ", Employee age: " + empList.get(i).getAge()+ ", Employee Address: " + empList.get(i).getAddress());
		}
	}

	public long Id() {
		if (empList.size() > 0) {
			return (empList.get(empList.size() - 1).getId()) + 1;
		} else {
			return 11025;
		}
	}

	public boolean removeDetails(Employee emp) {

		int index = index(emp);

		if (index >= 0) {
			this.empList.remove(index);
			System.out.println("Record for " + emp.getId() + " deleted successfully");
			return true;
		} else {
			System.out.println(" deletion not possible in this id: "+ emp.getId());
			return false;
		}
	}

	public boolean updateDetails(Employee oldemp, Employee newemp) {
		int id = index(oldemp);
		if (id < 0) {
			System.out.println("Can not find any record with ID: " + oldemp.getId());
			return false;
		} else if (equalsEmployee(newemp.getName()) != -1) {
			System.out.println("Employee Name: " + newemp.getName() + " already exists");
			return false;

		} else {

			this.empList.set(id,newemp);
			System.out.println("Records for " + oldemp.getId() + " changed");
			return true;
		}

	}

}



