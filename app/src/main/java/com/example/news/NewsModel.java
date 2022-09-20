package com.example.news;

public class NewsModel {
    private String text;
    private int imgId;
    private boolean video;
    private int type;

    public static final int TYPE_HEADLINE_CENTRIC=0;
    public static final int TYPE_PHOTO_CENTRIC=1;
    public static final int TYPE_LIST_CENTRIC=2;

    public NewsModel(String text, int imgId, boolean video, int type) {
        this.text = text;
        this.imgId = imgId;
        this.video = video;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
