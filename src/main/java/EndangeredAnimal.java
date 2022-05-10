import java.util.Objects;

public class EndangeredAnimal{
    private int id;

    private String name;

    private String danger;
    private String health;
    private String age;

    private String location;

    private String ranger;

    public EndangeredAnimal(String name, String danger, String health, String age, String location, String ranger) {
        this.name= name;
        this.danger= danger;
        this.health = health;
        this.age = age;
        this.location= location;
        this.ranger= ranger;
    }

    public String getName() {
        return name;
    }

    public String getDanger() {
        return danger;
    }

    public String getHealth() {
        return health;
    }

    public int getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getRanger() {
        return ranger;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) o;
            return this.getName().equals(newEndangeredAnimal.getName()) &&
                    this.getId() == newEndangeredAnimal.getId();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
