package com.example.anandhusubash.kbus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ViewAnimationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 07/02/2018.
 * Class for handling database operations
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static String DATABASE_NAME     = "bus";
    private static int DATABASE_VERSION     = 1;
    private String TABLE_USER       = "data";

    /**
     * Constructor
     * @param context context
     */
    DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * onCreate method
     * creating table with necessary data
     * @param database instance of database
     */
    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_USER_TABLE = "CREATE TABLE "+TABLE_USER+"(id TEXT,time TEXT,bus TEXT,dest TEXT,number TEXT,via TEXT)";
        database.execSQL(CREATE_USER_TABLE);
    }

    /**
     *
     * @param database database
     * @param oldVersion old version number
     * @param newVersion new version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXIST "+TABLE_USER);
        onCreate(database);
    }
    public Cursor getDetails(String desti)
    {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_USER+" WHERE dest='"+desti+"' OR via='"+desti+"'", null);
    }
    List<Matcheslistoffline> selectall(String desti){
            List<Matcheslistoffline> contactList = new ArrayList<>();
            // Select All Query
        String selectQuery = "SELECT * FROM "+TABLE_USER+" WHERE dest='"+desti+"' OR via='"+desti+"'";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Matcheslistoffline items=new Matcheslistoffline();
                    items.setId(cursor.getString(0));
                    items.setTime(cursor.getString(1));
                    items.setBus(cursor.getString(2));
                    items.setDestination(cursor.getString(3));
                    items.setNumber(cursor.getString(4));
                    items.setVia(cursor.getString(5));
                    contactList.add(items);
                   /* contactList.add(cursor.getString(0));
                    contactList.add(cursor.getString(1));
                    contactList.add(cursor.getString(2));
                    contactList.add(cursor.getString(3));
                    contactList.add(cursor.getString(4));
                    contactList.add(cursor.getString(5));*/
                } while (cursor.moveToNext());
            }

            // return contact list
            return contactList;
    }

    void insertdata(String id,String time,String bus,String dest,String number,String via){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values    = new ContentValues();
        values.put("id", id);
        values.put("time", time);
        values.put("bus", bus);
        values.put("dest", dest);
        values.put("number", number);
        values.put("via", via);
        database.insert(TABLE_USER, null, values);
        database.close();
    }

    void deletenamedata(String name){
       SQLiteDatabase db=this.getReadableDatabase();
        db.delete(TABLE_USER,"name='"+name+"'",null);
        db.close();
    }

    void updatenamedata(String name,String updatename){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",updatename);
        db.update(TABLE_USER,values,"name='"+name+"'",null);
        //db.update(TABLE_USER, values, "name = ?",new String[] { name });
        db.close();
    }

}
