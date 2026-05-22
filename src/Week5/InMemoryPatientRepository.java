package Week5;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPatientRepository
        implements PatientRepository {

    private Map<String, Patient> store =
            new HashMap<>();

    @Override
    public void save(Patient patient) {

        store.put(
                patient.getPatientId(),
                patient
        );
    }

    @Override
    public Patient findById(String patientId) {

        return store.get(patientId);
    }

    @Override
    public List<Patient> findAll() {

        return new ArrayList<>(
                store.values()
        );
    }

    @Override
    public List<Patient> findByBloodType(
            String bloodType) {

        List<Patient> result =
                new ArrayList<>();

        for (Patient patient
                : store.values()) {

            if (patient.getBloodType()
                    .equalsIgnoreCase(
                            bloodType)) {

                result.add(patient);
            }
        }

        return result;
    }
}