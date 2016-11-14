package com.mad.crynoz.bookshop;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ListView lv = (ListView)findViewById(R.id.books);
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d("Search Activity", "onCreate: Got shit" + query);
            MyDatabaseHelper db = new MyDatabaseHelper(this.getApplicationContext());
            query = "%" + query + "%";
            List<BooksR> books = db.getBooks(query);
            BrowseBookAdapter adapter = new BrowseBookAdapter(this.getApplicationContext(), R.layout.row_view_requests, books);
            lv.setAdapter(adapter);
        }

    }
}
