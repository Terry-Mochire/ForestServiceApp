package models;

public class EndangeredAnimal extends Animal{

    private String health;
    private String age;

    public EndangeredAnimal(String name, int id, String health, String age) {
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
