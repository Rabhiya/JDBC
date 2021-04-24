package com.models;

public class Employee {
	private long employeeId = 11025;
	private String employeeName;
	private int employeeAge;
	private String employeeAddress;

	public Employee(long employeeId, String employeeName, int employeeAge, String employeeAddress) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeAddress = employeeAddress;
	}

	public static Employee createNew(long employeeID, String name, int age, String address) {

		return new Employee(employeeID, name, age, address);

	}

	public long getId() {
		return employeeId;
	}
	
	public void setId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return employeeName;
	}

	public int getAge() {
		return employeeAge;
	}

	

	public String getAddress() {
		return employeeAddress;
	}

}
