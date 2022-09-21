package com.example.news;

public class HeadlineModelData {
    private boolean video;
    private String textHeadnews;

    public HeadlineModelData(boolean video, String textHeadnews) {
        this.video = video;
        this.textHeadnews = textHeadnews;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTextHeadnews() {
        return textHeadnews;
    }

    public void setTextHeadnews(String textHeadnews) {
        this.textHeadnews = textHeadnews;
    }
}
