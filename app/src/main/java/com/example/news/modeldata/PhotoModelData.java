package com.example.news.modeldata;

public class PhotoModelData {
    private int imgID;
    private boolean video;
    private String text;

    public PhotoModelData(int imgID, boolean video, String text) {
        this.imgID = imgID;
        this.video = video;
        this.text = text;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
