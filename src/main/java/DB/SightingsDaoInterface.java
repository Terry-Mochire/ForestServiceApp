package DB;

import models.Ranger;
import models.Sightings;

import java.util.List;

public interface SightingsDaoInterface {
    //CREATE
    void add();

    //FIND
    void findByID(int id);

    //UPDATE
    void update();

    //LIST
    List<Sightings> getAll();

    //DELETE
    void deleteById();
    void clearAllAnimals();
}
