package models;

public class Sightings {


    private String location;

    private String rangerName;

    private int animalId;

    public Sightings(String rangerName, String location, int animalId){
        this.rangerName = rangerName;
        this.location = location;
        this.animalId = animalId;
    }

    public String getRangerName() {
        return rangerName;
    }

    public String getLocation() {
        return location;
    }

    public int getAnimalId() {
        return animalId;
    }
}
