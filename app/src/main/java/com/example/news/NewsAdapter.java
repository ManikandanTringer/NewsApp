package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter {
    private ArrayList<NewsModel> dataSet;
    Context nContext;
    int total_types;
    ArrayList<HeadlineModelData> headList;

    public NewsAdapter(ArrayList<NewsModel> list, Context mainActivity) {
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
                    LinearLayoutManager layoutManager
                            = new LinearLayoutManager(
                            nContext,
                            LinearLayoutManager.VERTICAL,
                            false);
                    ((HeadlineCentricViewHolder) holder).headlineRV.setLayoutManager(new LinearLayoutManager(nContext));
                        HeadlineAdapter headlineAdapter=new HeadlineAdapter(getHeadline());
                        ((HeadlineCentricViewHolder) holder).headlineRV.setAdapter(headlineAdapter);
                        headlineAdapter.notifyDataSetChanged();

                    if(newsModel.isVideo()){
                        ((HeadlineCentricViewHolder)holder).headline_video_indicator.setVisibility(View.VISIBLE);

                    }else{
                        ((HeadlineCentricViewHolder)holder).headline_video_indicator.setVisibility(View.INVISIBLE);

                    }

                    break;
                case NewsModel.TYPE_PHOTO_CENTRIC:
                    ((PhotoCentricViewHolder) holder).phototextTV.setText(newsModel.getText());
                    ((PhotoCentricViewHolder) holder).photoIV.setImageResource(newsModel.getImgId());

                    ((PhotoCentricViewHolder) holder).photoRV.setLayoutManager(new GridLayoutManager(nContext,2));
                    PhotoAdapter photoAdapter=new PhotoAdapter(getPhoto());
                    ((PhotoCentricViewHolder) holder).photoRV.setAdapter(photoAdapter);
                    photoAdapter.notifyDataSetChanged();
                    if(newsModel.isVideo()){
                        ((PhotoCentricViewHolder)holder).photo_video_indicator.setVisibility(View.VISIBLE);
                    }else{
                        ((PhotoCentricViewHolder)holder).photo_video_indicator.setVisibility(View.INVISIBLE);

                    }

                    break;
                case NewsModel.TYPE_LIST_CENTRIC:

                    ((ListCentricViewHolder) holder).listTV.setText(newsModel.getText());
                    ((ListCentricViewHolder) holder).listimg.setImageResource(newsModel.getImgId());
                    ((ListCentricViewHolder) holder).listRV.setLayoutManager(new LinearLayoutManager(nContext));
                    ListAdapter listAdapter=new ListAdapter(getList());
                    ((ListCentricViewHolder) holder).listRV.setAdapter(listAdapter);
                    listAdapter.notifyDataSetChanged();
                    if(newsModel.isVideo()){
                        ((ListCentricViewHolder)holder).list_video_indicator.setVisibility(View.VISIBLE);
//                        ((ListCentricViewHolder) holder).list_video_indicator.setVisibility(0);
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
            ImageButton headline_video_indicator;
        public HeadlineCentricViewHolder(@NonNull View itemView) {
            super(itemView);
                headtextTV=itemView.findViewById(R.id.headtextTV);
                headline_video_indicator=itemView.findViewById(R.id.headImgBtn);
                headlineRV=itemView.findViewById(R.id.headlineRV);
                healineIV=itemView.findViewById(R.id.healineIV);
        }
    }
    class PhotoCentricViewHolder extends RecyclerView.ViewHolder{
        TextView phototextTV;
        ImageView photoIV;
        RecyclerView photoRV;
        ImageButton photo_video_indicator;
        public PhotoCentricViewHolder(@NonNull View itemView) {
            super(itemView);
            phototextTV=itemView.findViewById(R.id.phototextTV);
            photo_video_indicator=itemView.findViewById(R.id.photoImgBtn);
            photoRV=itemView.findViewById(R.id.photoRV);
            photoIV=itemView.findViewById(R.id.photoIV);

        }
    }
    class ListCentricViewHolder extends RecyclerView.ViewHolder{
        TextView listTV;
        ImageView listimg;
        RecyclerView listRV;
        ImageButton list_video_indicator;
        public ListCentricViewHolder(@NonNull View itemView) {
            super(itemView);
            listTV=itemView.findViewById(R.id.listTV);
            listimg=itemView.findViewById(R.id.listimg);
            listRV=itemView.findViewById(R.id.listRV);
            list_video_indicator=itemView.findViewById(R.id.listImgBtn);

        }
    }
    public ArrayList<HeadlineModelData> getHeadline(){
        headList=new ArrayList<>();
        headList.add(new HeadlineModelData(true,"dfg"));
        headList.add(new HeadlineModelData(false,"dfg"));
        headList.add(new HeadlineModelData(true,"dfg"));

        return headList;
    }
    public ArrayList<PhotoModelData> getPhoto(){
        ArrayList<PhotoModelData> listData=new ArrayList<>();
        listData.add(new PhotoModelData(R.drawable.cnbc_logo,false,"dfg"));
        listData.add(new PhotoModelData(R.drawable.cnbc_logo,false,"dfg"));
        listData.add(new PhotoModelData(R.drawable.cnbc_logo,true,"dfg"));
        listData.add(new PhotoModelData(R.drawable.cnbc_logo,true,"dfg"));
        return listData;
    }
    public ArrayList<ListModelData> getList(){

        ArrayList<ListModelData> arrayList=new ArrayList<>();
        arrayList.add(new ListModelData(R.drawable.cnbc_logo,"dfg"));
        arrayList.add(new ListModelData(R.drawable.cnbc_logo,"dfg"));
        arrayList.add(new ListModelData(R.drawable.cnbc_logo,"dfg"));
        arrayList.add(new ListModelData(R.drawable.cnbc_logo,"dfg"));
        return arrayList;
    }
}
