package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Employee;
import model.OutsourcedEmployee;

public class Menu {
	public Menu() {
	}
	
	public void show() {
		Integer numberEmployees;
		List<Employee> employeesList = new ArrayList<>();
	
		numberEmployees = readInteger("Enter the number of employees:");	
		for(int i = 1; i <= numberEmployees; i++) {
			System.out.println("Employee #" + i + " data:");
			employeesList.add(readEmployeeData()); 
		}
		
		for(Employee employee : employeesList) {
			System.out.println(employee.getName() + " - " + employee.payment());
		}
	}
	
	public Employee readEmployeeData() {
		String outSourced = readString("Outsourced (y/n)?").toUpperCase();
		Employee employee = null;
		
		switch(outSourced){
			case "N":
				employee = new Employee(
							readString("Name:"), 
							readInteger("Hours:"), 
							readDouble("Value per hour:"));
				break;
			case "Y":
				employee = new OutsourcedEmployee(
							readString("Name:"), 
							readInteger("Hours:"), 
							readDouble("Value per hour:"), 
							readDouble("Additional charge:"));
				break;
			default:
				System.out.println("Invalid option");
				readEmployeeData();
		}
		return employee;
	}
	
	Scanner sc = new Scanner(System.in);
	public String readString(String text) {
		sc.nextLine();
		System.out.println(text);
		return sc.next();
	}
	
	public Integer readInteger(String text) {
		System.out.println(text);
		return sc.nextInt();
	}
	
	public Double readDouble(String text) {
		System.out.println(text);
		return sc.nextDouble();
	}
}
