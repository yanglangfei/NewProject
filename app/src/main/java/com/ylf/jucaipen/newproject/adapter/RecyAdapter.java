package com.ylf.jucaipen.newproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/17.
 */
public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.MyHolder> {
    private  String name[]={"张三","李四","王五","赵丽"};
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv=new TextView(parent.getContext());
        MyHolder holder=new MyHolder(tv);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
       holder.tv.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyHolder extends  RecyclerView.ViewHolder{
        private TextView tv;
        public MyHolder(TextView itemView) {
            super(itemView);
            this.tv=itemView;
        }
    }
}
