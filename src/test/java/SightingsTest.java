

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SightingsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    public Sightings setUpNewSightings(){
        return new Sightings("Brad", "Near the River", 1, "Lion");
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
        assertEquals(1, testSighting.getAnimalId());
    }
}