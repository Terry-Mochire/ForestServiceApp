

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class AnimalTest {

    @Rule
    public DB.DatabaseRule database = new DB.DatabaseRule();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    public Animal setUpNewAnimal(){
        return new Animal("Tiger");
    }

    @Test
    public void newAnimalObjectGetsCorrectlyCreated_true(){
        Animal testAnimal = setUpNewAnimal();
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    void newAnimalInstantiatesWithName_true() throws Exception {
        Animal testAnimal = setUpNewAnimal();
        assertEquals("Tiger", testAnimal.getName());
    }

    @Test
    void newAnimalInstantiatesWithId_true() throws Exception {
        Animal testAnimal = setUpNewAnimal();
        assertEquals(0, testAnimal.getId());
    }

    @Test
    public void equals_returnsTrueIfNameAndIdAreEqual() {
        Animal rex = new Animal("Rex");
        Animal alpha= new Animal("Rex");
        assertTrue(rex.equals(alpha));
    }
}