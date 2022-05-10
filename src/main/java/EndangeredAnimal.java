import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class EndangeredAnimal implements DatabaseManagement{
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
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, danger, health, age, location, ranger) VALUES (:name, :danger, :health, :age, :location, :ranger)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("danger", this.danger)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .addParameter("ranger", this.ranger)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql =  "SELECT * FROM animals WHERE id= :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }


    public static List<EndangeredAnimal> all() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals";
            return con.createQuery(sql)
                    .executeAndFetch(EndangeredAnimal.class);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static void clearAll() {
        String sql = "DELETE from animals *";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    public List<Sightings> getSightings() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animalId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sightings.class);
        }
    }
}
