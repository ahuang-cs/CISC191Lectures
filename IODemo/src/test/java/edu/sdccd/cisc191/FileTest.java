package edu.sdccd.cisc191;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    static final String LARGE_FILE_NAME = "kaggle_train.csv";
    Directory dir;

    @BeforeEach
    void setUp() {
        try {
            dir = new Directory("C:\\cisc191");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    void copyFromResourcesArrayBuffered() {
        try {
            File file = new File(dir.getPath() + "\\" + LARGE_FILE_NAME);
            file.copyFromResourcesArrayBuffered(LARGE_FILE_NAME);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    void copyFromResourcesNoBuffer() {
        try {
            File file = new File(dir.getPath() + "\\" + LARGE_FILE_NAME);
            file.copyFromResourcesNoBuffer(LARGE_FILE_NAME);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}