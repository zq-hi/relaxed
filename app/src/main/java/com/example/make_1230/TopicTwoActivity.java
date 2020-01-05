package com.example.make_1230;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TopicTwoActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView worm_image,cold_image,power_image,back;
    private Button worm_button,cold_button;
    private Boolean isopen=false;
    private int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_two);
        init();
    }

    private void init() {
        back = (ImageView)findViewById(R.id.back_t2);
        worm_image = (ImageView)findViewById(R.id.worm_topictwo);
        cold_image = (ImageView)findViewById(R.id.cold_topictwo);
        power_image = (ImageView)findViewById(R.id.power_topictwo);
        worm_button =(Button)findViewById(R.id.worm_button);
        cold_button = (Button)findViewById(R.id.cold_button);
        back.setOnClickListener(this);
        power_image.setOnClickListener(this);
        worm_button.setOnClickListener(this);
        cold_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_t2:
                Intent intent_t2 = new Intent(TopicTwoActivity.this,MainActivity.class);
                startActivity(intent_t2);
                break;
            case R.id.power_topictwo:
                flag++;
                isopen(flag);
                break;
            case R.id.worm_button:
                setWormOpen();
                break;
            case R.id.cold_button:
                setColdOpen();
                break;
        }

    }

    private void setColdOpen() {
        if (isopen==true) {
            cold_image.setImageResource(R.drawable.two_lengd1);
            worm_image.setImageResource(R.drawable.two_lengd2_visily);
            try {
                //模拟发送指令给服务器
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(TopicTwoActivity.this,"开启冷风",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(TopicTwoActivity.this,"请先开启电源",Toast.LENGTH_LONG).show();
    }

    private void setWormOpen() {
        if (isopen==true) {
            cold_image.setImageResource(R.drawable.two_lengd1_visily);
            worm_image.setImageResource(R.drawable.two_lengd2);
            try {
                //模拟发送指令给服务器
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(TopicTwoActivity.this,"开启暖风",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(TopicTwoActivity.this,"请先开启电源",Toast.LENGTH_LONG).show();
    }

    private void isopen(int i) {
        if (i%2==1) {
            isopen = true;
            Toast.makeText(TopicTwoActivity.this,"已开启车间空调",Toast.LENGTH_SHORT).show();
        }else{
            isopen = false;
            Toast.makeText(TopicTwoActivity.this,"已关闭车间空调",Toast.LENGTH_SHORT).show();
        }


    }
}
