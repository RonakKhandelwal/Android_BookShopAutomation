package com.mad.crynoz.bookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "Signup";
    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: Started or clicked");
        String user = username.getText().toString();
        String pass = password.getText().toString();

        Log.d(TAG, "onClick: IDhar");
        LoginR login = new LoginR(user, pass, "cus");
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        long l = db.addLogin(login);
        Log.d(TAG, "onClick: " + l);
        if(l != -1)
        {
            Intent i = new Intent(this, HomeCustomer.class);
            startActivity(i);
        }
        else{
            Log.d(TAG, "onClick: Could not insert");
            Toast.makeText(getApplicationContext(), "Some Random Error Occured", Toast.LENGTH_LONG);
        }



    }

    Button submit;
    EditText username, password, passwordC;
    RadioButton customer, clerk, manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //button
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
        //EditTexts
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        passwordC = (EditText)findViewById(R.id.confirmPassword);
        //radioButtons
        customer = (RadioButton)findViewById(R.id.customer);
        clerk = (RadioButton)findViewById(R.id.clerk);
        manager = (RadioButton)findViewById(R.id.manager);

    }


}
