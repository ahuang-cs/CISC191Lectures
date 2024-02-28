package edu.sdccd.cisc191;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directory {
    private File dir;

    public Directory(String path) throws IOException {
        setDir(path);
    }

    public void setDir(String path) throws IOException {
        dir = new File(path);
        if(!dir.isDirectory() && dir.exists()) {
            throw new IOException(path + " is not a directory!");
        }
    }

    public String getPath() {
        return dir.getAbsolutePath();
    }

    public boolean create() {
        return dir.mkdirs();
    }

    public boolean delete() {
        return dir.delete();
    }

    public Set<String> list() {
        return Stream.of(dir.listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}
