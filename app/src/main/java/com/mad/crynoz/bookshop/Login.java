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
import android.widget.ListView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Button submit = (Button) findViewById(R.id.submit);
//
//        submit.setOnClickListener(this);
//        NotificationCompat.Builder mb = new NotificationCompat.Builder(this);
//        mb.setContentTitle("Content");
//        mb.setContentText("Some more content");
//        Intent result = new Intent(this, DashBoard.class);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(DashBoard.class);
//        stackBuilder.addNextIntent(result);
//        PendingIntent pi = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//        mb.setContentIntent(pi);
//        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        nm.notify(0, mb.build());

//        Uri allContacts = Uri.parse("content://contacts/people");
//        Cursor c;
//        CursorLoader cursorLoader = new CursorLoader(this, allContacts, null, null, null, null);
//        c = cursorLoader.loadInBackground();
//        String[] columns = new String[]{
//                ContactsContract.Contacts.DISPLAY_NAME,
//                ContactsContract.Contacts._ID
//        };
//        int[] views = new int[]{
//                R.id.contactName,
//                R.id.contactID
//        };
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
//                this, R.layout.activity_login, c, columns, views, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
//        );
//        ListView l = (ListView) findViewById(R.id.android_list);
//        l.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, DashBoard.class);
        startActivity(i);
    }
}
