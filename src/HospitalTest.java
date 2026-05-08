import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {

    @Test
    public void testRemoveObserver() {

        Hospital hospital = new Hospital("Test Hospital");

        TestObserver observer = new TestObserver();

        hospital.addObserver(observer);

        hospital.removeObserver(observer);

        hospital.admitPatient("Maria", 80);

        assertFalse(observer.wasCalled);
    }
}

class TestObserver implements AdmissionObserver {

    boolean wasCalled = false;

    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {
        wasCalled = true;
    }
}