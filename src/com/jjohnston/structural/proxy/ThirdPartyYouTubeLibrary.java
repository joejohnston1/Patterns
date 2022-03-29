package com.jjohnston.structural.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The concrete implementation of a service connector. Methods
 * of this class can request information from YouTube. The speed
 * of the request depends on a user's internet connection as
 * well as YouTube's. The application will slow down if a lot of
 * requests are fired at the same time, even if they all request
 * the same information.
 */
public class ThirdPartyYouTubeLibrary implements YouTubeLibrary {

    private List<Video> library = new ArrayList<>();

    public ThirdPartyYouTubeLibrary() {

        var video1 = new Video("1", "Terminator", "18");
        var video2 = new Video("2", "The Green Mile", "15");
        var video3 = new Video("3", "Anchorman", "15");

        library = List.of(video1, video2, video3);
    }

    @Override
    public List<String> listVideos() {
        System.out.println("ThirdPartyYouTubeLibrary - listVideos");

        var titles = library.stream()
                .map(x -> x.getTitle())
                .collect(Collectors.toList());

        return titles;
    }

    @Override
    public String getVideoInfo(String id) {
        System.out.println("ThirdPartyYouTubeLibrary - getVideoInfo: " + id);
        return library.stream().filter(x -> x.getId().equals(id)).findFirst().get().getTitle();
    }

    @Override
    public Video downloadVideo(String id) {
        System.out.println("ThirdPartyYouTubeLibrary - downloadVideo: " + id);
        return library.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }
}
