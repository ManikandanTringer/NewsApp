package com.example.news;

public class ListModelData {
    private int imgId;
    private String textListnews;

    public ListModelData(int imgId, String textListnews) {
        this.imgId = imgId;
        this.textListnews = textListnews;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }



    public String getTextListnews() {
        return textListnews;
    }

    public void setTextListnews(String textListnews) {
        this.textListnews = textListnews;
    }
}
