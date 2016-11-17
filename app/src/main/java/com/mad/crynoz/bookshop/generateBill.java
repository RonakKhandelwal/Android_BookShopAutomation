package com.mad.crynoz.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class generateBill extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView books;


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        BooksR book = (BooksR) parent.getItemAtPosition(position);
        TextView tv = (TextView)findViewById(R.id.totalBill);
        int tot = Integer.parseInt(tv.getText().toString());
        tot+=book.price;
        tv.setText(tot + "");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_bill);

        books = (ListView)findViewById(R.id.lv);
        List<BooksR> booksRList = new MyDatabaseHelper(this.getApplicationContext()).getAllBooks();
        BrowseBookAdapter adapter = new BrowseBookAdapter(this.getApplicationContext(),R.layout.row_view_requests, booksRList);
        books.setAdapter(adapter);
        books.setOnItemClickListener(this);
    }
}
