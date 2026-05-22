package Week5;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PatientRepositoryTest {

    @Test
    void testSaveAndFindById() {

        InMemoryPatientRepository repo =
                new InMemoryPatientRepository();

        Patient patient =
                new Patient(
                        "Ali",
                        LocalDate.of(
                                2000,
                                1,
                                1
                        ),
                        "A+"
                );

        repo.save(patient);

        Patient found =
                repo.findById(
                        patient.getPatientId()
                );

        assertEquals(
                patient,
                found
        );
    }

    @Test
    void testFindByBloodType() {

        InMemoryPatientRepository repo =
                new InMemoryPatientRepository();

        Patient patient =
                new Patient(
                        "Siti",
                        LocalDate.of(
                                1999,
                                5,
                                5
                        ),
                        "O+"
                );

        repo.save(patient);

        assertEquals(
                1,
                repo.findByBloodType(
                        "O+"
                ).size()
        );
    }

    @Test
    void testFindAll() {

        InMemoryPatientRepository repo =
                new InMemoryPatientRepository();

        Patient p1 =
                new Patient(
                        "John",
                        LocalDate.now(),
                        "A+"
                );

        Patient p2 =
                new Patient(
                        "Mary",
                        LocalDate.now(),
                        "B+"
                );

        repo.save(p1);
        repo.save(p2);

        assertEquals(
                2,
                repo.findAll().size()
        );
    }
}