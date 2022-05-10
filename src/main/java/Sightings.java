import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import org.sql2o.Connection;

public class Sightings {

    private int id;
    private int animal_id;
    private String rangerName;
    private String location;

    private Timestamp lastSighting;


    public Sightings( int animal_id, String location,  String rangerName){
        this.rangerName = rangerName;
        this.location = location;
        this.animal_id = animal_id;
    }

    public String getRangerName() {
        return rangerName;
    }

    public String getLocation() {
        return location;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public int getId() {
        return id;
    }

    public Timestamp getLastSighting() {
        return lastSighting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return animal_id == sightings.animal_id &&
                Objects.equals(rangerName, sightings.rangerName) &&
                Objects.equals(location, sightings.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal_id, rangerName, location);
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animal_id, location, rangername, lastsighting) VALUES (:animal_id, :location, :rangerName, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> all() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings";
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);
        }
    }

    public static Sightings find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
        }
    }
}
