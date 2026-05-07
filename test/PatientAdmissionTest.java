import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PatientAdmissionTest {

    private PatientAdmission admission;

    @BeforeEach
    void setUp() {
        admission = new PatientAdmission();
    }

    // --- calculateRiskScore tests ---

    @Test
    void calculateRiskScore_highTempElderlyPatient_returnsHighScore() {
        int score = admission.calculateRiskScore(40.0, 70);
        assertEquals(80, score);
    }

    @Test
    void calculateRiskScore_normalTempYoungPatient_returnsZero() {
        int score = admission.calculateRiskScore(36.5, 25);
        assertEquals(0, score);
    }

    @Test
    void calculateRiskScore_elevatedTempMiddleAge_returnsMediumScore() {
        int score = admission.calculateRiskScore(38.0, 55);
        assertEquals(40, score);
    }

    // --- getAdmissionPriority tests ---

    @Test
    void getAdmissionPriority_scoreAbove70_returnsUrgent() {
        assertEquals("URGENT", admission.getAdmissionPriority(80));
    }

    @Test
    void getAdmissionPriority_scoreBetween30And70_returnsModerate() {
        assertEquals("MODERATE", admission.getAdmissionPriority(40));
    }

    @Test

    void getAdmissionPriority_scoreBelow30_returnsRoutine() {
        assertEquals("ROUTINE", admission.getAdmissionPriority(10));
    }

    // --- isValidPatientName tests ---

    @Test
    void isValidPatientName_validName_returnsTrue() {
        assertTrue(admission.isValidPatientName("Maria Santos"));
    }

    @Test
    void isValidPatientName_nullName_returnsFalse() {
        assertFalse(admission.isValidPatientName(null));
    }

    @Test
    void isValidPatientName_emptyString_returnsFalse() {
        assertFalse(admission.isValidPatientName(""));
    }

    @Test
    void calculateRiskScore_tempExactly39Point5_returns50() {
        assertEquals(50,
                admission.calculateRiskScore(39.5, 30));
    }

    @Test
    void calculateRiskScore_ageExactly65_adds30() {
        assertEquals(30,
                admission.calculateRiskScore(36.5, 65));
    }

    @Test
    void isValidPatientName_100Characters_returnsTrue() {
        String name = "A".repeat(100);
        assertTrue(admission.isValidPatientName(name));
    }

    @Test
    void isValidPatientName_101Characters_returnsFalse() {
        String name = "A".repeat(101);
        assertFalse(admission.isValidPatientName(name));
    }

    @Test
    void isEligibleForPriorityCare_oldPatient_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(70, false));
    }

    @Test
    void isEligibleForPriorityCare_chronicCondition_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(30, true));
    }

    @Test
    void isEligibleForPriorityCare_youngHealthy_returnsFalse() {
        assertFalse(admission.isEligibleForPriorityCare(25, false));
    }

    @Test
    void isEligibleForPriorityCare_oldAndChronic_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(80, true));
    }

    @Test
    void calculateRiskScore_temperatureBelow30_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(20.0, 40);
        });
    }

    @Test
    void calculateRiskScore_temperatureAbove45_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(46.0, 40);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "40.0, 70, 80",  // high temp + elderly = 50 + 30
            "38.0, 55, 40",  // moderate temp + middle age = 25 + 15
            "36.5, 25,  0",  // normal temp + young = 0 + 0
            "39.5, 30, 50",  // boundary high temp + young = 50 + 0
    })
    void calculateRiskScore_variousInputs_returnsCorrectScore(
            double temp, int age, int expectedScore) {
        assertEquals(expectedScore, admission.calculateRiskScore(temp, age));
    }

    @Test
    void formatPatientReport_validData_returnsFormattedReport() {

        String report = admission.formatPatientReport(
                "Maria",
                80,
                "URGENT"
        );

        assertEquals(
                "Patient: Maria, Risk Score: 80, Priority: URGENT",
                report
        );
    }

    @Test
    void formatPatientReport_correctNameDisplayed() {

        String report = admission.formatPatientReport(
                "John",
                40,
                "MODERATE"
        );

        assertTrue(report.contains("John"));
    }

    @Test
    void formatPatientReport_correctRiskScoreDisplayed() {

        String report = admission.formatPatientReport(
                "Ali",
                50,
                "MODERATE"
        );

        assertTrue(report.contains("50"));
    }

    @Test
    void formatPatientReport_correctPriorityDisplayed() {

        String report = admission.formatPatientReport(
                "Siti",
                10,
                "ROUTINE"
        );

        assertTrue(report.contains("ROUTINE"));
    }

    @Test
    void formatPatientReport_nullName_returnsUnknown() {

        String report = admission.formatPatientReport(
                null,
                30,
                "MODERATE"
        );

        assertTrue(report.contains("Unknown"));
    }

    @Test
    void formatPatientReport_negativeRiskScore_returnsZero() {

        String report = admission.formatPatientReport(
                "Adam",
                -5,
                "ROUTINE"
        );

        assertTrue(report.contains("Risk Score: 0"));
    }

    @Test
    void formatPatientReport_unknownPriority_returnsUnknownPriority() {

        String report = admission.formatPatientReport(
                "Lisa",
                40,
                "CRITICAL"
        );

        assertTrue(report.contains("UNKNOWN"));
    }

}


