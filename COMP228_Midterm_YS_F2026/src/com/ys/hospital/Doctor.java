package com.ys.hospital;
import java.util.ArrayList;

public class Doctor extends MedicalStaff implements Reportable, Schedulable{
	
	private final int doctorId;
	private final double consultationFee;
	protected int patientsSeen;
	private static int doctorCount;
	private final ArrayList<String> appointments = new ArrayList<>();
	
	//constructor
	public Doctor(String name, String phoneNumber, String department, double monthlySalary,
			double consultationFee, int patientsSeen) {
		
		super(validateDoctor(name, consultationFee, patientsSeen), phoneNumber, department, 
				monthlySalary);
		
		this.consultationFee = consultationFee;
		this.patientsSeen = patientsSeen;
		doctorCount ++;
		this.doctorId = doctorCount;
	}
	
	public static String validateDoctor(String name, double consultationFee, int patientsSeen) {
		if (consultationFee < 0 || consultationFee > 10000.00) {
			throw new IllegalArgumentException("Invalid consulation fee");
		}
		if (patientsSeen < 0) {
			throw new IllegalArgumentException("Invalid patients seen");
		}
		return name;
	}
	
	//override calculateMonthlyCompensation()
	@Override
	public double calculateMonthlyCompensation() {
		double performanceAllowance = this.consultationFee * this.patientsSeen;
		return this.monthlySalary + performanceAllowance;
	}
	
	// Override getRoleDescription()
    @Override
    public String getRoleDescription() {
        return "Doctor";
    }
    
	//override displayStaffDetails()
	@Override
	public void displayStaffDetails() {
		super.displayStaffDetails();
		System.out.println("Doctor ID: " + this.doctorId);
		System.out.println("Consultation Fee: " + this.consultationFee);
		System.out.println("Patients Seen: " + this.patientsSeen);
	}
	
	//overloading method calculateConsulationFee()
	public double calculateConsultationFee() {
		return this.consultationFee;
	}
	
	public double calculateConsultationFee(double discount) {
		if (discount < 0 || discount > 1) {
			throw new IllegalArgumentException("Invalid discount");
		}
		return this.consultationFee * (1-discount);
	}
	
	public double calculateConsultationFee(double discount, double additionalCharge) {
		if (discount < 0 || discount > 1) {
			throw new IllegalArgumentException("Invalid discount");
		}
		if (additionalCharge < 0 || additionalCharge > 10000.00) {
			throw new IllegalArgumentException("Invalid additional charge");
		}
		return this.consultationFee * (1-discount) + additionalCharge;
	}
	
	// Implement Reportable interface
	@Override
	public void generateReport() {
	    System.out.println("Doctor Report");
	    displayStaffDetails();
	    System.out.println("Appointments: " + appointments);
	}

	// Implement Schedulable interface
	@Override
	public void scheduleAppointment(String appointmentDate) {

	    if (appointmentDate == null || appointmentDate.isBlank()) {
	        throw new IllegalArgumentException("Invalid appointment date");
	    }

	    appointments.add(appointmentDate);

	    System.out.println("Appointment scheduled for: "
	                       + appointmentDate);
	}
}
