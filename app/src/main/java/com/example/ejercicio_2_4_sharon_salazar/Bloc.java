package com.example.ejercicio_2_4_sharon_salazar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Bloc extends View{
    float x, y;
    int opc;
    Paint paint = new Paint();
    Path path = new Path();
    Canvas canvas;

    public Bloc(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.WHITE);
    }

    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        canvas.drawColor(Color.BLACK);
        if (opc == 1) {
            path.moveTo(x, y);
        }
        if (opc == 2) {
            path.lineTo(x, y);
        }
        canvas.drawPath(path, paint);
    }


    public void limpiarBloc() {
        path.reset();
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event) {
        int accion = event.getAction();
        x = event.getX();
        y = event.getY();
        if (accion == MotionEvent.ACTION_DOWN) {
            opc = 1;
        }
        if (accion == MotionEvent.ACTION_MOVE) {
            opc = 2;
        }
        invalidate();
        return true;
    }
}

