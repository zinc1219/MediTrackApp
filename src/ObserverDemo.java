public class ObserverDemo {

    public static void main(String[] args) {

        Hospital hospital = new Hospital("MediTrack Central");

        // Create observers
        UrgentOnlyDoctorNotifier doctor =
                new UrgentOnlyDoctorNotifier("Dr. Lim");

        BillingNotifier billing = new BillingNotifier();

        AuditNotifier audit = new AuditNotifier();

        WardNurseNotifier nurse =
                new WardNurseNotifier("Ward A");

        // Register observers
        hospital.addObserver(doctor);
        hospital.addObserver(billing);
        hospital.addObserver(audit);
        hospital.addObserver(nurse);

        // First admission
        System.out.println("=== First Admission ===");

        hospital.admitPatient("Maria Santos", 80);

        // Remove nurse observer
        hospital.removeObserver(nurse);

        System.out.println();

        // Second admission
        System.out.println("=== Second Admission ===");

        hospital.admitPatient("Ahmad Razali", 25);
    }
}