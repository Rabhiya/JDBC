package controller;

import java.util.Scanner;

import com.models.Employee;
import com.services.EmployeeServiceImpl;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement; 
import java.sql.*;

public class EmployeeController {
	private Scanner sc = new Scanner(System.in);
	private EmployeeServiceImpl empList = new EmployeeServiceImpl();

	    public void handleRequest() {
		boolean back = false;
		displayMenu();
		System.out.print("\t\t\t Welcome to the Employee registration system\n");
		while (!back) {
			//System.out.print("\t\t\t Welcome to the Employee registration system\n");

			String choice = sc.nextLine();
			try {
				int Choice = Integer.parseInt(choice);
				switch (Choice) {
				case 0:
					System.out.println("Employee registration system closed");
					back = true;
					break;
				case 1:
					addEmployee();
					break;
				case 2:
					empList.displayDetails();
					break;
					
				case 3:
					updateEmployee();
					break;

				case 4:
					deleteEmployee();
					break;

				case 5:
					searchEmployee();
					break;

				case 6:
					displayMenu();
					break;
				
					default:
						System.out.println("Press the right key.\n OR Type 6 to display the menu");
				}

			} catch (Exception e) {
				System.out.println("Something went wrong type 6 to try again");
			}
		}

	}

	public void addEmployee() {
		try {
			System.out.print("Enter the employee name: ");
			String name = sc.nextLine();
			System.out.print("Enter employee age: ");
			String age = sc.nextLine();
			int Age = Integer.parseInt(age);
			System.out.print("Enter employee address: ");
			String address = sc.nextLine();
			Employee newEmployee = Employee.createNew(empList.Id(), name, Age, address);
			System.out.println("Records saved successfully.");
			System.out.println("\n Your Employee id:" +newEmployee.getId());
			empList.addDetails(newEmployee);
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/Employee","root","Riya@1997");  
            PreparedStatement Pstatement=con.prepareStatement("insert into emp values(?,?,?,?)");
            Pstatement.setLong(1,empList.Id());
            Pstatement.setString(2,name);
            Pstatement.setInt(3,Age);
            Pstatement.setString(4,address);
            Pstatement.executeUpdate();
             

		} catch (SQLException e) {
			System.out.println("Something wrong in addition process");
			e.printStackTrace();
		}

	}

	public void deleteEmployee() {
		try {
			System.out.print("Please enter the id: ");
			String id = sc.nextLine();
			int ID = Integer.parseInt(id);
			Employee search = empList.search(ID);

			if (search == null) {
				System.out.println("Record does not exists for ID: " + ID);
			}
			if (empList.removeDetails(search)) {
				System.out.println("Records for ID: " + search.getId() + " deleted successfully");
			} else {
				System.out.println("Deletion is not possible ");
			}
		} catch (Exception e) {
			System.out.println("Something wrong in deletion process");
		}

	}

	public void searchEmployee() {
		try {
			System.out.print("Please enter the id: ");
			String id = sc.nextLine();
			int ID = Integer.parseInt(id);
			Employee recordEmployee = empList.search(ID);

			if (recordEmployee == null) {
				System.out.println("Record does not exists for ID: " + ID);
			} 
			else {
				System.out.println("Employee Id: " + recordEmployee.getId() + "\n Employee Name: "+ recordEmployee.getName() + "\n Employee age: " + recordEmployee.getAge()+ "\n Employee Address: " + recordEmployee.getAddress());

			}
		} catch (Exception e) {
			System.out.println("Something wrong in search process");

		}

	}

	public void displayMenu() {
		System.out.println("Type here:" + "\nType 0 to close\n" + "Type 1 to Add Employee\n"+ "Type 2 to Display Employee details\n" + "Type 3 to Update Employee details\n"+ "Type 4 to Remove Employee details\n" + "Type 5 to Search Employee details \n");
	}

	public void updateEmployee() {
		try {
			System.out.print("Please enter the id: ");
			String id = sc.nextLine();
			int ID = Integer.parseInt(id);
			Employee recordEmployee = empList.search(ID);

			if (recordEmployee == null) {
				System.out.println("Record does not exists for ID: " + ID);
			} else {
				System.out.print("Enter the new employee name: ");
				String name = sc.nextLine();
				System.out.print("Enter new employee age: ");
				String age = sc.nextLine();
				int integerAge = Integer.parseInt(age);
				System.out.print("Enter new employee address: ");
				String address = sc.nextLine();
				Employee newEmployee = Employee.createNew(recordEmployee.getId(), name, integerAge, address);

				if (empList.updateDetails(recordEmployee, newEmployee)) {
					System.out.println("Successfully Updated");
				} else {
					System.out.println("Update Unsuccessful");
				}
			}

		} catch (Exception e) {
			System.out.println("Error in updating details");

		}
		sc.close(); 
	}
	
}
