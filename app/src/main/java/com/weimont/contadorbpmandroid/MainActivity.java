package com.weimont.contadorbpmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button vBtnTap;
    int bpm;
    int golpe = 0;
    long tInicial, tFinal, tTranscurrido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // long mensaje = System.currentTimeMillis()/1000;

        // Log.i("Info", Long.toString(mensaje));



    }


    public void sumarGolpe(View vista){
        golpe = golpe + 1;
        Log.i("Info", Integer.toString(golpe));

        if(golpe == 1){
            tInicial = System.currentTimeMillis()/1000;
        } else{
            tFinal = System.currentTimeMillis()/1000;
            calcularBpm();
        }
    }

    public void resetearBpm(View vista){
        golpe = 0;
        Log.i("Info", Integer.toString(golpe));
    }

    public void calcularBpm(){
        tTranscurrido = tFinal - tInicial;
        bpm = (int) (60 * golpe / tTranscurrido);
        Log.i("Info", "SEGUNDOS -> " + Integer.toString((int) tTranscurrido));
        Log.i("Info", "BPM -> " + bpm);
    }
}