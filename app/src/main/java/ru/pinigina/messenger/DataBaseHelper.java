package ru.pinigina.messenger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Teacher on 25.02.2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataBaseHelper(Context context){
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Создание таблицы
        String sqlQuery = "CREATE TABLE users (\n" +
                "    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    username TEXT UNIQUE\n" +
                ")";
        sqLiteDatabase.execSQL(sqlQuery);

        //Заполнение таблицы
        String sql = "INSERT INTO users (_id, username) VALUES (1, 'MUM'), (2, 'DAD')";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<HashMap<String, String>> getUser(){
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        String sql = "SELECT _id, username FROM users";
        //no WHERE or WHERE exist=1
        Cursor cursor = readableDatabase.rawQuery(sql, null);
        //WHERE exist=?

//        Cursor cursor = readableDatabase.rawQuery(sql, new String[]{1});
//        cursor.moveToNext();

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
//            String lastName = cursor.getString(2);

            HashMap<String, String> acar = new HashMap<>();
            acar.put("_id", Integer.toString(id));
            acar.put("name", name);
//            acar.put("lastName", lastName);
            list.add(acar);
        }

    }

    public ArrayList<String> getListOfUsers(){
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        String sql = "SELECT username FROM users";
        //no WHERE or WHERE exist=1
        Cursor cursor = readableDatabase.rawQuery(sql, null);
        ArrayList<String> list = new ArrayList<>();
        while(cursor.moveToNext()) {
            String name = cursor.getString(0);
            list.add(name);
        }
        return list;
    }
}
