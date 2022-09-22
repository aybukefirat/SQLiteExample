package com.example.sqliteexample

import android.content.ContentValues

class Kitaplardao { //islemlerin yapılacağı sınıf

    fun kitapEkle (dh : DatabaseHelper,kitap_ad:String,kitap_sayfa:Int,kitap_fiyat:Double){

        val db = dh.writableDatabase
        val values = ContentValues()

        values.put("kitap_ad", kitap_ad)
        values.put("kitap_sayfa",kitap_sayfa)
        values.put("kitap_fiyat", kitap_fiyat)

        db.insertOrThrow("kitaplar", null, values)
        db.close()

    }

    fun tumKitaplar (dh : DatabaseHelper) : ArrayList<Kitaplar>{

        val kitaplarArrayList = ArrayList<Kitaplar>()
        val db = dh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kitaplar", null)

        while (cursor.moveToNext()){

            val kitap = Kitaplar(cursor.getInt(cursor.getColumnIndex("kitap_no"))
                ,cursor.getString(cursor.getColumnIndex("kitap_ad"))
                ,cursor.getInt(cursor.getColumnIndex("kitap_sayfa"))
                ,cursor.getDouble(cursor.getColumnIndex("kitap_fiyat")))

            kitaplarArrayList.add(kitap)
        }

        return kitaplarArrayList

    }

    fun kitapGuncelle (dh : DatabaseHelper,kitap_no:Int,kitap_ad:String,kitap_sayfa:Int,kitap_fiyat:Double){

        val db = dh.writableDatabase
        val values = ContentValues()

        values.put("kitap_ad", kitap_ad)
        values.put("kitap_sayfa",kitap_sayfa)
        values.put("kitap_fiyat", kitap_fiyat)

        //db.insertOrThrow("kitaplar", null, values)
        db.update("kitaplar",values, "kitap_no=?", arrayOf(kitap_no.toString()))
        db.close()

    }

    fun kitapSil(dh: DatabaseHelper, kitap_no: Int){

        val db = dh.writableDatabase
        db.delete("kitaplar","kitap_no=?", arrayOf(kitap_no.toString()))
        db.close()
    }

    fun kitapArama(dh:DatabaseHelper, keyWord:String) : ArrayList<Kitaplar>{

        val kitaplarArrayList = ArrayList<Kitaplar>()
        val db = dh.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM kitaplar WHERE kitap_ad like '%$keyWord%'",null)

        while (cursor.moveToNext()){

            val kitap = Kitaplar(cursor.getInt(cursor.getColumnIndex("kitap_no"))
                ,cursor.getString(cursor.getColumnIndex("kitap_ad"))
                ,cursor.getInt(cursor.getColumnIndex("kitap_sayfa"))
                ,cursor.getDouble(cursor.getColumnIndex("kitap_fiyat")))

            kitaplarArrayList.add(kitap)
        }

        return kitaplarArrayList
    }

}