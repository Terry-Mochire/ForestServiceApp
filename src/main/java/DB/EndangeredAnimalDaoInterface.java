package DB;

import models.Animal;
import models.EndangeredAnimal;

import java.util.List;

public interface EndangeredAnimalDaoInterface {
    //CREATE
    void add();

    //FIND
    void findByID(int id);

    //UPDATE
    void update();

    //LIST
    List<EndangeredAnimal> getAll();

    //DELETE
    void deleteById();
    void clearAllAnimals();
}
