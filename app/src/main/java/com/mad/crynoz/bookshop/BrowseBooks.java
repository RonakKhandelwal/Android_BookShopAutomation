package com.mad.crynoz.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class BrowseBooks extends AppCompatActivity {

    ListView books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_books);
        books = (ListView)findViewById(R.id.browseBooks);
        List<BooksR> booksRList = new MyDatabaseHelper(this.getApplicationContext()).getAllBooks();
        BrowseBookAdapter adapter = new BrowseBookAdapter(this.getApplicationContext(),R.layout.row_view_requests, booksRList);
        books.setAdapter(adapter);
    }
}
