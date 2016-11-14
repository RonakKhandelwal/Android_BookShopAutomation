package com.mad.crynoz.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;

public class RequestBooks extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "TESt";

    Button submit;
    EditText bname, author, price, quantity;

    @Override
    public void onClick(View v) {
        String book, auth, pri, quanti;
        book = bname.getText().toString();
        auth = author.getText().toString();
        pri = price.getText().toString();
        quanti = quantity.getText().toString();
        BookRequest bboo = new BookRequest(book, auth, 1, Integer.parseInt(pri), Integer.parseInt(quanti));
        MyDatabaseHelper db = new MyDatabaseHelper(getApplicationContext());
        long ans = db.addRequest(bboo);
        if(ans != -1){
            this.finish();
        }
        else{
            Log.d(TAG, "onClick: RequestBooks");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_books);
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
        bname = (EditText)findViewById(R.id.bname);
        author = (EditText)findViewById(R.id.author);
        price = (EditText)findViewById(R.id.price);
        quantity = (EditText)findViewById(R.id.quantity);
    }
}
