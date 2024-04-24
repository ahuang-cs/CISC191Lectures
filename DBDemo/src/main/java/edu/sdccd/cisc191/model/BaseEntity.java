package edu.sdccd.cisc191.model;

public class BaseEntity {
    private int id;
    private String name;

    public BaseEntity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public BaseEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "\t" + name;
    }
}
