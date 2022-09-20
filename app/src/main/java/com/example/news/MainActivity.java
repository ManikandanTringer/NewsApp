package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<NewsModel> list= new ArrayList();
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.cnbc_logo,true,NewsModel.TYPE_HEADLINE_CENTRIC));
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.cnbc_logo,true,NewsModel.TYPE_LIST_CENTRIC));
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.cnbc_logo,true,NewsModel.TYPE_HEADLINE_CENTRIC));
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.cnbc_logo,true,NewsModel.TYPE_LIST_CENTRIC));
        list.add(new NewsModel("Hello. This is the Text-only View Type. Nice to meet you",R.drawable.cnbc_logo,true,NewsModel.TYPE_PHOTO_CENTRIC));
       NewsAdapter adapter=new NewsAdapter(list,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        RecyclerView newsRV=(RecyclerView) findViewById(R.id.newsRV);
        newsRV.setLayoutManager(linearLayoutManager);
        newsRV.setAdapter(adapter);
    }
}