package Week5;
public abstract class StaffMember {
    protected String name;
    protected String staffId;
    public StaffMember(String name, String staffId) {
        this.name = name; this.staffId = staffId;
    }
    public String getName()  { return name; }
    public abstract String getRole();
}
