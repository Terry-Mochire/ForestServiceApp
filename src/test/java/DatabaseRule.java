

import org.junit.rules.ExternalResource;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

public class DatabaseRule extends ExternalResource {

    @Override
    public void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "", "");  //Those with linux or windows use two strings for username and password
    }

    @Override
    public void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }

}
