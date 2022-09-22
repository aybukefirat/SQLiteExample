package com.example.sqliteexample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context : Context) : SQLiteOpenHelper(context, "helper", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE kitaplar (kitap_no INTEGER PRIMARY KEY AUTOINCREMENT, kitap_ad TEXT" +
                ", kitap_sayfa INTEGER, kitap_fiyat DOUBLE); ")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL("DROP TABLE IF EXISTS kitaplar")
        onCreate(db)


    }
}