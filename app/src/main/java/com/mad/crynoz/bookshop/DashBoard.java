package com.mad.crynoz.bookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        TextView read = (TextView)findViewById(R.id.read);
        read.setOnClickListener(this);
    }
}
