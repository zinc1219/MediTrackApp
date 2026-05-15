import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientV2Test {

    @Test
    public void needsAlert_elderlyAlertConfig_alertsAtLowerThreshold() {

        PatientV2 p = new PatientV2(
                "Ahmad",
                72,
                38.1,
                new ElderlyAlert(),
                new StandardProtocol());

        assertTrue(p.needsAlert());
    }

    @Test
    public void upgradeAlertConfig_newConfigApplied_thresholdChanges() {

        PatientV2 p = new PatientV2(
                "Ahmad",
                72,
                38.2,
                new ElderlyAlert(),
                new StandardProtocol());

        p.upgradeAlertConfig(new StandardAlert());

        assertFalse(p.needsAlert());
    }
}