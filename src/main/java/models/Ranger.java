package models;

public class Ranger{

    private int id;
    private String rangerName;
    private int badgeNumber;

    public Ranger( String rangerName, int badgeNumber){
        this.rangerName = rangerName;
        this.badgeNumber = badgeNumber;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public int getId() {
        return id;
    }
}
