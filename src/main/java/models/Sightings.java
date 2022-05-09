package models;

public class Sightings {

    private int id;

    private String location;

    private String rangerName;

    public Sightings(String rangerName, String location){
        this.rangerName = rangerName;
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }
}
