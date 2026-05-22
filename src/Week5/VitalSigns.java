package Week5;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VitalSigns {
    private double temperatureC;
    private String bloodPressure;  // e.g. "120/80"
    private int    pulseRate;

    public VitalSigns(double temp, String bp, int pulse) {
        this.temperatureC = temp;
        this.bloodPressure = bp;
        this.pulseRate = pulse;
    }
    public double getTemperatureC()  { return temperatureC; }
    public String getBloodPressure() { return bloodPressure; }
    public int    getPulseRate()     { return pulseRate; }

    @Override public String toString() {
        return "Temp:" + temperatureC + " BP:" + bloodPressure + " Pulse:" + pulseRate;
    }
}
