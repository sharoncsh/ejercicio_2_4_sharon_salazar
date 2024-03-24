package com.example.ejercicio_2_4_sharon_salazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_2_4_sharon_salazar.transaccion.transaccion;

import java.io.ByteArrayOutputStream;

public class Captura_Firma extends AppCompatActivity {

    EditText descripcion;
    Button btnguardar, btnlista;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firma_captura);

        descripcion = (EditText) findViewById(R.id.txtdescripcion);
        view = (View) findViewById(R.id.viewfirma);

        btnguardar = (Button)findViewById(R.id.btnguardar);
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarfirma();
            }
        });

        btnlista = (Button)findViewById(R.id.btnlista);
        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Firmas_Lista.class);
                startActivity(intent);
            }
        });
    }

    public void salvarfirma() {
        SQLiteConexion conexion = new SQLiteConexion(this, transaccion.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        try {
            String descripcionText = descripcion.getText().toString();

            if (descripcionText.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Ingrese una descripción antes de Guardar", Toast.LENGTH_LONG).show();
                return;
            }

            ContentValues valores = new ContentValues();

            valores.put(transaccion.dfirma, Viewfirma(view));
            valores.put(transaccion.descripcion, descripcionText);

            Long resultado = db.insert(transaccion.tabla_signaturess, transaccion.id, valores);

            Toast.makeText(getApplicationContext(), "Registro Exitoso " + resultado.toString(), Toast.LENGTH_LONG).show();
            descripcion.setText("");
            view.setDrawingCacheEnabled(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static byte[]  Viewfirma(View view5) {
        view5.setDrawingCacheEnabled(true);
        Bitmap bitmap = view5.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }

    private void ClearScreen() {
        descripcion.setText("");
        view.setDrawingCacheEnabled(false);
    }
}
