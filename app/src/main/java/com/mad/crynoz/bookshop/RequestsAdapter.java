package com.mad.crynoz.bookshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mad.crynoz.bookshop.BookRequest;
import com.mad.crynoz.bookshop.R;
import com.mad.crynoz.bookshop.RequestBooks;

import java.util.List;

/**
 * Created by CryNoz on 11/14/16.
 */

public class RequestsAdapter extends ArrayAdapter<BookRequest> {
    public RequestsAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public RequestsAdapter(Context context, int resource, List<BookRequest> items) {
        super(context, resource, items);
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
        BookRequest bookRequest = getItem(position);
        if(bookRequest != null){
            TextView t1 = (TextView)v.findViewById(R.id.bname);
            TextView t2 = (TextView)v.findViewById(R.id.author);
            TextView t3 = (TextView)v.findViewById(R.id.price);
            t1.setText(bookRequest.name);
            t2.setText(bookRequest.authorName);
            if(t3 != null) {
                String test = bookRequest.price + "";
                t3.setText(test != null ? test:"");
            }
        }

        return v;
    }
}
