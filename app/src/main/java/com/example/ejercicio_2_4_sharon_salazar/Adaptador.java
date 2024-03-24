package com.example.ejercicio_2_4_sharon_salazar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio_2_4_sharon_salazar.firmas.firmas;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.SignViewHolder> {

    private List<firmas> elementos;

    public Adaptador(List<firmas> elementos) {
        this.elementos = elementos;
    }

    @Override
    public SignViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.display, viewGroup, false);
        return new SignViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SignViewHolder viewHolder, int i) {
        Bitmap BMP = BitmapFactory.decodeByteArray(elementos.get(i).getDfirma(), 0,elementos.get(i).getDfirma().length);

        viewHolder.firma.setImageBitmap(BMP);
        viewHolder.descripcion.setText(elementos.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public static class SignViewHolder extends RecyclerView.ViewHolder {
        public ImageView firma;
        public TextView id, nombre, fecha, formato, bytes, descripcion;

        public SignViewHolder(View v) {
            super(v);
            firma = (ImageView) v.findViewById(R.id.firma);
            descripcion = (TextView) v.findViewById(R.id.descripcion);
        }
    }

}
