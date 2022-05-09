package models;

public class EndangeredAnimals extends Animals{

    private String health;
    private String age;

    public EndangeredAnimals(String name, int id, String health, String age) {
        super(name, id);
        this.health = health;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }
}
