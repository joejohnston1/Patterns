package com.jjohnston.structural.decorator;

public class Main {

    /**
     * Pros
     *  - You can extend an object’s behavior without making a new subclass.
     *  - You can add or remove responsibilities from an object at runtime.
     *  - You can combine several behaviors by wrapping an object into multiple decorators.
     *  - Single Responsibility Principle. You can divide a monolithic class that implements
     *  many possible variants of behavior into several smaller classes.
     *
     *  Cons
     *  - It’s hard to remove a specific wrapper from the wrappers stack.
     *  - It’s hard to implement a decorator in such a way that its behavior doesn’t depend on
     *  the order in the decorators stack.
     *  - The initial configuration code of layers might look pretty ugly.
     *
     * @param args
     */
    public static void main(String[] args) {

        decoratorAssemblyOption1();
    }

    private static void decoratorAssemblyOption1() {
        var data = "The quick brown fox jumped over the laxy dog";

        // Option 1. A simple example of a decorator assembly.

        var source = new FileDataSource("somefile.dat");

        // The target file has been written with plain data.
        source.writeData(data);

        // Write the target file with compressed data
        var compressionDecorator = new CompressionDecorator(source);
        compressionDecorator.writeData(data);

        // write the target file with compressed and encrypted data
        // The source variable now contains this:
        // Encryption > Compression > FileDataSource
        var encryptionDecorator = new EncryptionDecorator(compressionDecorator);
        encryptionDecorator.writeData(data);
    }
}
