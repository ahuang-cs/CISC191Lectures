package edu.sdccd.cisc191;

import edu.sdccd.cisc191.model.BaseEntity;
import edu.sdccd.cisc191.model.Course;
import edu.sdccd.cisc191.model.Enrollment;
import edu.sdccd.cisc191.model.Student;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DB db = new DB();
            db.createTables();

            Student student = new Student("John Doe");
            db.create(student, Student.class);

            Course course = new Course("CISC191 Intermediate Java Programming");
            db.create(course, Course.class);

            Enrollment enrollment = new Enrollment(course, student);
            db.create(enrollment);
            System.out.println(enrollment);


            while(true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
