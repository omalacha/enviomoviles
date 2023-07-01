package com.example.vengaamipueblo2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Home extends AppCompatActivity {

    //ZONA DE ATRIBUTOS
    Button botonHoteles;
    Button botonRestaurantes;
    Button botonSitiosTuristicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //estoy asociando los atributos de tipo boton a los id que pusimos en xml
        botonHoteles=findViewById(R.id.botonhoteles);
        botonRestaurantes=findViewById(R.id.botonrestaurantes);
        botonSitiosTuristicos=findViewById(R.id.botonturismo);
        //escuchando los eventos de click en el boton
        botonHoteles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //abrimos una nueva actividad desde el HOME

                Intent intent= new Intent(Home.this,Hoteles.class);
                startActivity(intent);
            }
        });

        botonRestaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent2=new Intent(Home.this,Restaurantes.class);
              startActivity(intent2);
            }
        });

        botonSitiosTuristicos.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(Home.this,Sitios.class);
                startActivity(intent3);
            }
        }));




    }

    //cargamos el menu de opciones

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //funcion para cargar el funcionamiento del menu
    public boolean onOptionsItemSelected(MenuItem item){
        //observar el comportamiento del usuario frente al menu
        int itemSeleccionado=item.getItemId();

        switch(itemSeleccionado){

                case (R.id.opcion1):
                    this.cambiarIdioma("es");
                    Intent intentespañol=new Intent(Home.this,Home.class);
                    startActivity(intentespañol);
                break;
                case (R.id.opcion2):
                this.cambiarIdioma("en");
                Intent intenteingles=new Intent(Home.this,Home.class);
                startActivity(intenteingles);
                break;
                case (R.id.opcion3):
                this.cambiarIdioma("pt");
                    Intent intentportugues=new Intent(Home.this,Home.class);
                    startActivity(intentportugues);
                break;
                case (R.id.opcion4):
                Toast.makeText(this, "accionaste op4", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //metodo para cambiar el idioma de la app

    public void cambiarIdioma(String idioma){

        //configurando el lenguaje del telefono
        Locale lenguaje=new Locale(idioma);
        Locale.setDefault(lenguaje);

        //configracion global en el telefono
        Configuration configuracionTelefono=getResources().getConfiguration();
        configuracionTelefono.locale=lenguaje;

        //ejecutamos la configuracion
        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());

    }
}