package DB;

import models.Animal;
import models.Ranger;

import java.util.List;

public interface RangerInterface {
    //CREATE
    void add();

    //FIND
    void findByID(int id);

    //UPDATE
    void update();

    //LIST
    List<Ranger> getAll();

    //DELETE
    void deleteById();
    void clearAllAnimals();
}
