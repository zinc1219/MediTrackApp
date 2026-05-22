package Week5;

import java.time.LocalDateTime;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private AppointmentStatus status;

    public Appointment(Patient patient,
                       Doctor doctor,
                       LocalDateTime dateTime) {

        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public void book() {
        status = AppointmentStatus.SCHEDULED;
    }

    public void cancel() {
        status = AppointmentStatus.CANCELLED;
    }

    public void complete() {
        status = AppointmentStatus.COMPLETED;
    }

    public AppointmentStatus getStatus() {
        return status;
    }
}