package com.example.make_1230;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.make_1230.adapter.adapter_four;
import com.example.make_1230.util.TopicFour_shopcar;
import com.example.make_1230.util.data_four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TopicFourActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG ="tag" ;
    private ImageView back,shopcar,sp_price,sp_number;
    private Button buy;
    private ListView listView;
    private List<data_four> list = new ArrayList<>();
    private adapter_four adapterFour;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_four);
        init();
        Log.d(TAG, "onCreate: is work");

    }

    private void init() {
        back = (ImageView)findViewById(R.id.back_t4);
        shopcar = (ImageView)findViewById(R.id.shopcar_four);
        sp_price = (ImageView)findViewById(R.id.price_sp_four);
        sp_number = (ImageView)findViewById(R.id.number_sp_four);
        listView = (ListView)findViewById(R.id.listview_four);
        buy = (Button)findViewById(R.id.Buy_four);
        listdata();
        back.setOnClickListener(this);
        shopcar.setOnClickListener(this);
        sp_price.setOnClickListener(this);
        sp_number.setOnClickListener(this);
        back.setOnClickListener(this);
        buy.setOnClickListener(this);
    }

    private void listdata() {
        for (int i = 1; i < 10; i++) {
            list.add(new data_four(i+"","发动机"+i+"0A",
                    "发动机供应商",  i*1000+"",i+""));
        }
        adapterFour = new adapter_four(list,TopicFourActivity.this);
        listView.setAdapter(adapterFour);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_t4://返回首页
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.price_sp_four:
                openpopmenu("单价",view);
                break;
            case R.id.number_sp_four:
                openpopmenu("数量",view);
                break;
            case R.id.shopcar_four:
                Toast.makeText(this,"不传数据了，我倦了",Toast.LENGTH_LONG).show();
                Intent intent1_shop = new Intent(this,TopicFour_shopcar.class);
//                intent1_shop.putExtras(bundle);
                startActivity(intent1_shop);
                break;
            case R.id.Buy_four:
                getbest();                
                break;
        }
    }

    private void getbest() {
        Log.d(TAG, "getbest: is work");
        int min = 0;
        int flag = 0;
        min = Integer.parseInt(list.get(0).getPrice())/Integer.parseInt(list.get(0).getNumber());
        for (int i = 0; i < list.size(); i++) {
            if (min>(Integer.parseInt(list.get(i).getPrice())/Integer.parseInt(list.get(i).getNumber()))){
                min = Integer.parseInt(list.get(i).getPrice())/Integer.parseInt(list.get(i).getNumber());
                flag=i;
            }
            Log.d(TAG, "getbest: flag="+flag);
        }
//        bundle.putString("shop", String.valueOf(new String[]{
//                list.get(flag).getId(),
//                list.get(flag).getName(),
//                list.get(flag).getSupplier(),
//                list.get(flag).getPrice(),
//                list.get(flag).getNumber()}));

        Toast.makeText(this,"不添",Toast.LENGTH_SHORT).show();
    }

    private void openpopmenu(final String value, View view) {
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.sp);
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.asc://升序
                        listdataasc(value);
                        adapterFour = new adapter_four(list,TopicFourActivity.this);
                        listView.setAdapter(adapterFour);
                        break;
                    case R.id.dec:
                        listdatadec(value);
                        adapterFour = new adapter_four(list,TopicFourActivity.this);
                        listView.setAdapter(adapterFour);
                        break;
                }
                return false;
            }
        });
    }
    public void listdataasc(String l){
        switch (l){
            case "单价":
                Toast.makeText(this,"单价升序",Toast.LENGTH_LONG).show();
                Collections.sort(list, new Comparator<data_four>() {
                    @Override
                    public int compare(data_four data_four, data_four t1) {
                        return Integer.parseInt(data_four.getPrice())-Integer.parseInt(t1.getPrice());
                    }
                });
                break;
            case "数量":
                Toast.makeText(this,"单价升序",Toast.LENGTH_LONG).show();
                Collections.sort(list, new Comparator<data_four>() {
                    @Override
                    public int compare(data_four data_four, data_four t1) {
                        return Integer.parseInt(data_four.getNumber())-Integer.parseInt(t1.getNumber());
                    }
                });
                break;
        }

    }
    public void listdatadec(String l){
        switch (l){
            case "单价":
                Toast.makeText(this,"单价降序",Toast.LENGTH_LONG).show();
                Collections.sort(list, new Comparator<data_four>() {
                    @Override
                    public int compare(data_four data_four, data_four t1) {
                        return Integer.parseInt(t1.getPrice())-Integer.parseInt(data_four.getPrice());
                    }
                });
                break;
            case "数量":
                Toast.makeText(this,"数量降序",Toast.LENGTH_LONG).show();
                Collections.sort(list, new Comparator<data_four>() {
                    @Override
                    public int compare(data_four data_four, data_four t1) {
                        return Integer.parseInt(t1.getNumber())-Integer.parseInt(data_four.getNumber());
                    }
                });
                break;
        }

    }
}
