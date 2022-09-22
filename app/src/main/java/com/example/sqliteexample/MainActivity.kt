package com.example.sqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dh = DatabaseHelper(this)

        //insert işlemi
        Kitaplardao().kitapEkle(dh, "Yaşamak",205,25.00)
        Kitaplardao().kitapEkle(dh,"Rüzgarın şarkısını dinle",250,30.00)
        Kitaplardao().kitapEkle(dh,"Denemeler",350,19.00)

        //update işlemi
        Kitaplardao().kitapGuncelle(dh,1,"1989",300,20.00)

        //select-okuma işlemi
        val kitapListe = Kitaplardao().tumKitaplar(dh)
        for (k in kitapListe){
            Log.e("kitap_no",(k.kitap_no).toString())
            Log.e("kitap_ad",(k.kita_ad))
            Log.e("kitap_sayfa", (k.kitap_sayfa).toString())
            Log.e("kitap_fiyat", (k.kitap_fiyat).toString())
        }
        //delete işlemi
        Kitaplardao().kitapSil(dh,2)

        //arama
        //val kitapListe = Kitaplardao().kitapArama(dh, "a") for döngüsü ile kullan.

    }
}