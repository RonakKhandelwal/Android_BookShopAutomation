package com.mad.crynoz.bookshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CryNoz on 11/15/16.
 */

public class SignupAdapter extends ArrayAdapter<SignupR> {

    public SignupAdapter(Context context, int resource, List<SignupR> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.row_view_requests, null);
        }
        SignupR bookRequest = getItem(position);
        if(bookRequest != null){
            TextView t1 = (TextView)v.findViewById(R.id.bname);
            TextView t2 = (TextView)v.findViewById(R.id.author);
            TextView t3 = (TextView)v.findViewById(R.id.price);
            t1.setText(bookRequest.username);
            t2.setText(bookRequest.password);
            if(t3 != null) {
                String test = bookRequest.type + "";
                t3.setText(test != null ? test:"");
            }
        }

        return v;
    }
}
