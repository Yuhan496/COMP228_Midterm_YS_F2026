package com.ys.hospital;

public abstract class Person {
	
	protected final int personId;
	protected String name;
	private String phoneNumber;
	private static int personCount = 0;
	
	//constructor
	public Person(String name, String phoneNumber) {
		if (name == null || name.isBlank() || phoneNumber == null || phoneNumber.isBlank()) {
			throw new IllegalArgumentException("Name and phone number can not be empty.");
		}
		this.name = name;
		this.phoneNumber = phoneNumber;
		personCount ++;
		this.personId = personCount;
	}

	//static method 
	public static int getPersonCount() {
		return personCount;
	}
	
	//concrete method that child class can inherit
	public void displayBasicDetails() {
		System.out.println("Person ID: " + personId);
		System.out.println("Name: " + name);
		System.out.println("Phone Number: " + phoneNumber);
	}
	
	//abstract method that child class must override
	public abstract String getRoleDescription();
	
	//toString() 
	@Override
	public String toString() {
		return "Person ID: " + personId + "\nName: " + name + "\nPhone Number: " + phoneNumber;
	}
	
}
