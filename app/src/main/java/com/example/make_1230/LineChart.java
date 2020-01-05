package com.example.make_1230;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class LineChart extends Fragment {

    private com.github.mikephil.charting.charts.LineChart lineChart ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.linechart, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lineChart = view.findViewById(R.id.linechart);
        initdata();
        initxy();
    }

    private void initxy() {
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisLeft().setAxisMinimum(0);
        YAxis yAxis =lineChart.getAxisRight();
        yAxis.setEnabled(false);
        Legend legend = new Legend();
        legend.setEnabled(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setLabelCount(7,true);
        String[] xaxis = new String[]{};//x轴
    }

    private void initdata() {
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(new Entry(i, (float) (Math.random()*100%50)));
        }
        LineDataSet dataSet = new LineDataSet(list,null);
        //隐藏图例
        Description description = new Description();
        description.setEnabled(false);
        lineChart.setDescription(description);
        LineData data = new LineData();
        data.addDataSet(dataSet);
        lineChart.setData(data);
    }
}
