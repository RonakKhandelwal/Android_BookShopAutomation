package com.mad.crynoz.bookshop;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button signup, submit;
    EditText username, password;



    @Override
    public void onClick(View v) {
        if(v == submit) {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            MyDatabaseHelper db = new MyDatabaseHelper(this.getApplicationContext());
            LoginR login = db.getLogin(user);

            if(login != null && login.password.equals(pass)){
                Class<?> cls = HomeCustomer.class;
                if(login.type.equals("man")){
                    cls = HomeManager.class;
                }
                else if(login.type.equals("emp")){
                    cls = HomeEmployee.class;
                }
                Intent i = new Intent(this.getApplicationContext(), cls);
                i.putExtra("username", user);
                startActivity(i);
            }
            else{
                TextView tv = (TextView)findViewById(R.id.editText);
                tv.setText("Wrong username or password/n or");
            }

        }
        else {
            Intent i = new Intent(this, Signup.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        signup = (Button)findViewById(R.id.signup);
        submit = (Button)findViewById(R.id.Submit);


        signup.setOnClickListener(this);
        submit.setOnClickListener(this);

    }


}
