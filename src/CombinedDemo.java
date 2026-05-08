public class CombinedDemo {

    public static void main(String[] args) {

        HospitalV2 hospital =
                new HospitalV2(
                        "MediTrack Central",
                        new ConservativeRiskStrategy()
                );

        hospital.addObserver(
                new UrgentOnlyDoctorNotifier("Dr. Lim"));

        hospital.addObserver(
                new BillingNotifier());

        hospital.addObserver(
                new AuditNotifier());

        hospital.admitPatient(
                "Maria Santos",
                38.7,
                62);

        System.out.println();

        hospital.admitPatient(
                "Ahmad Razali",
                36.8,
                25);
    }
}