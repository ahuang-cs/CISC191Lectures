package edu.sdccd.cisc191;

public class Employee extends User {
    private String badgeId;
    private boolean isAdministrator;

    public Employee(long id, String name, String badgeId, boolean isAdministrator) {
        super(id, name);
        this.badgeId = badgeId;
        this.isAdministrator = isAdministrator;
    }

    public Employee() {
        super();
        badgeId = "";
        isAdministrator = false;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }
}
