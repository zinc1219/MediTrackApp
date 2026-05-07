import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientAdmissionIntegrationTest {

    private PatientAdmission admission;

    @BeforeEach
    void setUp() {
        admission = new PatientAdmission();
    }

    @Test
    void fullAdmissionFlow_elderlyHighFever_urgentPriority() {

        int score1 = admission.calculateRiskScore(40.0, 72);

        assertAll(
                () -> assertEquals(80, score1),
                () -> assertEquals("URGENT",
                        admission.getAdmissionPriority(score1))
        );

        int score2 = admission.calculateRiskScore(38.0, 55);

        assertAll(
                () -> assertEquals(40, score2),
                () -> assertEquals("MODERATE",
                        admission.getAdmissionPriority(score2))
        );

        int score3 = admission.calculateRiskScore(36.5, 20);

        assertAll(
                () -> assertEquals(0, score3),
                () -> assertEquals("ROUTINE",
                        admission.getAdmissionPriority(score3))
        );

        int score4 = admission.calculateRiskScore(39.5, 30);

        assertAll(
                () -> assertEquals(50, score4),
                () -> assertEquals("MODERATE",
                        admission.getAdmissionPriority(score4))
        );

        int score5 = admission.calculateRiskScore(40.0, 65);

        assertAll(
                () -> assertEquals(80, score5),
                () -> assertEquals("URGENT",
                        admission.getAdmissionPriority(score5))
        );
    }
}
