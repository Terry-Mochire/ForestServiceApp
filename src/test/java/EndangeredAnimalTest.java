package models;

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
        return new  EndangeredAnimal("White Rhino", 1, "healthy", "adult");
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
        assertEquals("healthy", testEndangeredAnimal.getHealth());
    }

    @Test
    void newEndangeredAnimalInstantiatesWithCorrectAge_true(){
        EndangeredAnimal testEndangeredAnimal = setUpEndangeredAnimal();
        assertEquals("adult", testEndangeredAnimal.getAge());
    }

}