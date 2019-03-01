package com.example.estudiantes.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class lista extends Fragment {
private TextView miTexto;


    public lista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_lista, container, false);
        miTexto=(TextView) vista.findViewById(R.id.informacion);
        List<Ubicacion> ubicacions = MainActivity.miDatabase.UbicacionDao().getSalon();
        String informacion="";
        for(Ubicacion ubicacion: ubicacions){
            int id=ubicacion.getId();
            int salon=ubicacion.getSalon();
            String edificio= ubicacion.getEdificio();
            String sede=ubicacion.getSede();
            Double latitud=ubicacion.getLatitud();
            Double longitud=ubicacion.getLongitud();

            informacion=informacion+"\n\n"+"ID :"+id+"\n Salon :"+salon+"\n Edificio :"+edificio+"\n Sede :"+sede+"\n Latitud: "+latitud+"\n Longitud :"+longitud;
        }
        miTexto.setText(informacion);

        return vista;
    }

}
