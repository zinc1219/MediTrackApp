package Week5;
import java.util.List;
public interface PatientRepository {
    void save(Patient patient);
    Patient findById(String patientId);
    List<Patient> findAll();
    List<Patient> findByBloodType(String bloodType);
}
