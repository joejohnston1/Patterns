package com.jjohnston.structural.proxy;

/**
 * The GUI class, which used to work directly with a service
 * object, stays unchanged as long as it works with the service
 * object through an interface. We can safely pass a proxy
 * object instead of a real service object since they both
 * implement the same interface.
 */
public class YouTubeManager {

    private YouTubeLibrary service;

    public YouTubeManager(YouTubeLibrary service) {
        this.service = service;
    }

    public void renderVideoPage(String id) {

        System.out.println("YouTubeManager.renderVideoPage: " + id);

        service.getVideoInfo(id);
    }

    public void renderListPanel() {

        System.out.println("YouTubeManager.renderListPanel");

        service.listVideos();
    }

    public void reactOnUserInput(String id) {
        renderVideoPage(id);
        renderListPanel();
    }


}
