package com.sugiartha.juniorandroid.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class UserHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;

    static final String DATABASE_NAME = "digitaltalent.db";

    public static final String TABLE_USER = "testuser01";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FULLNAME = "fullname";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_GENDER = "gender";

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FULLNAME + " TEXT NOT NULL, " +
                COLUMN_USERNAME + " TEXT NOT NULL UNIQUE, " +
                COLUMN_PASSWORD + " TEXT NOT NULL, " +
                COLUMN_EMAIL + " TEXT NOT NULL, " +
                COLUMN_GENDER + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllUserData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_FULLNAME, cursor.getString(1));
                map.put(COLUMN_USERNAME, cursor.getString(2));
                map.put(COLUMN_PASSWORD, cursor.getString(3));
                map.put(COLUMN_EMAIL, cursor.getString(4));
                map.put(COLUMN_GENDER, cursor.getString(5));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        Log.e("select sqlite ", "" + wordList);

        database.close();
        return wordList;
    }
    public void insert(String fullname,String username, String password, String email, String gender) {
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO " + TABLE_USER + " (fullname, username, password, email, gender) " +
                "VALUES ('" + fullname + "', '" + username + "', '" +
                password + "', '" + email + "', '" + gender + "')";

        Log.e("insert sqlite ", "" + queryValues);
        database.execSQL(queryValues);
        database.close();
    }

    public boolean matchingUser(String username, String password){
        SQLiteDatabase database = this.getReadableDatabase();
        String queryValues = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = '" + username + "' "+
                " AND " + COLUMN_PASSWORD + " = '" + password + "'";
        Cursor cursor = database.rawQuery(queryValues, null);
        if(cursor.moveToFirst()){
            Log.e("TAG", "user tersedia");
            return true;
        }if (cursor != null){
            cursor.close();
        }
        database.close();
        return false;
    }

    public boolean checkUsername(String username){
        SQLiteDatabase database = this.getReadableDatabase();
        String queryValues = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = '" + username + "' ";
        Cursor cursor = database.rawQuery(queryValues, null);
        if(cursor.moveToFirst()){
            Log.e("TAG", "user tersedia");
            return true;
        }if (cursor != null){
            cursor.close();
        }
        database.close();
        return false;
    }

    public boolean checkEmail(String email){
        SQLiteDatabase database = this.getReadableDatabase();
        String queryValues = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_EMAIL + " = '" + email + "' ";
        Cursor cursor = database.rawQuery(queryValues, null);
        if(cursor.moveToFirst()){
            Log.e("TAG", "user tersedia");
            return true;
        }if (cursor != null){
            cursor.close();
        }
        database.close();
        return false;
    }

    public void dropTable(SQLiteDatabase db){
        String[] tableNames = {
                TABLE_USER,
        };

        for (String tableName : tableNames) {
            String dropTableQuery = "DROP TABLE IF EXISTS " + tableName;
            db.execSQL(dropTableQuery);
        }

        onCreate(db);
    }
}
