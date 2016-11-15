package com.mad.crynoz.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ViewSignups extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_signups);

        lv = (ListView)findViewById(R.id.signups);
        final MyDatabaseHelper db = new MyDatabaseHelper(this.getApplicationContext());
        List<SignupR> signups = db.getSignups();
        SignupAdapter adapter = new SignupAdapter(this.getApplicationContext(), R.layout.row_view_requests, signups);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SignupR signup = (SignupR) parent.getItemAtPosition(position);
                LoginR login = new LoginR(signup.username, signup.password, signup.type);
                db.addLogin(login);
                db.deleteSignup(login.username);

            }
        });
    }
}
