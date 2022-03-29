package com.jjohnston.structural.proxy;

import java.util.List;

public interface YouTubeLibrary {

    List<String> listVideos();

    String getVideoInfo(String id);

    Video downloadVideo(String id);
}
