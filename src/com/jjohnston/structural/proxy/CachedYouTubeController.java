package com.jjohnston.structural.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * To save some bandwidth, we can cache request results and keep
 * them for some time. But it may be impossible to put such code
 * directly into the service class. For example, it could have
 * been provided as part of a third party library and/or defined
 * as `final`. That's why we put the caching code into a new
 * proxy class which implements the same interface as the
 * service class. It delegates to the service object only when
 * the real requests have to be sent.
 */
public class CachedYouTubeController implements  YouTubeLibrary {

    private YouTubeLibrary service;
    private List<String> listCache = new ArrayList<>();
    private Map<String, String> videoInfoCache = new HashMap<>();
    private Map<String, Video> videoCache = new HashMap<>();

    private boolean needReset;

    public CachedYouTubeController(YouTubeLibrary service) {
        this.service = service;
    }

    @Override
    public List<String> listVideos() {

        if (listCache.isEmpty()) {
            listCache = service.listVideos();
        }

        return listCache;
    }

    @Override
    public String getVideoInfo(String id) {

        if (!videoInfoCache.containsKey(id)) {
            videoInfoCache.put(id, service.getVideoInfo(id));
        }

        return videoInfoCache.get(id);
    }

    @Override
    public Video downloadVideo(String id) {

        if (!videoCache.containsKey(id)) {
            videoCache.put(id, service.downloadVideo(id));
        }

        return videoCache.get(id);
    }
}
