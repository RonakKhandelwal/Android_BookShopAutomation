package com.mad.crynoz.bookshop;

/**
 * Created by CryNoz on 11/11/16.
 */

public class BookRequest {

   public int esbn, price, quantity;
    public String name, authorName;

    public BookRequest(String n, String a, int e, int p, int q)
    {
        name = n;
        authorName = a;
        esbn = e;
        price = p;
        quantity = q;
    }
}
