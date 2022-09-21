package com.example.news;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.videoTV.setText(modelData.getTextHeadnews());

        if(modelData.isVideo()){
            Log.d("msg",modelData.getTextHeadnews());
            holder.playBtn.setVisibility(View.VISIBLE);
            holder.headnewsTV.setVisibility(View.VISIBLE);
        }else{
            holder.playBtn.setVisibility(View.GONE);
            holder.headnewsTV.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return photoNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView headnewsTV,videoTV;
        ImageButton playBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            headnewsTV=itemView.findViewById(R.id.headnewsTV);
            videoTV=itemView.findViewById(R.id.videoTV);
            playBtn=itemView.findViewById(R.id.playBtn);
        }
    }
}
