package com.jjohnston.structural.facade;

import java.io.File;

public class Main {

    /**
     * Application classes don't depend on a billion classes
     * provided by the complex framework. Also, if you decide to
     * switch frameworks, you only need to rewrite the facade class.
     *
     * @param args
     */
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
