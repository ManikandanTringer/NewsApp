package com.example.news.adapter;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.modeldata.HeadlineModelData;
import com.example.news.R;

import java.util.ArrayList;

public class HeadlineAdapter extends RecyclerView.Adapter<HeadlineAdapter.ViewHolder> {
    ArrayList<HeadlineModelData> photoNewsList;

    public HeadlineAdapter(ArrayList<HeadlineModelData> photoNewsList) {

        this.photoNewsList = photoNewsList;
    }

    @NonNull
    @Override
    public HeadlineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_headline_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlineAdapter.ViewHolder holder, int position) {

        HeadlineModelData modelData=photoNewsList.get(position);
        holder.headnewsTV.setText(modelData.getTextHeadnews());
        holder.secondTV.setText(modelData.getSecondText());



        if(modelData.isVideo()){
            holder.playBtn.setVisibility(View.VISIBLE);
            holder.headnewsTV.setVisibility(View.VISIBLE);
        }else{
            holder.playBtn.setVisibility(View.GONE);
            holder.videoTV.setVisibility(View.GONE);
            holder.headnewsTV.setPadding(30,0,0,0);
        }

    }

    @Override
    public int getItemCount() {
        return photoNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView headnewsTV,videoTV;
        ImageButton playBtn;
        LinearLayout secondlayout;
        TextView secondTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            headnewsTV=itemView.findViewById(R.id.headnewsTV);
            videoTV=itemView.findViewById(R.id.videoTV);
            playBtn=itemView.findViewById(R.id.playBtn);
            secondlayout=itemView.findViewById(R.id.secondlayout);
            secondTV=itemView.findViewById(R.id.secondTV);

        }
    }
}
