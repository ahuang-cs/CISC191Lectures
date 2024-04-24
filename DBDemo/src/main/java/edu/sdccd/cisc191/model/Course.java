package edu.sdccd.cisc191.model;

public class Course extends BaseEntity{
    public Course(String name, int id) {
        super(name, id);
    }

    public Course(String name) {
        super(name);
    }
}
