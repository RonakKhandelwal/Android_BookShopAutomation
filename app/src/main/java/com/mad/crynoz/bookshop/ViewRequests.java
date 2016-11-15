package com.mad.crynoz.bookshop;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String type = b.getString("type");
        if(type.equals("man")){
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    BookRequest request = (BookRequest) parent.getItemAtPosition(position);
                    OrdersR booksR = new OrdersR(request.name, request.authorName, request.esbn, request.price, request.quantity);
                    MyDatabaseHelper db = new MyDatabaseHelper(getApplicationContext());
                    db.addOrder(booksR);
                    db.deleteRequest(request.name);

                }
            });
        }
    }
}
