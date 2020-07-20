package com.wipro.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wipro.bean.Employee;

public class EmployeeServiceTest {



	@Test
	public void testGetEmployeeById() {
		
		List<Employee> emps=setData();
		
		
		assertNull(new EmployeeTracker(emps).getEmployeeById(-1));
		assertNull(new EmployeeTracker(emps).getEmployeeById(7));
		
		Employee actualE1=new EmployeeTracker(emps).getEmployeeById(1);
		
		assertNotNull(actualE1);
		assertEquals("A", actualE1.getName());		
		assertNull(actualE1.getCellNumbers());
		
		Employee actualE2=new EmployeeTracker(emps).getEmployeeById(3);
		
		assertNotNull(actualE2);
		assertEquals("C", actualE2.getName());		
		assertNotNull(actualE2.getCellNumbers());
		int i=actualE2.getCellNumbers().get(0);
		assertEquals(3345,i);	
		
	}

	@Test
	public void testGetEmployeesByCellNumbers() {
		List<Employee> emps=setData();
		
		
//		List<Integer> foundEmps1=new EmployeeTrackerService(emps).getEmployeeCellNumbers(0);
//		assertNotNull(foundEmps1);
//		assertEquals(2,foundEmps1.size());
//		
//		List<Employee> foundEmps2=new EmployeeTrackerService(emps).getEmployeeCellNumbers(3);
//		assertNotNull(foundEmps2);
//		assertEquals(1,foundEmps2.size());
//		
//		List<Employee> foundEmps3=new EmployeeTrackerService(emps).getEmployeeCellNumbers(1);
//		assertNotNull(foundEmps3);
//		assertEquals(2,foundEmps3.size());
		
		
	}
	
	
	
	List<Employee> setData(){
List<Employee> emps=new ArrayList<Employee>();
		
		List<Integer> e2Nums=new ArrayList<Integer>();
		e2Nums.add(1234);
		
		List<Integer> e3Nums=new ArrayList<Integer>();
		e3Nums.add(3345);
		e3Nums.add(6685);
		
		List<Integer> e4Nums=new ArrayList<Integer>();
		e4Nums.add(7898);
		e4Nums.add(4536);
		e4Nums.add(97897);
		
		List<Integer> e5Nums=new ArrayList<Integer>();
		e5Nums.add(44444);		
		
		Employee e1=new Employee(1,"A",null);
		Employee e2=new Employee(2,"B",e2Nums);
		Employee e3=new Employee(3,"C",e3Nums);
		Employee e4=new Employee(4,"D",e4Nums);
		Employee e5=new Employee(5,"E",e5Nums);
		Employee e6=new Employee(6,"Z",new ArrayList<Integer>());
		
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);
		emps.add(e6);
		return emps;
	}

}
