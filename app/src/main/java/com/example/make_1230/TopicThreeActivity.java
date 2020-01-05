package com.example.make_1230;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.make_1230.adapter.Recycler_adapter;
import com.example.make_1230.util.data_three;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicThreeActivity extends AppCompatActivity {
    private List<data_three> threeList =new ArrayList<>();
    private Recycler_adapter recyclerAdapter;
    private RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_three);
        init();
        Log.d("tag", "TopicThreeActivity onCreate: is work");
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_three);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        for (int i = 0; i < 5; i++) {
            Date date = new Date();
            threeList.add(new data_three(simpleDateFormat.format(date.getTime())+"",
                                "消息"+i+1));
        }
        recyclerAdapter = new Recycler_adapter(TopicThreeActivity.this,threeList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }
}
