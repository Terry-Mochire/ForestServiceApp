package models;

public class Animal {
    private int id;
    private String name;

    public Animal (String name, int id){
        this.name= name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
