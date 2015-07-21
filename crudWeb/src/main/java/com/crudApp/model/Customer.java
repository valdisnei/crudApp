package com.crudApp.model;

public class Customer {	
	
	private long id;
	
	private String name;
	
	private String lastName;
	
	
	public Customer(String name,String lastName) {
		this.name=name;
		this.lastName=lastName;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
}
