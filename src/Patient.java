public abstract class Patient {

    protected String name;
    protected int age;
    protected double temperatureC;

    public Patient(String name, int age, double temperatureC) {
        this.name = name;
        this.age = age;
        this.temperatureC = temperatureC;
    }

    // Abstract method for alert threshold
    public abstract double getAlertTemperatureThreshold();

    // Intermediate requirement
    public abstract String getTreatmentProtocol();

    public boolean needsAlert() {
        return this.temperatureC >= getAlertTemperatureThreshold();
    }

    public void printSummary() {

        System.out.println("=== " + getPatientType() + " ===");

        System.out.println("Name: " + name);

        System.out.println("Age: " + age);

        System.out.println("Temperature: " + temperatureC);

        System.out.println("Alert Needed: " + needsAlert());

        // Intermediate output
        System.out.println("Treatment Protocol: "
                + getTreatmentProtocol());

        System.out.println();
    }

    public abstract String getPatientType();
}