import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientAdmissionV2Test {

    @Test
    public void testDifferentStrategiesProduceDifferentScores() {

        double temp = 38.7;
        int age = 62;

        PatientAdmissionV2 standard =
                new PatientAdmissionV2(new StandardRiskStrategy());

        PatientAdmissionV2 conservative =
                new PatientAdmissionV2(new ConservativeRiskStrategy());

        int standardScore =
                standard.calculateRiskScore(temp, age);

        int conservativeScore =
                conservative.calculateRiskScore(temp, age);

        assertNotEquals(standardScore, conservativeScore);
    }

    @Test
    public void testSetStrategyChangesAlgorithm() {

        PatientAdmissionV2 admission =
                new PatientAdmissionV2(new StandardRiskStrategy());

        int oldScore =
                admission.calculateRiskScore(38.7, 62);

        admission.setStrategy(new ConservativeRiskStrategy());

        int newScore =
                admission.calculateRiskScore(38.7, 62);

        assertNotEquals(oldScore, newScore);
    }

    @Test
    public void testPediatricRiskStrategy() {

        PatientAdmissionV2 admission =
                new PatientAdmissionV2(new PediatricRiskStrategy());

        int score =
                admission.calculateRiskScore(38.5, 10);

        assertEquals(60, score);
    }
}