package com.jjohnston.structural.proxy;

public class Video {

    private String id;
    private String title;
    private String rating;

    public Video(String id, String title, String rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }
}
