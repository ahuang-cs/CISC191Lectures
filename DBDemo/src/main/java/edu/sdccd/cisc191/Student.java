package edu.sdccd.cisc191;

public class Student {
    private int id;
    private String name;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name) {
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
