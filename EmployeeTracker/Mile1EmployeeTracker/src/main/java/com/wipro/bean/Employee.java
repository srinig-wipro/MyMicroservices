package com.wipro.bean;

import java.util.List;

public class Employee {

	int id;
	String name;
	List<Integer> cellNumbers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getCellNumbers() {
		return cellNumbers;
	}
	public void setCellNumbers(List<Integer> cellNumbers) {
		this.cellNumbers = cellNumbers;
	}
	
	public Employee(int id, String name, List<Integer> cellNumbers) {
		super();
		this.id = id;
		this.name = name;
		this.cellNumbers = cellNumbers;
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	public Employee(){
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cellNumbers="
				+ cellNumbers + "]";
	}
	
	
	
}
