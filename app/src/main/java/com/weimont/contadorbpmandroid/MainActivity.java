package com.weimont.contadorbpmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button vBtnTap;
    TextView vTvBpm;
    int bpm;
    int golpe = 0;
    long tInicial, tFinal, tTranscurrido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
        tInicial = 0;
        tInicial = 0;
        vTvBpm = findViewById(R.id.tvBpm);

        vTvBpm.setText(".");
        Log.i("Info", Integer.toString(golpe));
    }

    public void calcularBpm(){


        tTranscurrido = tFinal - tInicial;
        bpm = (int) (60 * golpe / tTranscurrido);
        // Log.i("Info", "SEGUNDOS -> " + Integer.toString((int) tTranscurrido));
        Log.i("Info", "BPM -> " + bpm);

        // Vincular tvBpm de layut con valor de java
        vTvBpm = findViewById(R.id.tvBpm);

        vTvBpm.setText(Integer.toString(bpm));
    }
}