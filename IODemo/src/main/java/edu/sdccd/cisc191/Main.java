package edu.sdccd.cisc191;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static final String ROOT_DIRECTORY = "C:\\cisc191";
    public static void main(String[] args) {
        try {
            Directory dir = new Directory(ROOT_DIRECTORY);
            System.out.println(dir.getPath());
            dir.create();
            for(String fileName: dir.list()) {
                System.out.println(fileName);
            }
        } catch (IOException e) {
            printErrorMessageAndExit(e.getMessage());
        }


    }

    public static void printErrorMessageAndExit(String message) {
        System.err.println(message);
        System.exit(1);
    }
}
