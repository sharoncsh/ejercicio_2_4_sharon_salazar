package com.example.ejercicio_2_4_sharon_salazar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ejercicio_2_4_sharon_salazar.transaccion.transaccion;

public class SQLiteConexion extends SQLiteOpenHelper {
    public SQLiteConexion(Context context, String bddname, SQLiteDatabase.CursorFactory factory, int version){
        super(context, bddname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(transaccion.CreateTableSignaturess);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(transaccion.DropTableSignaturess);
        onCreate(db);
    }
}