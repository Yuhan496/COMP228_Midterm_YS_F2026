package com.ys.hospital;

public class Patient extends Person {
	
	private final int patientNumber;
	private int age;
	private String medicalDepartment;
	private double consultationFee;
	private static int patientCount = 0;
	
	//constructor
	public Patient(String name, String phoneNumber, int age, String medicalDepartment, 
			double consultationFee) { 
		super(validatePatient(name, age, medicalDepartment, consultationFee), phoneNumber);
	
		this.age = age;
		this.medicalDepartment = medicalDepartment;
		this.consultationFee = consultationFee;
		patientCount ++;
		this.patientNumber = patientCount;
	}
	
	private static String validatePatient(String name, int age, String medicalDepartment,
			double consultationFee) {
		
		if (age < 0 || age > 100) {
			throw new IllegalArgumentException("Invalid age");
		}
		if (medicalDepartment == null || medicalDepartment.isBlank()) {
			throw new IllegalArgumentException("Invalid medical department");
		}
		if (consultationFee < 0 || consultationFee > 10000.00) {
			throw new IllegalArgumentException("Invalid consultation fee");
		}
		return name;
	}
	
	//override getRoleDescritpion()
	@Override
	public String getRoleDescription() {
		return "Patient";
	}
	
	//implement displayPatientDetails()
	public void displayPatientDetails() {
		displayBasicDetails();
		System.out.println("Patient Number: " + patientNumber);
		System.out.println("Age: " + age);
		System.out.println("Medical Department: " + medicalDepartment);
		System.out.println("Consultation Fee: " + consultationFee);
		System.out.println("Role: " + getRoleDescription());
	}
	
	//implement overloaded method registerPatient()
	public void registerPatient(String name, int age) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (age < 0 || age > 100) {
			throw new IllegalArgumentException("Invalid age");
		}
		this.name = name;
		this.age = age;
		System.out.println("Patient's registration is successful");
	}
	
	public void registerPatient(String name, int age, String department) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (age < 0 || age > 100) {
			throw new IllegalArgumentException("Invalid age");
		}
		if (department == null || department.isBlank()) {
			throw new IllegalArgumentException("Invalid department");
		}
		this.name = name;
		this.age = age;
		this.medicalDepartment = department;
		System.out.println("Patient's registration with department is successful");
	}
	
	//static method
	public static int getPatientCount() {
	    return patientCount;
	}
}
