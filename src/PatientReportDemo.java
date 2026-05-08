public class PatientReportDemo {

    public static void main(String[] args) {

        PatientReportFormatter formatter = new PatientReportFormatter();
        ReportFileSaver saver = new ReportFileSaver();
        AuditLogger logger = new AuditLogger();

        Notifier notifier = new EmailNotifier();

        String report = formatter.format("Maria Santos", 80);

        saver.save(report, "report_001.txt");
        notifier.send(report, "doctor@meditrack.com");

        notifier = new SmsNotifier();
        notifier.send(report, "0123456789");

        logger.log("Report generated for Maria Santos");
    }
}