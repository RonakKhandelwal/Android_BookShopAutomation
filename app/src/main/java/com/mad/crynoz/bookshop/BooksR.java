package com.mad.crynoz.bookshop;

/**
 * Created by CryNoz on 11/11/16.
 */

public class BooksR {
    int esbn, price, quantity;
    String name, authorName;

    public BooksR(String n, String a, int e, int p, int q)
    {
        name = n;
        authorName = a;
        esbn = e;
        price = p;
        quantity = q;
    }

}
