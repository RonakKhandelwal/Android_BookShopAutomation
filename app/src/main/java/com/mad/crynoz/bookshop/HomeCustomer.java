package com.mad.crynoz.bookshop;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class HomeCustomer extends AppCompatActivity implements View.OnClickListener {



    Button request, viewAll, viewRequest;

    @Override
    public void onClick(View v) {

        if(v == request)
        {
            Intent i = new Intent(this, RequestBooks.class);
            startActivity(i);
        }
        else if(v == viewRequest) {
            Intent i = new Intent(this, ViewRequests.class);
            i.putExtra("type", "cus");
            startActivity(i);
        }
        else if(v == viewAll) {
            Intent i = new Intent(this, BrowseBooks.class);
            startActivity(i);
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dashboard, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);
        request = (Button)findViewById(R.id.button1);
        request.setOnClickListener(this);

        viewRequest = (Button)findViewById(R.id.button3);
        viewRequest.setOnClickListener(this);

        viewAll = (Button)findViewById(R.id.button2);
        viewAll.setOnClickListener(this);


    }
}
