package com.ys.hospital;

public class MainDriver {

    public static void main(String[] args) {

        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM ===\n");

        // Patient registration
        Patient patient1 = new Patient("Lily Lane", "5192930001",
                30, "Cardiology", 20.0);
        Patient patient2 = new Patient("Daniel Brown", "1395019281",
                29, "Emergency", 150.0);

//        Patient invalidPatient = new Patient(
//        	    "John Smith", "4165551003",
//        	    -5, "General", 50.0);
//      
       patient1.registerPatient("Lily Lane", 30);
       patient1.displayPatientDetails();
        
        System.out.println("\n");
 
        patient2.registerPatient("Geroge Brown", 29, "Emergency");
        patient2.displayPatientDetails();
          System.out.println("\n");

        // Create medical staff
        System.out.println("DOCTOR DETAILS");
        Doctor doctor = new Doctor("Dr. Karl James", "4823782001",
                "Cardiology", 9000.0, 150.0, 100);
        doctor.displayStaffDetails();
        System.out.println("\n");

        System.out.println("SPECIALIST DOCTOR DETAILS");
        SpecialistDoctor specialist = new SpecialistDoctor(
                "Dr. Peter James", "123948902", "Neurology",
                11000.0, 200.0, 40, "Neurology", 50.0);
        specialist.displayStaffDetails();
        System.out.println("\n");

        System.out.println("NURSE DETAILS");
        Nurse nurse = new Nurse("Williams Grant", "1248378003",
                "Emergency", 5000.0, "Night", 500.0);
        nurse.displayStaffDetails();
        System.out.println("\n");

        // Runtime polymorphism
        MedicalStaff staff1 = doctor;
        MedicalStaff staff2 = specialist;
        MedicalStaff staff3 = nurse;

        System.out.println("Monthly Compensation for different staffs");
        System.out.println("Compensation for Dr. Karl James: $" + 
        staff1.calculateMonthlyCompensation());

        System.out.println("Compensation for Dr. Peter James: $" + 
        staff2.calculateMonthlyCompensation());

        System.out.println("Compensation for Williams Grant: $" + 
        staff3.calculateMonthlyCompensation());
        System.out.println("\n");

        // Method overloading
        System.out.println("CONSULTATION FEE CALCULATIONS FOR DR. KARL JAMES");

        System.out.println("Standard Consultation Fee: $" +
            doctor.calculateConsultationFee());
        System.out.println("Consultation Fee After Discount : $" + 
            doctor.calculateConsultationFee(0.10));
        System.out.println("Consultation Fee With Additional Charge: $"
                + doctor.calculateConsultationFee(0.10, 125.0));
        System.out.println("\n");

       // Interfaces
        System.out.println("INTERFACES");
        doctor.scheduleAppointment("2026-11-12 10:00 AM");
        doctor.generateReport();
        System.out.println("\n");

        // Static counters
        System.out.println("REGISTRATION SUMMARY");

        System.out.println("Total people: " + Person.getPersonCount());
        System.out.println("Total patients: " + Patient.getPatientCount());
        System.out.println("Total medical staff: " + MedicalStaff.getStaffCount());
    }
}
