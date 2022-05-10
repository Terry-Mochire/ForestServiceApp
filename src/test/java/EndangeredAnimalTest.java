

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredAnimalTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        EndangeredAnimal.clearAll();
    }

    public EndangeredAnimal setUpEndangeredAnimal(){
        return new  EndangeredAnimal("White Rhino", "Endangered", "Healthy", "Young", "Near the river", "Brad" );
    }

    @Test
    void newEndangeredAnimalObjectGetsCorrectlyCreated_true(){
        EndangeredAnimal testEndangeredAnimal = setUpEndangeredAnimal();
        assertEquals(true, testEndangeredAnimal instanceof  EndangeredAnimal);
    }

    @Test
    void newEndangeredAnimalInstantiatesWithCorrectName_true(){
        EndangeredAnimal testEndangeredAnimal = setUpEndangeredAnimal();
        assertEquals("White Rhino", testEndangeredAnimal.getName());
    }

    @Test
    void newEndangeredAnimalInstantiatesWithCorrectHealth_true(){
        EndangeredAnimal testEndangeredAnimal = setUpEndangeredAnimal();
        assertEquals("Healthy", testEndangeredAnimal.getHealth());
    }

    @Test
    void newEndangeredAnimalInstantiatesWithCorrectAge_true(){
        EndangeredAnimal testEndangeredAnimal = setUpEndangeredAnimal();
        assertEquals("Young", testEndangeredAnimal.getAge());
    }

    @Test
    public void equals_returnsIfNameAndAnimalAreTheSame_true(){
        EndangeredAnimal testEndangeredAnimal = setUpEndangeredAnimal();
        EndangeredAnimal testEndangeredAnimal2 = setUpEndangeredAnimal();
        assertTrue(testEndangeredAnimal.equals(testEndangeredAnimal2));
    }


    @Test void save_correctlyStoresObjectIntoDatabase_true(){
        EndangeredAnimal testEndangeredAnimal = setUpEndangeredAnimal();
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal unsavedBecky = new EndangeredAnimal("Becky", "Endangered", "Healthy", "Young", "Nairobi", "Becky");
        unsavedBecky.save();
        EndangeredAnimal savedBecky = EndangeredAnimal.find(unsavedBecky.getId());
        assertEquals(savedBecky.getId(), unsavedBecky.getId());
    }

}