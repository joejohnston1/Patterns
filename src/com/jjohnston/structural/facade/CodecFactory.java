package com.jjohnston.structural.facade;

/**
 * These are some of the classes of a complex 3rd-party video
 * conversion framework. We don't control that code, therefore
 * can't simplify it.
 */
public class CodecFactory {

    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}
