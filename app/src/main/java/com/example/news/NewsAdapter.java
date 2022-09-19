package com.example.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    class HeadlineCentricViewHolder extends RecyclerView.ViewHolder{

        public HeadlineCentricViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class PhotoCentricViewHolder extends RecyclerView.ViewHolder{

        public PhotoCentricViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class ListCentricViewHolder extends RecyclerView.ViewHolder{

        public ListCentricViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
