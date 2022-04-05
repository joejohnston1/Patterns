package com.jjohnston.structural.facade;

import java.io.File;

/**
 * These are some of the classes of a complex 3rd-party video
 * conversion framework. We don't control that code, therefore
 * can't simplify it.
 */
public class AudioMixer {

    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
