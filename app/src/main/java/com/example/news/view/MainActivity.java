package com.example.news.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.news.R;
import com.example.news.adapter.NewsAdapter;
import com.example.news.modeldata.NewsModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       NewsAdapter adapter=new NewsAdapter(getView(),this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        RecyclerView newsRV=(RecyclerView) findViewById(R.id.newsRV);
        newsRV.setLayoutManager(linearLayoutManager);
        newsRV.setAdapter(adapter);


    }

    public ArrayList<NewsModel> getView(){
        ArrayList<NewsModel> list= new ArrayList();
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.img3,false,NewsModel.TYPE_HEADLINE_CENTRIC));
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.img2,true,NewsModel.TYPE_LIST_CENTRIC));
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.news2,true,NewsModel.TYPE_PHOTO_CENTRIC));
        return list;
    }

}