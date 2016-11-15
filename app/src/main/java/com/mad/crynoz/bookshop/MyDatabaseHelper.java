package com.mad.crynoz.bookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CryNoz on 11/11/16.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK_REQUEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIGNUP);
        onCreate(db);
    }

    private static final String TAG = "DATABASE";

    private static final String DATABASE_NAME = "BookShop";

    private static final String TABLE_BOOKS = "books";
    private static final String TABLE_BOOK_REQUEST = "books_request";
    private static final String TABLE_ORDERS = "orders";
    private static final String TABLE_LOGIN = "login";
    private static final String TABLE_SIGNUP = "registration_request";


    // Columns for books
    private static final String KEY_ESBN = "esbn";
    private static final String KEY_BNAME = "bname";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PRICE = "price";
    private static final String KEY_QUANTITY = "quantity";


    // Columns for login
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_TYPE = "type";

    // Create strings

    private static final String CREATE_TABLE_BOOKS = "CREATE TABLE "
            + TABLE_BOOKS + "(" + KEY_ESBN + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_BNAME
            + " TEXT," + KEY_AUTHOR + " TEXT," + KEY_PRICE + " INTEGER,"  + KEY_QUANTITY + " INTEGER" + ")";

    private static final String CREATE_TABLE_BOOK_REQUEST = "CREATE TABLE "
            + TABLE_BOOK_REQUEST + "(" + KEY_ESBN + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_BNAME
            + " TEXT," + KEY_AUTHOR + " TEXT," + KEY_PRICE + " INTEGER,"  + KEY_QUANTITY + " INTEGER" + ")";

    private static final String CREATE_TABLE_ORDERS = "CREATE TABLE "
            + TABLE_ORDERS + "(" + KEY_ESBN + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_BNAME
            + " TEXT," + KEY_AUTHOR + " TEXT," + KEY_PRICE + " INTEGER,"  + KEY_QUANTITY + " INTEGER" + ")";
    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE "
            + TABLE_LOGIN + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USERNAME
            + " TEXT," + KEY_PASSWORD + " TEXT," + KEY_TYPE + " TEXT"  + ")";
    private static final String CREATE_TABLE_SIGNUP = "CREATE TABLE "
            + TABLE_SIGNUP + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USERNAME
            + " TEXT," + KEY_PASSWORD + " TEXT," + KEY_TYPE + " TEXT"  + ")";

    private static final int DATABASE_VERSION = 2;

    public MyDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BOOK_REQUEST);
        db.execSQL(CREATE_TABLE_BOOKS);
        db.execSQL(CREATE_TABLE_ORDERS);
        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_SIGNUP);

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, "admin");
        values.put(KEY_PASSWORD, "admin");
        values.put(KEY_TYPE, "man");

        long valu = db.insert(TABLE_LOGIN, null, values);
    }


    // Book Related getters and setters

    public List<BooksR> getBooks(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        List<BooksR> books = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_BOOKS + " WHERE "
                + KEY_BNAME + " like " + name;

        Log.e("DB", selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do{
                int esbn = c.getInt(c.getColumnIndex(KEY_ESBN));
                String bname = c.getString(c.getColumnIndex(KEY_BNAME));
                String author = c.getString(c.getColumnIndex(KEY_AUTHOR));
                int price = c.getInt(c.getColumnIndex(KEY_PRICE));
                int quantity = c.getInt(c.getColumnIndex(KEY_QUANTITY));

                BooksR book = new BooksR(bname, author, esbn,  price, quantity);
                books.add(book);

            }while(c.moveToNext());
        }
        return books;

    }

    public boolean deleteRequest(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete(TABLE_BOOK_REQUEST, KEY_BNAME + " = '" + name + "'", null) > 0;
    }

    public boolean deleteOrder(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete(TABLE_ORDERS, KEY_BNAME + " = '" + name + "'", null) > 0;
    }

    public boolean deleteSignup(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete(TABLE_SIGNUP, KEY_USERNAME + " = '" + name + "'", null) > 0;
    }

    public List<BooksR> getAllBooks(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<BooksR> books = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_BOOKS;

        Log.e("DB", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do{
                int esbn = c.getInt(c.getColumnIndex(KEY_ESBN));
                String bname = c.getString(c.getColumnIndex(KEY_BNAME));
                String author = c.getString(c.getColumnIndex(KEY_AUTHOR));
                int price = c.getInt(c.getColumnIndex(KEY_PRICE));
                int quantity = c.getInt(c.getColumnIndex(KEY_QUANTITY));

                BooksR book = new BooksR(bname, author, esbn,  price, quantity);
                books.add(book);

            }while(c.moveToNext());
        }
        return books;

    }

    public long addBook(BooksR book)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BNAME, book.name);
        values.put(KEY_AUTHOR, book.authorName);
        values.put(KEY_PRICE, book.price);
        values.put(KEY_QUANTITY, book.quantity);
         long valu = db.insert(TABLE_BOOKS, null, values);
        return  valu;

    }

    public long addRequest(BookRequest book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BNAME, book.name);
        values.put(KEY_AUTHOR, book.authorName);
        values.put(KEY_PRICE, book.price);
        values.put(KEY_QUANTITY, book.quantity);
        long valu = db.insert(TABLE_BOOK_REQUEST, null, values);
        return  valu;

    }
    public List<BookRequest> getAllRequests(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<BookRequest> books = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_BOOK_REQUEST;

        Log.e("DB", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do{
                int esbn = c.getInt(c.getColumnIndex(KEY_ESBN));
                String bname = c.getString(c.getColumnIndex(KEY_BNAME));
                String author = c.getString(c.getColumnIndex(KEY_AUTHOR));
                int price = c.getInt(c.getColumnIndex(KEY_PRICE));
                int quantity = c.getInt(c.getColumnIndex(KEY_QUANTITY));

                BookRequest book = new BookRequest(bname, author, esbn,  price, quantity);
                books.add(book);

            }while(c.moveToNext());
        }
        return books;

    }

    public long addOrder(OrdersR book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BNAME, book.name);
        values.put(KEY_AUTHOR, book.authorName);
        values.put(KEY_PRICE, book.price);
        values.put(KEY_QUANTITY, book.quantity);
        long valu = db.insert(TABLE_ORDERS, null, values);
        return valu;
    }

    public List<OrdersR> getAllOrders(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<OrdersR> books = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_ORDERS;

        Log.e("DB", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do{
                int esbn = c.getInt(c.getColumnIndex(KEY_ESBN));
                String bname = c.getString(c.getColumnIndex(KEY_BNAME));
                String author = c.getString(c.getColumnIndex(KEY_AUTHOR));
                int price = c.getInt(c.getColumnIndex(KEY_PRICE));
                int quantity = c.getInt(c.getColumnIndex(KEY_QUANTITY));

                OrdersR book = new OrdersR(bname, author, esbn,  price, quantity);
                books.add(book);

            }while(c.moveToNext());
        }
        return books;
    }

    // Login related getters and setters

    public long addLogin(LoginR login){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, login.username);
        values.put(KEY_PASSWORD, login.password);
        values.put(KEY_TYPE, login.type);

        long valu = db.insert(TABLE_LOGIN, null, values);
        return valu;

    }

    public LoginR getLogin(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "select * from " + TABLE_LOGIN + " where " + KEY_USERNAME + " = '" + username + "'";
        Log.e(TAG, "getLogin: "+select);
        Cursor c = db.rawQuery(select, null);
        if(c!=null && c.getCount()>0) {
            c.moveToFirst();
            int id = c.getInt(c.getColumnIndex(KEY_ID));
            String name = c.getString(c.getColumnIndex(KEY_USERNAME));
            String password = c.getString(c.getColumnIndex(KEY_PASSWORD));
            String type = c.getString(c.getColumnIndex(KEY_TYPE));
            LoginR login = new LoginR(name, password, type);
            login.id = id;
            return login;
        }
        else{
            return null;
        }
    }

    public long addSignup(SignupR signup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, signup.username);
        values.put(KEY_PASSWORD, signup.password);
        values.put(KEY_TYPE, signup.type);

        long valu = db.insert(TABLE_SIGNUP, null, values);

        return valu;
    }

    public List<SignupR> getSignups(){

        SQLiteDatabase db = this.getReadableDatabase();

        List<SignupR> signups = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_SIGNUP;

        Log.e("DB", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do{
                int id = c.getInt(c.getColumnIndex(KEY_ID));
                String name = c.getString(c.getColumnIndex(KEY_USERNAME));
                String password = c.getString(c.getColumnIndex(KEY_PASSWORD));
                String type = c.getString(c.getColumnIndex(KEY_TYPE));
                SignupR login = new SignupR(id, name, password, type);
                signups.add(login);
            }while(c.moveToNext());
        }
        return signups;
    }


}
