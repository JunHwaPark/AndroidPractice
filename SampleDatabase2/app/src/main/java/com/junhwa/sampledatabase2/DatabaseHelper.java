package com.junhwa.sampledatabase2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        println("onCreate 호출됨");

        String sql = "CREATE TABLE IF NOT EXISTS EMP("
                + "_id integer primary key autoincrement, "
                + "name text, "
                + "age integer, "
                + "mobile text)";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        println("onOpen 호출됨");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        println("onUpgrade 호출됨 : " + i + " -> " + i1);
        if (i1 > 1)
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS EMP");
    }

    public void println(String data) {
        Log.d("DatabaseHelper", data);
    }
}
