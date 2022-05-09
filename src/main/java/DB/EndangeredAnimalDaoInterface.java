package DB;

import models.Animal;

import java.util.List;

public interface EndangeredAnimalDaoInterface {
    //CREATE
    void add();

    //FIND
    void findByID(int id);

    //UPDATE
    void update();

    //LIST
    List<Animal> getAll();

    //DELETE
    void deleteById();
    void clearAllAnimals();
}
