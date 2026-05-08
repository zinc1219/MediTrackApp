public class UrgentOnlyDoctorNotifier implements AdmissionObserver {

    private String doctorName;

    public UrgentOnlyDoctorNotifier(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {

        if (riskScore >= 70) {

            System.out.println("[URGENT Doctor " + doctorName + "] "
                    + patientName
                    + " requires immediate attention!");
        }
    }
}