package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import com.wipro.bean.Employee;
import com.wipro.dao.EmployeeDao;

public class EmployeeTracker {


	public EmployeeTracker() {
		
	}

	public EmployeeTracker(List<Employee> employees) {

		EmployeeDao.setEmployees(employees);
	}
	
	public String createEmployeeProfile(Employee emp){
		String response="Unable to create profile...seems already given name exists";
		boolean isProfileExists=false;
		if(emp!=null&&emp.getName()!=null){
			
			List<Employee> employees=EmployeeDao.getEmployees();
			for(Employee e:employees){				
				if(e.getName().equals(emp.getName())){
					isProfileExists=true;
					break;
				}				
			}
			if(!isProfileExists){
				employees.add(emp);
				response="New recorded created...";
			}
		}
		return response;
	}


	public Employee getEmployeeById(int id) {
		Employee emp = null;
		List<Employee> employees=EmployeeDao.getEmployees();

		if (id > 0) {
			for (Employee e : employees) {
				if (id == e.getId()) {
					emp = e;
				}
			}
		}
		return emp;
	}
	
	public Employee getEmployeeByName(String name) {
		Employee emp = null;
		
		List<Employee> employees=EmployeeDao.getEmployees();

		if (name!=null ) {
			for (Employee e : employees) {
				if (name.equals(e.getName())) {
					emp = e;
				}
			}
		}
		return emp;
	}

	public List<Integer> getEmployeeCellNumbers(int empid) {

		List<Integer> foundCellNumbers = null;
		List<Employee> employees=EmployeeDao.getEmployees();
		for (Employee e : employees) {
			if (e != null && e.getId()==empid) {
				if (e.getCellNumbers() != null && e.getCellNumbers().size() > 0) {
					foundCellNumbers=e.getCellNumbers();
				}
			}
		}

		return foundCellNumbers;
	}

	// input num is verified for number cell numbers emp has
	// as many employees has num then all employee to be returned
	// otherwise return null

	public List<Employee> getEmployees() {
		List<Employee> employees=EmployeeDao.getEmployees();
		return employees;
	}



}
