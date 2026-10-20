package com.ys.hospital;

public class SpecialistDoctor extends Doctor {
	
	private final int specialistDoctorId;
	private final String specialization;
	private final double specialistSurcharge;
	private static int specialistDoctorCount = 0;
	
	//constructor
	public SpecialistDoctor(String name, String phoneNumber, String department, 
			double monthlySalary, double consultationFee, int patientsSeen, 
			String specialization, double specialistSurcharge) {
		
		super(validateSpecialistDoctor(name, specialization, specialistSurcharge), 
			 phoneNumber, department, monthlySalary, consultationFee, patientsSeen);
		
		this.specialization = specialization;
		this.specialistSurcharge = specialistSurcharge;
		specialistDoctorCount ++;
		this.specialistDoctorId = specialistDoctorCount;
	}
	
	public static String validateSpecialistDoctor(String name, String specialization, 
			double specialistSurcharge) {
				
				if (specialization == null || specialization.isBlank()) {
					throw new IllegalArgumentException("Invalid specialization");
				}
				if (specialistSurcharge < 0 || specialistSurcharge > 10000.00) {
					throw new IllegalArgumentException("Invalid specialistSurcharge");
				}
				return name;
			}
	
	//overriden calculateConsultationFee()
	@Override
	public double calculateConsultationFee() {
		return super.calculateConsultationFee() + this.specialistSurcharge;
	}
	
	//overriden displayStaffDetails()
	@Override
	public void displayStaffDetails() {
		super.displayStaffDetails();
		System.out.println("Specialist Doctor: " + this.specialistDoctorId);
		System.out.println("Specialization: " + this.specialization);
		System.out.println("Specialization Surcharge: " + this.specialistSurcharge);
	}
	
	//overriden calculateMonthlyCompensation()
	@Override
	public double calculateMonthlyCompensation() {
		return super.calculateMonthlyCompensation() + this.specialistSurcharge * this.patientsSeen;
	}
}

