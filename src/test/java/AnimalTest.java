

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        Animal.clearAll();
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

    @Test
    void save_insertsObjectsIntoDatabase(){
        Animal testAnimal = setUpNewAnimal();
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true(){
        Animal testAnimal = setUpNewAnimal();
        Animal testAnimal2 = new Animal("Rex");
        Animal testAnimal3 = new Animal("Lion");
        testAnimal.save();
        testAnimal2.save();
        testAnimal3.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
        assertTrue(Animal.all().get(1).equals(testAnimal2));
        assertTrue(Animal.all().get(2).equals(testAnimal3));
    }

    @Test
    void find_returnsAnimalWithSameId_secondAnimal(){
        Animal testAnimal = setUpNewAnimal();
        Animal testAnimal2 = new Animal("Rex");
        testAnimal.save();
        testAnimal2.save();
        assertEquals(Animal.find(testAnimal2.getId()), testAnimal2);
    }


}