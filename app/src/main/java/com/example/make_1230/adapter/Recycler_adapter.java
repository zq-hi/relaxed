package com.example.make_1230.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.make_1230.R;
import com.example.make_1230.util.data_three;

import java.util.List;

public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.vh> {
    List<data_three> dataThrees ;
    Context context ;

    public Recycler_adapter(Context context,  List<data_three> dataThrees) {
        this.context = context;
        this.dataThrees = dataThrees;
    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new vh(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_three,null));
    }

    @Override
    public void onBindViewHolder(@NonNull final vh holder, int position) {
        holder.time.setText(dataThrees.get(position).getTime());
        holder.content.setText(dataThrees.get(position).getContent());
        for (int i = 0; i <3 ; i++) {
            TextView textView = new TextView(context);
            textView.setText("this is ok"+i);
            textView.setBackgroundResource(R.drawable.dialog);
            holder.linearLayout.addView(textView);
        }



    }

    @Override
    public int getItemCount() {
        return dataThrees.size();
    }

    public class vh extends RecyclerView.ViewHolder {
        TextView time,content;
        LinearLayout linearLayout;
        public vh(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time_three_recycler);
            content = itemView.findViewById(R.id.content_three_recycler);
            linearLayout= itemView.findViewById(R.id.auto_three);
        }
    }
}
