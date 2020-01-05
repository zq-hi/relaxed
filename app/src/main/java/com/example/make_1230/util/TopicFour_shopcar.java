package com.example.make_1230.util;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.make_1230.R;
import com.example.make_1230.TopicFourActivity;
import com.example.make_1230.adapter.adapter_four;

import java.util.ArrayList;
import java.util.List;

public class TopicFour_shopcar extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG ="tag" ;
    ImageView sp_price_shop,sp_number_shop;
    ImageView back_shop;
    TextView sum;
    ListView lv_shop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopcar);
        init();
        String shop ;
        Bundle bundle= getIntent().getExtras();
        shop = (String)bundle.get("shop");
        Toast.makeText(this,"TopicFour_shopcar",Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate: "+shop);

//        List<data_four> fourList= new ArrayList<>();
//        fourList.add(new data_four("1","123456","123456","12345","2"));
        sum.setText("152354");


    }

    private void init() {
        sp_price_shop = findViewById(R.id.price_sp_four_shopcar);
        sp_number_shop = findViewById(R.id.number_sp_four_shopcar);
        back_shop = (ImageView)findViewById(R.id.back_t4_shopcar);
        sum = (TextView)findViewById(R.id.sum_shopcar);
        lv_shop = (ListView)findViewById(R.id.listview_four);
        sp_number_shop.setOnClickListener(this);
        sp_price_shop.setOnClickListener(this);
        back_shop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.price_sp_four_shopcar://只有一条不存在排序的
                Toast.makeText(this,"只有一条不存在排序的",Toast.LENGTH_SHORT).show();
                break;
            case R.id.number_sp_four_shopcar:
                Toast.makeText(this,"懒了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.back_t4_shopcar:
                Intent intent = new Intent(this, TopicFourActivity.class);
                startActivity(intent);
                Toast.makeText(this,"返回",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
