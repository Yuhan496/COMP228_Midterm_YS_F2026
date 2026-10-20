package com.ys.hospital;

public class Nurse extends MedicalStaff {

	private final int nurseId;
	private final String shiftType;
    private final double shiftAllowance;
    private static int nurseCounter = 0;

    // Constructor
    public Nurse(String name, String phoneNumber,
            String department, double monthlySalary,
            String shiftType, double shiftAllowance) {

        super(validateNurse(name, shiftType, shiftAllowance),
                phoneNumber, department, monthlySalary);

        this.shiftType = shiftType;
        this.shiftAllowance = shiftAllowance;
        nurseCounter ++;
        this.nurseId = nurseCounter;
    }

    private static String validateNurse(String name,
            String shiftType, double shiftAllowance) {

        if (shiftType == null || shiftType.isBlank()) {
            throw new IllegalArgumentException("Invalid shift type");
        }

        if (shiftAllowance < 0 || shiftAllowance > 1000.00) {
            throw new IllegalArgumentException("Invalid shift allowance");
        }

        return name;
    }

    // Override calculateMonthlyCompensation()
    @Override
    public double calculateMonthlyCompensation() {
        return this.monthlySalary + shiftAllowance;
    }

    // Override displayStaffDetails()
    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Shift Type: " + shiftType);
        System.out.println("Shift Allowance: " + shiftAllowance);
        System.out.println("Monthly Compensation: "
                + calculateMonthlyCompensation());
    }

    // Override getRoleDescription()
    @Override
    public String getRoleDescription() {
        return "Nurse";
    }
}
