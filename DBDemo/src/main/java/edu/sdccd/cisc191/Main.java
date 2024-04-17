package edu.sdccd.cisc191;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DB db = new DB();
            db.createTables();

            Student student = new Student("John Doe");
            db.create(student);

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
