package Week5;

import java.time.LocalDate;

public class Challenge_RepositoryDemo {

    public static void main(String[] args) {

        InMemoryPatientRepository repo =
                new InMemoryPatientRepository();

        Patient p =
                new Patient(
                        "Maria Santos",
                        LocalDate.of(
                                1979,
                                3,
                                15
                        ),
                        "O+"
                );

        repo.save(p);

        System.out.println(
                "Patient ID: "
                        + p.getPatientId()
        );

        System.out.println(
                "Find By ID: "
                        + repo.findById(
                        p.getPatientId()
                )
        );

        System.out.println(
                "Find By Blood Type: "
                        + repo.findByBloodType(
                        "O+"
                )
        );
    }
}