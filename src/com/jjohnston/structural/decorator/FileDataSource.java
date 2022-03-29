package com.jjohnston.structural.decorator;

/**
 * Concrete components provide default implementations for the
 * operations. There might be several variations of these
 * classes in a program.
 */
public class FileDataSource implements DataSource {

    private String fileName;

    private String data;

    public FileDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(String data) {
        System.out.println(data);
        this.data = data;
    }

    @Override
    public String readData() {
        return data;
    }
}
