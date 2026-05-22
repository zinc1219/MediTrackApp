package Week5;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DomainModelDemo {
    public static void main(String[] args) {
        Doctor dr = new Doctor("Dr. Lim", "D001", "Cardiology");
        Patient p  = new Patient("Maria Santos", LocalDate.of(1979, 3, 15), "O+");

        VitalSigns vitals = new VitalSigns(38.9, "130/85", 92);
        Visit v = new Visit(LocalDate.now(), dr, vitals);
        v.addDiagnosis("Mild hypertension");
        v.addPrescription("Amlodipine 5mg once daily");

        p.addVisit(v);

        System.out.println(p);
        for (Visit visit : p.getVisitHistory()) {
            System.out.println("  " + visit);
        }

        Appointment appt =
                new Appointment(
                        p,
                        dr,
                        LocalDateTime.now()
                );

        appt.book();

        System.out.println(
                "Appointment Status: "
                        + appt.getStatus()
        );

        appt.complete();

        System.out.println(
                "Appointment Status: "
                        + appt.getStatus()
        );
    }
}
