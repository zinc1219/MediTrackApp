import java.util.ArrayList;
import java.util.List;

public class HospitalV2 {

    private List<AdmissionObserver> observers =
            new ArrayList<>();

    private RiskCalculationStrategy strategy;

    private String hospitalName;

    public HospitalV2(String hospitalName,
                      RiskCalculationStrategy strategy) {

        this.hospitalName = hospitalName;
        this.strategy = strategy;
    }

    public void addObserver(AdmissionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AdmissionObserver observer) {
        observers.remove(observer);
    }

    public void admitPatient(String patientName,
                             double temperatureC,
                             int age) {

        int riskScore =
                strategy.calculateRisk(temperatureC, age);

        System.out.println("[" + hospitalName + "] Admitting: "
                + patientName);

        System.out.println("Calculated Risk Score: "
                + riskScore);

        for (AdmissionObserver observer : observers) {

            observer.onPatientAdmitted(patientName, riskScore);
        }
    }
}