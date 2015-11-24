package com.example.coby.ejemplojuego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by coby on 11/23/15.
 */
public class VistaJuego extends View implements SensorEventListener
{

    Grafico balon;
    private static int PERIODO_PROCESO = 30;

    private long ultimoProceso =0 ;

    protected void actualiza(int x,int y)
    {
        long tiempo = System.currentTimeMillis();
        if(ultimoProceso + PERIODO_PROCESO > tiempo)
            return;

        ultimoProceso = tiempo ;
        balon.setIncX(x);
        balon.setIncY(y);
        balon.incrementaPos();

    }

    public VistaJuego(Context context, AttributeSet atrrs)
    {
        super(context, atrrs);
        Drawable drawableBalon;
        drawableBalon = context.getResources().getDrawable(R.drawable.balon);
        balon = new Grafico(this,drawableBalon);

        //inicializar el sensor

        SensorManager sensorManager = (SensorManager)
                context.getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList
                (Sensor.TYPE_ACCELEROMETER);

        if(!listaSensores.isEmpty())
        {

            Sensor sensorAcelerometro = listaSensores.get(0);
            sensorManager.registerListener(this, sensorAcelerometro,
                    SensorManager.SENSOR_DELAY_GAME);
            Log.e("Mensaje","Se registro");

        }else
            Log.e("Error","No tenemos sensores en el telefono");


    }

    protected void onDraw(Canvas c)
    {
        super.onDraw(c);
        balon.dibujaGrafico(c);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int x = (int )event.values[1];
        int y = (int )event.values[0];
        //Log.e("Medicion", "Valor x: " + x + " Valor y: " + y);
        actualiza(x,y);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}



