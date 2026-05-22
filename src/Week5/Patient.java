package Week5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String patientId;
    private String name;
    private LocalDate dob;
    private String bloodType;

    private List<Visit> visits =
            new ArrayList<>();

    public Patient(String name,
                   LocalDate dob,
                   String bloodType) {

        this.patientId =
                "P" + System.currentTimeMillis();

        this.name = name;
        this.dob = dob;
        this.bloodType = bloodType;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getVisitHistory() {
        return visits;
    }

    @Override
    public String toString() {
        return "Patient[" + name + "]";
    }
}