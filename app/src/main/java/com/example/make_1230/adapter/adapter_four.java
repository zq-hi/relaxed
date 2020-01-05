package com.example.make_1230.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.make_1230.R;
import com.example.make_1230.util.data_four;

import java.util.ArrayList;
import java.util.List;

public class adapter_four extends BaseAdapter {
    List<data_four> data_fourList = new ArrayList<>();
    LayoutInflater inflater ;
    listview_set setdata;
    public adapter_four(List<data_four> data_fourList, Context context ) {
        this.data_fourList = data_fourList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data_fourList.size();
    }

    @Override
    public Object getItem(int i) {
        return data_fourList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            setdata = new listview_set();
            view = inflater.inflate(R.layout.listview_four,null);
            setdata.id = view.findViewById(R.id.id_four);
            setdata.name = view.findViewById(R.id.name_four);
            setdata.supplier = view.findViewById(R.id.supplier_four);
            setdata.price = view.findViewById(R.id.price_four);
            setdata.number = view.findViewById(R.id.number_four);
            view.setTag(setdata);
        }
        else
            view.getTag();
        setdata.id.setText(data_fourList.get(i).getId());
        setdata.name.setText(data_fourList.get(i).getName());
        setdata.supplier.setText(data_fourList.get(i).getSupplier());
        setdata.price.setText(data_fourList.get(i).getPrice());
        setdata.number.setText(data_fourList.get(i).getNumber());
        return view;
    }
}
class  listview_set{
    TextView id,name,supplier,price,number;
}
