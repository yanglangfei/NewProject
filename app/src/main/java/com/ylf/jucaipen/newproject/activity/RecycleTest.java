package com.ylf.jucaipen.newproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ylf.jucaipen.newproject.R;
import com.ylf.jucaipen.newproject.adapter.RecyAdapter;

/**
 * Created by Administrator on 2015/11/17.
 */
public class RecycleTest extends Activity {

    private RecyclerView recycle;
    private RecyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_cycle);
        initView();
    }

    private void initView() {
        recycle=(RecyclerView)findViewById(R.id.recycle);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recycle.setLayoutManager(manager);
        adapter=new RecyAdapter();
        recycle.setAdapter(adapter);

    }
}
