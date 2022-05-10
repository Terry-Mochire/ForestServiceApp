

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SightingsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    public Sightings setUpNewSightings(){
        return new Sightings(1, "Near the River", "Brad");
    }

    @Test
    void newSightingsObjectGetsCorrectlyCreated_true(){
        Sightings testSighting = setUpNewSightings();
        assertEquals(true, testSighting instanceof Sightings);
    }
    @Test
    void getRangerName_CorrectlyReturnsRangerName_true() {
        Sightings testSighting = setUpNewSightings();
        assertEquals("Brad", testSighting.getRangerName());
    }

    @Test
    void getLocation_CorrectlyReturnsLocation_true() {
        Sightings testSighting = setUpNewSightings();
        assertEquals("Near the River", testSighting.getLocation());
    }

    @Test
    void getAnimalId_CorrectlyReturnsAnimalId_true() {
        Sightings testSighting = setUpNewSightings();
        assertEquals(1, testSighting.getAnimal_id());
    }

    @Test
    void equals_returnsTrueIfNameAnimalIDAndRangerAreEqual(){
        Sightings testSighting = setUpNewSightings();
        Sightings testSighting2 = setUpNewSightings();
        assertTrue(testSighting.equals(testSighting2));
    }

    @Test
    void save_CorrectlyInsertsObjectsIntoDatabase(){
        Sightings testSighting = setUpNewSightings();
        testSighting.save();
        assertTrue(Sightings.all().get(0).equals(testSighting));
    }

    @Test
    public void save_saveEndangeredIdIntoDatabase_true() {
        Animal becky = new Animal("Becky");
        becky.save();
        Sightings nairobi = new Sightings(becky.getId(), "Zone A", "Becky");
        nairobi.save();
        assertEquals(nairobi.getAnimal_id(), becky.getId());
    }

    @Test
    public void save_recordsTimeOfSightingInDataBase() {
        Sightings testSighting = new Sightings(1, "Nairobi", "Becky");
        testSighting.save();
        Timestamp savedSighting = Sightings.find(testSighting.getId()).getLastSighting();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedSighting));
    }

}