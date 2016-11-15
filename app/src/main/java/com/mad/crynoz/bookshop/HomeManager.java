package com.mad.crynoz.bookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeManager extends AppCompatActivity implements View.OnClickListener {

    Button viewRequests, addBooks, regReq, orders;


    @Override
    public void onClick(View v) {
        if(v == viewRequests){
            Intent i = new Intent(this.getApplicationContext(), ViewRequests.class);
            i.putExtra("type", "man");
            startActivity(i);
        }
        else if(v == addBooks){
            Intent i = new Intent(this.getApplicationContext(), BrowseBooks.class);
            startActivity(i);
        }
        else if(v == orders){
            Intent i = new Intent(this.getApplicationContext(), BrowseOrders.class);
            startActivity(i);
        }
        else if(v == regReq){
            Intent i = new Intent(this.getApplicationContext(), ViewSignups.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_manager);
        viewRequests = (Button)findViewById(R.id.button1);
        viewRequests.setOnClickListener(this);

        addBooks = (Button)findViewById(R.id.button2);
        addBooks.setOnClickListener(this);

        orders = (Button)findViewById(R.id.button4);
        orders.setOnClickListener(this);

        regReq = (Button)findViewById(R.id.button3);
        regReq.setOnClickListener(this);
    }
}
