package edu.sdccd.cisc191.model;

import java.sql.Time;

public class Enrollment {
    private Course course;
    private Student student;
    private Time date;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "course=" + course +
                ", student=" + student +
                ", date=" + date +
                '}';
    }

    public Enrollment(Course course, Student student, Time date) {
        this.course = course;
        this.student = student;
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Time getDate() {
        return date;
    }

    public void setDate(Time date) {
        this.date = date;
    }
}