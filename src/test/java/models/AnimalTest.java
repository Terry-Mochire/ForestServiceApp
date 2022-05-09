package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class AnimalTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    public Animal setUpNewAnimal(){
        return new Animal("Tiger", 1);
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
        assertEquals(1, testAnimal.getId());
    }
}