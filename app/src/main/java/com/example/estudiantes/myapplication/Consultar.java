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

import java.util.List;

public class Consultar extends Fragment implements View.OnClickListener {
private EditText miTexto;
private TextView miTexto2;
private Button miBoton;
    public Consultar() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista3=inflater.inflate(R.layout.fragment_consultar, container, false);

        miTexto=(EditText) vista3.findViewById(R.id.saled);
        miTexto2=(TextView) vista3.findViewById(R.id.mostrar);


        miBoton=(Button)  vista3.findViewById(R.id.btnConsultar);
        miBoton.setOnClickListener(this);
        return vista3;
    }


    @Override
    public void onClick(View v) {
        int misalon=Integer.parseInt(miTexto.getText().toString());
        List<Ubicacion> ubicacions = MainActivity.miDatabase.UbicacionDao().getSalon();
        String informacion="";
        for(Ubicacion ubicacion: ubicacions){
            if(ubicacion.getSalon()==misalon){
                int id=ubicacion.getId();
                int salon=ubicacion.getSalon();
                String edificio= ubicacion.getEdificio();
                String sede=ubicacion.getSede();
                Double latitud=ubicacion.getLatitud();
                Double longitud=ubicacion.getLongitud();

                informacion=informacion+"\n\n"+"ID :"+id+"\n Salon :"+salon+"\n Edificio :"+edificio+"\n Sede :"+sede+"\n Latitud: "+latitud+"\n Longitud :"+longitud;
            }
        }
        miTexto2.setText(informacion);
    }
}