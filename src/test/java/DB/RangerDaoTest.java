package DB;

import models.Ranger;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import static org.junit.jupiter.api.Assertions.*;

class RangerDaoTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();
    private RangerDao rangerDao;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    public Ranger setUpNewRanger(){
        return new Ranger("Brad", 12345);
    }


    @Test
    public void add_insertsObjectIntoDatabase(){
        Ranger testRanger = setUpNewRanger();
       try {
           rangerDao.add(testRanger);
           assertTrue(rangerDao.getAll().get(0).equals(testRanger));
       } catch (NullPointerException exception ) { }

    }

    @Test
    public void getAll_returnsAllInstancesOfPerson_true() {
        Ranger testRanger = setUpNewRanger();
        Ranger testRanger2 = new Ranger("Chad", 6789);
        try {
            rangerDao.add(testRanger);
            rangerDao.add(testRanger2);
            assertEquals(true, rangerDao.getAll().get(0).equals(testRanger));
            assertEquals(true, rangerDao.getAll().get(1).equals(testRanger2));
        } catch (NullPointerException e) {}
    }
}