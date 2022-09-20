package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter {
    private ArrayList<NewsModel> dataSet;
    Context nContext;
    int total_types;

    public NewsAdapter(ArrayList<NewsModel> list, MainActivity mainActivity) {
        nContext=mainActivity;
        dataSet=list;
        total_types=dataSet.size();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case NewsModel.TYPE_HEADLINE_CENTRIC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_headline_news, parent, false);
                return new HeadlineCentricViewHolder(view);
            case NewsModel.TYPE_LIST_CENTRIC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_news, parent, false);
                return new ListCentricViewHolder(view);
            case NewsModel.TYPE_PHOTO_CENTRIC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_news, parent, false);
                return new PhotoCentricViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        NewsModel newsModel=dataSet.get(position);
        if(newsModel!=null){
            switch (newsModel.getType()) {
                case NewsModel.TYPE_HEADLINE_CENTRIC:
                    ((HeadlineCentricViewHolder) holder).headtextTV.setText(newsModel.getText());
                    ((HeadlineCentricViewHolder)holder).healineIV.setImageResource(newsModel.getImgId());
                    if(newsModel.isVideo()){
                        ((HeadlineCentricViewHolder)holder).headline_video_indicator.setVisibility(View.VISIBLE);
                    }else{
                        ((HeadlineCentricViewHolder)holder).headline_video_indicator.setVisibility(View.INVISIBLE);

                    }

                    break;
                case NewsModel.TYPE_PHOTO_CENTRIC:
                    ((PhotoCentricViewHolder) holder).phototextTV.setText(newsModel.getText());
                    ((PhotoCentricViewHolder) holder).photoIV.setImageResource(newsModel.getImgId());
                    if(newsModel.isVideo()){
                        ((PhotoCentricViewHolder)holder).photo_video_indicator.setVisibility(View.VISIBLE);
                    }else{
                        ((PhotoCentricViewHolder)holder).photo_video_indicator.setVisibility(View.INVISIBLE);

                    }

                    break;
                case NewsModel.TYPE_LIST_CENTRIC:

                    ((ListCentricViewHolder) holder).listTV.setText(newsModel.getText());
                    ((ListCentricViewHolder) holder).listimg.setImageResource(newsModel.getImgId());
                    if(newsModel.isVideo()){
                        ((ListCentricViewHolder)holder).list_video_indicator.setVisibility(View.VISIBLE);
                    }else{
                        ((ListCentricViewHolder)holder).list_video_indicator.setVisibility(View.INVISIBLE);

                    }
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).getType()) {
            case 0:
                return NewsModel.TYPE_HEADLINE_CENTRIC;
            case 1:
                return NewsModel.TYPE_PHOTO_CENTRIC;
            case 2:
                return NewsModel.TYPE_LIST_CENTRIC;
            default:
                return -1;
        }
    }

    class HeadlineCentricViewHolder extends RecyclerView.ViewHolder{
            TextView headtextTV;
            ImageView healineIV;
            RecyclerView headlineRV;
            LinearLayout headline_video_indicator;
        public HeadlineCentricViewHolder(@NonNull View itemView) {
            super(itemView);
                headtextTV=itemView.findViewById(R.id.headtextTV);
                headline_video_indicator=itemView.findViewById(R.id.headline_video_indicator);
                headlineRV=itemView.findViewById(R.id.headlineRV);
                healineIV=itemView.findViewById(R.id.healineIV);
        }
    }
    class PhotoCentricViewHolder extends RecyclerView.ViewHolder{
        TextView phototextTV;
        ImageView photoIV;
        RecyclerView photoRV;
        LinearLayout photo_video_indicator;
        public PhotoCentricViewHolder(@NonNull View itemView) {
            super(itemView);
            phototextTV=itemView.findViewById(R.id.phototextTV);
            photo_video_indicator=itemView.findViewById(R.id.photo_video_indicator);
            photoRV=itemView.findViewById(R.id.photoRV);
            photoIV=itemView.findViewById(R.id.photoIV);

        }
    }
    class ListCentricViewHolder extends RecyclerView.ViewHolder{
        TextView listTV;
        ImageView listimg;
        RecyclerView listRV;
        LinearLayout list_video_indicator;
        public ListCentricViewHolder(@NonNull View itemView) {
            super(itemView);
            listTV=itemView.findViewById(R.id.listTV);
            listimg=itemView.findViewById(R.id.listimg);
            listRV=itemView.findViewById(R.id.listRV);
            list_video_indicator=itemView.findViewById(R.id.list_video_indicator);

        }
    }
}
