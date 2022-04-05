package com.jjohnston.structural.facade;

/**
 * These are some of the classes of a complex 3rd-party video
 * conversion framework. We don't control that code, therefore
 * can't simplify it.
 */
public class BitrateReader {

    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}
