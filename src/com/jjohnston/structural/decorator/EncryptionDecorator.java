package com.jjohnston.structural.decorator;

/**
 * Concrete decorators must call methods on the wrapped object,
 * but may add something of their own to the result. Decorators
 * can execute the added behavior either before or after the
 * call to a wrapped object.
 */
public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {

        System.out.printf("Encrypting Data - ");

        super.writeData(data);
    }

    @Override
    public String readData() {

        var data = super.readData();

        System.out.println("Decrypting data: " + data);

        data += " I have been decrpyted";

        return data;
    }
}
