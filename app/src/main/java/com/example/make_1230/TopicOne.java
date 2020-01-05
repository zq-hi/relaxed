package com.example.make_1230;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_1230.R;
import com.example.make_1230.adapter.baseadapter;
import com.example.make_1230.util.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TopicOne extends AppCompatActivity implements View.OnClickListener {
    ImageView back,sp1,sp2,sp3;
    TextView sum_price,dzprice,jpprice,blueprice;
    Fragment fragment ;
    ListView listView ;
    List<data> list = new ArrayList<>();
    com.example.make_1230.adapter.baseadapter baseadapter;
    String [] carname = new String[]{"大众汽车","吉普汽车","蓝色汽车"};
    int [] carprice = new int[]{120000,240000,80000};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);//别管
        init();
        fragment=new LineChart();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_t1,fragment).commitAllowingStateLoss();
    }

    private void init() {
        back = (ImageView)findViewById(R.id.back_t1);
        back.setOnClickListener(this);
        //弹出小菜单
        sp1 = (ImageView)findViewById(R.id.price_t1);
        sp2 = (ImageView)findViewById(R.id.saleTime_t1);
        sp3 = (ImageView)findViewById(R.id.salenumber_t1);
        sp1.setOnClickListener(this);
        sp2.setOnClickListener(this);
        sp3.setOnClickListener(this);

        sum_price = (TextView)findViewById(R.id.sum_price_one);
        dzprice = (TextView)findViewById(R.id.dzprice);
        jpprice = (TextView)findViewById(R.id.jpprice);
        blueprice = (TextView)findViewById(R.id.blueprice);
        listView = (ListView)findViewById(R.id.listview_t1);
        setdata();
        baseadapter = new baseadapter(this,list);
        listView.setAdapter(baseadapter);
    }

    private void setdata() {
        list.clear();
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            list.add(new data(carname[i%3]+"",carprice[i%3]+"",
                    "2019-09-15-14-"+i,i%4+1+""));
            sum +=carprice[i%3];
        }
        dzprice.setText(carprice[0]+"");
        jpprice.setText(carprice[1]+"");
        blueprice.setText(carprice[2]+"");
        sum_price.setText(sum+"");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_t1:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.price_t1:
                popmenu(view,"价格");
                break;
            case R.id.saleTime_t1:
                popmenu(view,"时间");
                break;
            case R.id.salenumber_t1:
                popmenu(view,"数量");
                break;
        }
    }

    private void popmenu(View view, final String values) {
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.sp);
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.asc:
                        Collectionasc(values);
                        baseadapter = new baseadapter(TopicOne.this,list);
                        listView.setAdapter(baseadapter);
                        break;
                    case R.id.dec:
                        Collectiondec(values);
                        baseadapter = new baseadapter(TopicOne.this,list);
                        listView.setAdapter(baseadapter);
                        break;
                }
                return false;
            }
        });
    }

    private void Collectiondec(String values) {
        switch (values){
            case "价格":
                Collections.sort(list, new Comparator<data>() {
                    @Override
                    public int compare(data data, data t1) {
                        return Integer.parseInt(t1.getPrice()) - Integer.parseInt(data.getPrice());
                    }
                });
                Toast.makeText(this,"价格的降序",Toast.LENGTH_LONG).show();
                break;
            case "时间":
                Collections.sort(list, new Comparator<data>() {
                    @Override
                    public int compare(data data, data t1) {
                        Date date = null;
                        Date date1 = null;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd-hh-mm").parse(data.getSaletime());
                            date1 = new SimpleDateFormat("yyyy-MM-dd-hh-mm").parse(t1.getSaletime());

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return date1.compareTo(date);
                    }
                });
                Toast.makeText(this,"时间的降序",Toast.LENGTH_LONG).show();
                break;
            case "数量":
                Collections.sort(list, new Comparator<data>() {
                    @Override
                    public int compare(data data, data t1) {
                        return Integer.parseInt(t1.getSalenumber())-Integer.parseInt(data.getSalenumber());
                    }
                });
                Toast.makeText(this,"数量的降序",Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void Collectionasc(String values) {
        switch (values){
            case "价格":
                Collections.sort(list, new Comparator<data>() {
                    @Override
                    public int compare(data data, data t1) {
                        return Integer.parseInt(data.getPrice()) - Integer.parseInt(t1.getPrice());
                    }
                });
                Toast.makeText(this,"价格的升序",Toast.LENGTH_LONG).show();
                break;
            case "时间":
                Collections.sort(list, new Comparator<data>() {
                    @Override
                    public int compare(data data, data t1) {
                        Date date = null;
                        Date date1 = null;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd-hh-mm").parse(data.getSaletime());
                            date1 = new SimpleDateFormat("yyyy-MM-dd-hh-mm").parse(t1.getSaletime());

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return date.compareTo(date1);
                    }
                });

                Toast.makeText(this,"时间的升序",Toast.LENGTH_LONG).show();
                break;
            case "数量":
                Collections.sort(list, new Comparator<data>() {
                    @Override
                    public int compare(data data, data t1) {
                        return Integer.parseInt(data.getSalenumber())-Integer.parseInt(t1.getSalenumber());
                    }
                });
                Toast.makeText(this,"数量的升序",Toast.LENGTH_LONG).show();
                break;
        }
    }

}
