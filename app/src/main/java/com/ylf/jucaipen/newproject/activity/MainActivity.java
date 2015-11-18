package com.ylf.jucaipen.newproject.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ylf.jucaipen.newproject.R;

public class MainActivity extends AppCompatActivity {
    private ViewStub show;
    private Button isShow;
    private  Button isLoad;
    private  Button isGone;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        show= (ViewStub) findViewById(R.id.show);
        isShow= (Button) findViewById(R.id.isShow);
        isLoad= (Button) findViewById(R.id.isLoad);
        isGone= (Button) findViewById(R.id.isGone);
        isLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view=show.inflate();
            }
        });
        isShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.VISIBLE);
            }
        });
        isGone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.GONE);
            }
        });
    }
}
