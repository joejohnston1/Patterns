package com.jjohnston.structural.facade;

/**
 * These are some of the classes of a complex 3rd-party video
 * conversion framework. We don't control that code, therefore
 * can't simplify it.
 */
public class OggCompressionCodec implements Codec {
    public String type = "ogg";
}
