package com.example.estudiantes.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Insertar extends Fragment implements View.OnClickListener {

    private Button miBoton;
    private EditText salon,sede,edificio,latitud,longitud;
    public Insertar() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_insertar, container, false);
            salon= (EditText) vista.findViewById(R.id.Salon) ;
            sede=(EditText) vista.findViewById(R.id.Sede);
            edificio=(EditText) vista.findViewById(R.id.Edificio);
            latitud=(EditText) vista.findViewById(R.id.Latitud);
           longitud=(EditText) vista.findViewById(R.id.Longitud);
            miBoton=(Button) vista.findViewById(R.id.btning);
            miBoton.setOnClickListener(this);



        return vista;
    }

    @Override
    public void onClick(View v) {
        int miSalon=Integer.parseInt(salon.getText().toString());
        String miSede=sede.getText().toString();
        String miEdificio=edificio.getText().toString();
        Double miLatitud=Double.parseDouble(latitud.getText().toString());
        Double miLongitud=Double.parseDouble(longitud.getText().toString());

        Ubicacion datos=new Ubicacion();
        datos.setSalon(miSalon);
        datos.setSede(miSede);
        datos.setEdificio(miEdificio);
        datos.setLatitud(miLatitud);
        datos.setLongitud(miLongitud);

        MainActivity.miDatabase.UbicacionDao().insertUbicacion(datos);
        Toast.makeText(getActivity(),"Se ingreso correctamente",Toast.LENGTH_SHORT).show();
    }
}

