package edu.sdccd.cisc191.model;

public class Student extends BaseEntity{
    public Student(String name, int id) {
        super(name, id);
    }

    public Student(String name) {
        super(name);
    }
}
