package com.example.ejercicio_2_4_sharon_salazar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.ejercicio_2_4_sharon_salazar.firmas.firmas;
import com.example.ejercicio_2_4_sharon_salazar.transaccion.transaccion;

public class Firmas_Lista extends AppCompatActivity {

    RecyclerView recycler;

    ArrayList<firmas> lista;
    List<firmas> elementos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_firma);
        lista = new ArrayList<>();

        GetListGallery();

        recycler = (RecyclerView) findViewById(R.id.reciclador);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        Adaptador adapter = new Adaptador(elementos);
        recycler.setAdapter(adapter);
    }

    private void GetListGallery() {
        SQLiteConexion conexion = new SQLiteConexion(this, transaccion.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        firmas elementos = null;
        lista = new ArrayList<firmas>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + transaccion.tabla_signaturess, null);

        while (cursor.moveToNext()) {
            elementos = new firmas();
            elementos.setId(cursor.getInt(0));
            elementos.setDfirma(cursor.getBlob(1));
            elementos.setDescripcion(cursor.getString(2));

            lista.add(elementos);
        }

        cursor.close();
        Coleccion();
    }

    private void Coleccion() {

        elementos = new ArrayList<>();

        for (int i = 0;  i < lista.size(); i++){

            elementos.add(new firmas(
                    lista.get(i).getId(),
                    lista.get(i).getDfirma(),
                    lista.get(i).getDescripcion()));
        }
    }
}
