package com.example.make_1230;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView t1,t2,t3,t4,t5,t6,t7,t8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        t1=(ImageView)findViewById(R.id.t1_ImageView);
        t2=(ImageView)findViewById(R.id.t2_ImageView);
        t3=(ImageView)findViewById(R.id.t3_ImageView);
        t4=(ImageView)findViewById(R.id.t4_ImageView);
        t5=(ImageView)findViewById(R.id.t5_ImageView);
        t6=(ImageView)findViewById(R.id.t6_ImageView);
        t7=(ImageView)findViewById(R.id.t7_ImageView);
        t8=(ImageView)findViewById(R.id.t8_ImageView);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
        t7.setOnClickListener(this);
        t8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.t1_ImageView:
                Intent intent1 = new Intent(this,TopicOne.class);
                startActivity(intent1);
                break;
            case R.id.t2_ImageView:
                Intent intent2 = new Intent(this,TopicTwoActivity.class);
                startActivity(intent2);
                break;
            case R.id.t3_ImageView:
                Intent intent3 = new Intent(this,TopicThreeActivity.class);
                startActivity(intent3);
                break;
            case R.id.t4_ImageView:
                Intent intent4 = new Intent(this,TopicFourActivity.class);
                startActivity(intent4);
                break;
            case R.id.t5_ImageView://第五
                Intent intent5 = new Intent(this,TopicTwoActivity.class);
                startActivity(intent5);
                break;
            case R.id.t6_ImageView:
                Intent intent6 = new Intent(this,TopicTwoActivity.class);
                startActivity(intent6);
                break;
            case R.id.t7_ImageView:
                Intent intent7 = new Intent(this,TopicTwoActivity.class);
                startActivity(intent7);
                break;
            case R.id.t8_ImageView:
                Intent intent8 = new Intent(this,TopicTwoActivity.class);
                startActivity(intent8);
                break;
        }
    }
}
