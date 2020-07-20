package com.wipro.main;

import java.util.ArrayList;
import java.util.List;

import com.wipro.bean.Employee;
import com.wipro.service.EmployeeTracker;

public class EmployeeTrackerMain {
	
	public static void main(String[] args) {

		// Pre defined Employee details
		List<Integer> patelNumbers=new ArrayList<Integer>();
		List<Integer> andaniNumbers=new ArrayList<Integer>();
		List<Integer> bonganiNumbers=new ArrayList<Integer>();
		
		patelNumbers.add((int) 9986688033l);
		patelNumbers.add((int) 725637266l);		
		andaniNumbers.add(712833045);
		andaniNumbers.add(612735437);		
		bonganiNumbers.add(792895651);
		
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp1 = new Employee(1, "patel", patelNumbers);
		Employee emp2 = new Employee(2, "andani", andaniNumbers);
		Employee emp3 = new Employee(3, "bongani", bonganiNumbers);
		Employee emp4 = new Employee(4, "raj");

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		EmployeeTracker et = new EmployeeTracker(employees);
		
		//1. check predefined employees
		System.out.println("Employees records defined count: "+et.getEmployees().size());
		
		//2.create new Employee Profile ( No duplicate names are allowed)
		System.out.println("Employees profile creation status: "+et.createEmployeeProfile(new Employee(8,"avi")));
		System.out.println("Employees records current count: "+et.getEmployees().size());
		System.out.println("Employees profile creation status: "+et.createEmployeeProfile(new Employee(9,"avi")));
		
		//3. Display All employee details
		System.out.println("Employee Detials: "+et.getEmployees());
		
		//4. Display employee details for given name='patel', name='xyz'
		System.out.println("Employee Details of 'patel': "+et.getEmployeeByName("patel"));
		System.out.println("Employee Details of 'xyz': "+et.getEmployeeByName("xyz"));
		
		//5. Display employee details for given id= 2 and id=5
		System.out.println("Employee Details of '2': "+et.getEmployeeById(2));
		System.out.println("Employee Details of '5': "+et.getEmployeeById(5));
		
		//6. Display employee contact numbers for given id=2 and id=4
		System.out.println("Employee Details of '2': "+et.getEmployeeCellNumbers(2));
		System.out.println("Employee Details of '4': "+et.getEmployeeCellNumbers(4));
	} 

}
