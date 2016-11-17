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
        String user = username.getText().toString();
        String pass = password.getText().toString();
        RadioButton cus = (RadioButton)findViewById(R.id.customer);
        RadioButton man = (RadioButton)findViewById(R.id.manager);
        RadioButton emp = (RadioButton)findViewById(R.id.clerk);

        MyDatabaseHelper db = new MyDatabaseHelper(this.getApplicationContext());
        if(man.isChecked()){
            SignupR signupR = new SignupR(1, user, pass, "man");
            Toast.makeText(this.getApplicationContext(), "You Will be notified shortly", Toast.LENGTH_LONG);
            db.addSignup(signupR);
            finish();
        }
        else if(emp.isChecked()){
            SignupR signupR = new SignupR(1, user, pass, "emp");
            Toast.makeText(this.getApplicationContext(), "You Will be notified shortly", Toast.LENGTH_LONG);
            db.addSignup(signupR);
            finish();
        }
        else{
            LoginR login = new LoginR(user, pass, "cus");
            Log.d(TAG, "onClick: THis part called");
            db.addLogin(login);
            Intent i = new Intent(this.getApplicationContext(), HomeCustomer.class);
            startActivity(i);
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
