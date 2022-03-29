package com.jjohnston.structural.decorator;

/**
 * Concrete decorators must call methods on the wrapped object,
 * but may add something of their own to the result. Decorators
 * can execute the added behavior either before or after the
 * call to a wrapped object.
 */
public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {

        System.out.printf("Compressed Data - ");

        super.writeData(data);
    }

    @Override
    public String readData() {

        var data = super.readData();

        System.out.println("Decompress data: " + data);

        data += " I have been decompressed";

        return data;
    }
}
