package com.example.make_1230.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.make_1230.R;
import com.example.make_1230.util.data;

import java.util.List;

public class baseadapter extends BaseAdapter {
    List<data> list;
    LayoutInflater layoutInflater ;
    listview lv;
    public baseadapter(Context context,List<data> list) {
        this.list = list;
        this.layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            lv = new listview();
            view = layoutInflater.inflate(R.layout.listview_one,null);
            lv.id= view.findViewById(R.id.name_listview);
            lv.price =view.findViewById(R.id.price_listview);
            lv.time = view.findViewById(R.id.saleTime_listview);
            lv.number = view.findViewById(R.id.salenumber_listview);
            view.setTag(lv);
        }else
            view.getTag();
        lv.id.setText(list.get(i).getName());
        lv.price.setText(list.get(i).getPrice());
        lv.time.setText(list.get(i).getSaletime());
        lv.number.setText(list.get(i).getSalenumber());
        return view;
    }
}
class listview{ TextView id,price,time,number;
}
