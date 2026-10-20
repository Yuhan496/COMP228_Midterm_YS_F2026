package com.ys.hospital;

public abstract class MedicalStaff extends Person{
	
	private final int staffId;
	private String department;
	protected double monthlySalary;
	private static int staffCount = 0;
	
	//constructor
	public MedicalStaff(String name, String phoneNumber, String department, double monthlySalary)
	{
		super(validateStaff(name, department, monthlySalary), phoneNumber);
		this.department = department;
		this.monthlySalary = monthlySalary;
		staffCount ++;
		this.staffId = staffCount;
	}
	
	private static String validateStaff(String name, String department, double monthlySalary) {
		if (department == null || department.isBlank()) {
			throw new IllegalArgumentException("Invalid department");
      	}
		if (monthlySalary < 0 || monthlySalary > 100000.00) {
			throw new IllegalArgumentException("Invalid montly salary");
		}
		return name;
	}
	
	//abstract method
	public abstract double calculateMonthlyCompensation();
	
	//override getRoleDescription
		@Override
		public String getRoleDescription() {
			return "Medical Staff";
			}
	
	//concrete method
	public void displayStaffDetails() {
		displayBasicDetails();
		System.out.println("staffId: " + staffId);
		System.out.println("Department: " + department);
		System.out.println("Monthly Salary: " + monthlySalary);
		System.out.println("Role: " + getRoleDescription());
	}
	
	//static method
	public static int getStaffCount() {
	    return staffCount;
	}
	
}
