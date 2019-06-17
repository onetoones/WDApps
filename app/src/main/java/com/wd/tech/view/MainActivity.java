package com.wd.tech.view;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;
import com.wd.tech.model.utlis.MActivity;
import com.wd.tech.model.utlis.MD5Utils;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    String url = "http://p1.pstatp.com/large/166200019850062839d3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String encode = MD5Utils.encode("123456");

        Log.e("1111", encode);
        intitview();

    }

    private void intitview() {
        iv = findViewById(R.id.iv_ac);
        Glide.with(this)

                .load(url)
                .override(100,100)
                .into(iv);

    }


}
