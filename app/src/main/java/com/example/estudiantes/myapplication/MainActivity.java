package com.example.estudiantes.myapplication;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static DBUbicacion miDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miDatabase= Room.databaseBuilder(getApplicationContext(),DBUbicacion.class,"ubicaciondb").allowMainThreadQueries().build();
        FragmentManager miManejador;
        FragmentTransaction  miTransaccion;
        Insertar Cambiar;
        Inicio miMenu;

        miManejador=getSupportFragmentManager();
        miTransaccion=miManejador.beginTransaction();
        Cambiar=new Insertar();
        miMenu=new Inicio();
        miTransaccion.add(R.id.layoutFragmentos,miMenu);
        miTransaccion.commit();


    }
    public void Ingresar(View miVista){
        FragmentManager manejador;
        FragmentTransaction transaccion;
        Insertar fragmento1;
        manejador=getSupportFragmentManager();
        transaccion=manejador.beginTransaction();
        fragmento1=new Insertar();
        transaccion.replace(R.id.layoutFragmentos,fragmento1);
        transaccion.commit();
        Log.d("MyApp","I am here");
    }
    public void Consulta (View vista){
        FragmentManager miManejador;
        FragmentTransaction miTtransaccion;
        Consultar miConsulta;
        miManejador=getSupportFragmentManager();
        miTtransaccion=miManejador.beginTransaction();
        miConsulta= new Consultar();
        miTtransaccion.replace(R.id.layoutFragmentos,miConsulta);
        miTtransaccion.commit();
    }
    public void Lista(View miVista2){
        FragmentManager miManejador;
        FragmentTransaction miTtransaccion;
        lista miConsulta;
        miManejador=getSupportFragmentManager();
        miTtransaccion=miManejador.beginTransaction();
        miConsulta= new lista();
        miTtransaccion.replace(R.id.layoutFragmentos,miConsulta);
        miTtransaccion.commit();

    }
}


