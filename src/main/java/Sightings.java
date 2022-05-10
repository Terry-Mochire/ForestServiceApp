

public class Sightings {


    private String location;

    private String rangerName;

    private int animalId;

    private String animalName;

    public Sightings(String rangerName, String location, int animalId, String animalName){
        this.rangerName = rangerName;
        this.location = location;
        this.animalId = animalId;
        this.animalName = animalName;
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
