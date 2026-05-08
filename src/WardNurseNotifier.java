public class WardNurseNotifier implements AdmissionObserver {

    private String wardName;

    public WardNurseNotifier(String wardName) {
        this.wardName = wardName;
    }

    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {

        System.out.println("[Nurse - " + wardName + "] Prepare bed for "
                + patientName);
    }
}