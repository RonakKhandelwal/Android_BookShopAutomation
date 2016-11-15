package com.mad.crynoz.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class BrowseOrders extends AppCompatActivity {


    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_orders);

        lv = (ListView) findViewById(R.id.orders);
        List<OrdersR> orderss = new MyDatabaseHelper(this.getApplicationContext()).getAllOrders();
        BrowseOrderAdapter adapter = new BrowseOrderAdapter(this.getApplicationContext(), R.layout.row_view_requests, orderss);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrdersR request = (OrdersR) parent.getItemAtPosition(position);
                BooksR booksR = new BooksR(request.name, request.authorName, request.esbn, request.price, request.quantity);
                MyDatabaseHelper db = new MyDatabaseHelper(getApplicationContext());
                db.addBook(booksR);
                db.deleteOrder(request.name);
            }
        });
    }
}
