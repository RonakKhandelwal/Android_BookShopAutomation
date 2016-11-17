package com.mad.crynoz.bookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeEmployee extends AppCompatActivity implements View.OnClickListener {

    Button bookRequests, viewAllBooks, generateBill;


    @Override
    public void onClick(View v) {
        if(v == viewAllBooks){
            Intent i = new Intent(this.getApplicationContext(), BrowseBooks.class);
            i.putExtra("Extra" ,"e");
            startActivity(i);
        }
        else if(v == generateBill){
            Intent i = new Intent(this.getApplicationContext(), generateBill.class);
            i.putExtra("Extra" ,"e");
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_employee);
        bookRequests = (Button)findViewById(R.id.button3);
        viewAllBooks = (Button)findViewById(R.id.button2);
        generateBill = (Button)findViewById(R.id.button1);
        viewAllBooks.setOnClickListener(this);
        generateBill.setOnClickListener(this);
    }
}
