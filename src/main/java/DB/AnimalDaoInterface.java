package DB;
import models.Animal;

import java.util.List;

public interface AnimalDaoInterface {
    //CREATE
    void add();

    //FIND
    void findByID();

    //UPDATE
    void update();

    //LIST
    List<Animal> getAll();

    //DELETE
    void deleteById();
    void clearAllAnimals();



}
