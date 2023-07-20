package com.example.mobileprogproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "database.db", null, 1);
        //memanggil function databasehelper
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orderdetail(name TEXT primary key, price TEXT)");
        //membuat database
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists orderdetail" );
        //untuk perubahan atau nambahin table / kolom
    }

    public Boolean insertdata( String name, String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("price",price);
        long result =  db.insert("orderdetail",null,contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
        //insert data kedalam database
    }

    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * From Orderdetail",null);
        return cursor;
        //mengambil data dari database
    }

    public Boolean updatedata(String name, String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("price",price);
        Cursor cursor = db.rawQuery("Select * from orderdetail where name = ?", new String[] {name});
        if (cursor.getCount() > 0) {
            long result = db.update("orderdetail", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
        //untuk mengupdate data yang sudah ada
    }

    public boolean deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete("orderdetail", null, null);
        return result > 0;
        //untuk menghapus semua data dari tabel
    }
}
