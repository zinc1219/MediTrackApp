package Week5;
import java.time.LocalDate;

public class Visit {
    private LocalDate  date;
    private String     diagnosis    = "Pending";
    private String     prescription = "None";
    private VitalSigns vitals;
    private Doctor     attendingDoctor;

    public Visit(LocalDate date, Doctor doctor, VitalSigns vitals) {
        this.date = date; this.attendingDoctor = doctor; this.vitals = vitals;
    }
    public void addDiagnosis(String d)    { this.diagnosis    = d; }
    public void addPrescription(String p) { this.prescription = p; }
    @Override public String toString() {
        return "Visit[" + date + " Dr." + attendingDoctor.getName()
                + " " + diagnosis + " Vitals:" + vitals + "]";
    }
}

