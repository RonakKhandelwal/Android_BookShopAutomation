package com.mad.crynoz.bookshop;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ViewRequests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_requests);
        List<BookRequest> list = new MyDatabaseHelper(this.getApplicationContext()).getAllRequests();
        RequestsAdapter adapter = new RequestsAdapter(this.getApplicationContext(), R.layout.row_view_requests, list);
        ListView lv = (ListView)findViewById(R.id.requestList);
        lv.setAdapter(adapter);
    }
}
