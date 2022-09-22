package com.example.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.modeldata.PhotoModelData;
import com.example.news.R;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private List<PhotoModelData> photonewsList;

    public PhotoAdapter(List<PhotoModelData> photonewsList) {
        this.photonewsList = photonewsList;
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder holder, int position) {
        PhotoModelData modelData =photonewsList.get(position);
        if(modelData.isVideo()){
            holder.phototext.setText(modelData.getText());
            holder.photo_video_indicator.setVisibility(View.VISIBLE);


        }else{
            holder.photo_video_indicator.setVisibility(View.INVISIBLE);

        }
        holder.photoImg.setImageResource(modelData.getImgID());
        holder.phototext.setText(modelData.getText());

    }

    @Override
    public int getItemCount() {
        return photonewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImg;
        LinearLayout photo_video_indicator;
        TextView phototext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          photoImg=(ImageView)  itemView.findViewById(R.id.photoImg);
          photo_video_indicator=(LinearLayout)  itemView.findViewById(R.id.photo_video_indicator);
            phototext=(TextView) itemView.findViewById(R.id.phototext);
        }
    }
}
