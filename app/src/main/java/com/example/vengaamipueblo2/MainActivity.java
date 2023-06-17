package com.example.vengaamipueblo2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //aqui vamos a poner los atributos=variables
    MediaPlayer cancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cancion=MediaPlayer.create(this,R.raw.sonido12);
        cancion.start();

        //temporizar el lanzamiento de la cancion
        TimerTask inicioAPP=new TimerTask() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,Home.class);
                startActivity(intent);



            }

        };

        Timer tiempo=new Timer();
        tiempo.schedule(inicioAPP,15000);




    }
}