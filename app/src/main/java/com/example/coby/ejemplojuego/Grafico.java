package com.example.coby.ejemplojuego;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

/**
 * Created by coby on 11/23/15.
 */
public class Grafico {

    private Drawable drawable;
    private double posX, posY;
    private double incX, incY;
    private int ancho, alto;

    private View view;
    public static final int MAX_VELOCIDAD=40;

    public Grafico(View view, Drawable drawable)
    {
        this.view = view;
        this.drawable = drawable;
        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();
    }

    public void dibujaGrafico(Canvas canvas){

        canvas.save();
        int x=(int) (posX+ancho/2);
        int y=(int) (posY+alto/2);
        drawable.setBounds((int)posX, (int)posY,
                (int)posX+ancho, (int)posY+alto);
        drawable.draw(canvas);
        canvas.restore();
        int rInval = (int) Math.hypot(ancho,alto)/2 + MAX_VELOCIDAD;
        view.invalidate(x-rInval, y-rInval, x+rInval, y+rInval);
    }

    public void incrementaPos(){
        posX+=incX;
        posY+=incY;
        Log.e("Posición","POS X : " + posX + " POS Y: " + posY);

    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(double incX) {
        this.incX = incX;
    }

    public double getIncY() {
        return incY;
    }

    public void setIncY(double incY) {
        this.incY = incY;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}

