

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

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
    void newRangerInstantiatesCorrectly_true(){
        Ranger testRanger = setUpNewRanger();
        assertEquals(true, testRanger instanceof Ranger);
    }

    @Test
    void getRangerName_CorrectlyReturnsRangerName_true() throws Exception {
        Ranger testRanger = setUpNewRanger();
        assertEquals("Brad", testRanger.getRangerName());
    }

    @Test
    void getBadgeNumber_correctlyReturnsBadgeNumber_true() throws Exception {
        Ranger testRanger = setUpNewRanger();
        assertEquals(12345, testRanger.getBadgeNumber());
    }

    @Test
    void getId() {
    }
}