package com.example.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.modeldata.ListModelData;
import com.example.news.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListModelData> listnews;

    public ListAdapter(List<ListModelData> listnews) {
        this.listnews = listnews;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_rv,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ListModelData modelData=listnews.get(position);
            holder.listImgId.setImageResource(modelData.getImgId());
            holder.listText.setText(modelData.getTextListnews());



    }

    @Override
    public int getItemCount() {
        return listnews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView listImgId;
        TextView listText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImgId=itemView.findViewById(R.id.listImgId);
            listText=itemView.findViewById(R.id.listText);

        }
    }
}
