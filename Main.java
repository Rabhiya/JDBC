package main;

import controller.EmployeeController;

public class Main {

	public static void main(String[] args) {
		EmployeeController employeeContoller = new EmployeeController();
		employeeContoller.handleRequest();

	}
}