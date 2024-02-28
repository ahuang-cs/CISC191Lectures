package edu.sdccd.cisc191;

import java.io.*;

public class File {
    private static final int BUFFER_SIZE = 1024;
    private java.io.File file;

    public File(String path) throws IOException {
        setFile(path);
    }

    private void setFile(String path) throws IOException {
        file = new java.io.File(path);
        if(!file.isFile() && file.exists()) {
            throw new IOException(path + " is not a file!");
        }
    }

    public String getPath() {
        return file.getAbsolutePath();
    }

    public boolean delete() {
        return file.delete();
    }

    public void copyFromResourcesArrayBuffered(String resourcesPath) throws IOException {
        InputStream is;
        OutputStream os;
        is = File.class.getClassLoader().getResourceAsStream(resourcesPath);
        os = new FileOutputStream(file);
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        while((bytesRead = is.read(buffer)) > 0) {
            os.write(buffer, 0, bytesRead);
        }
        is.close();
        os.close();
    }

    public void copyFromResourcesNoBuffer(String resourcesPath) throws IOException {
        InputStream is;
        OutputStream os;
        is = File.class.getClassLoader().getResourceAsStream(resourcesPath);
        os = new FileOutputStream(file);

        int byteRead;
        while((byteRead = is.read()) != -1) {
            os.write(byteRead);
        }
        is.close();
        os.close();

    }
}
