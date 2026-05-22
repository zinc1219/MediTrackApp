package Week5;
public class Doctor extends StaffMember {
    private String specialisation;
    public Doctor(String name, String id, String specialisation) {
        super(name, id); this.specialisation = specialisation;
    }
    @Override public String getRole() { return "Doctor (" + specialisation + ")"; }
}
