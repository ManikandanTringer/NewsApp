package com.example.news.modeldata;

public class HeadlineModelData {
    private boolean video;
    private String textHeadnews;
    private String secondText;

    public HeadlineModelData(boolean video, String textHeadnews, String secondText) {
        this.video = video;
        this.textHeadnews = textHeadnews;
        this.secondText = secondText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }

//
//    public HeadlineModelData(boolean video, String textHeadnews) {
//        this.video = video;
//        this.textHeadnews = textHeadnews;
//    }

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
