

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

}