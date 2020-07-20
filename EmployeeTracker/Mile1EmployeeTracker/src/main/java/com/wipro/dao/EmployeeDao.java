package com.wipro.dao;

import java.util.List;

import com.wipro.bean.Employee;

public class EmployeeDao {
	
	private static List<Employee> employees;

	public static List<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(List<Employee> employees) {
		EmployeeDao.employees = employees;
	}
	
	
	
	public String saveEmployee(Employee emp){
		employees.add(emp);
		return "SUCCESS";
	}
	
//	public Employee readEmployeeByName(String name){
//		
//		return null;
//	}
//	
//	public Employee readEmployeeByCellnumber(int num){
//		
//		return null;
//	}
//	
//	public List<Integer> readEmployeeCellnumbers(int empId){
//		
//		return null;
//	}
//	
//	public boolean updateEmployee(Employee emp){
//	
//	return false;
//}
//
//public String removeEmployee(Employee emp){
//	
//	return null;
//}

}
