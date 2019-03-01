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
import android.widget.Toast;


public class actualizar extends Fragment implements View.OnClickListener {
    private Button miBoton;
    private EditText salonid,nsalon,nedificio,nsede,nlongitud,nlatitud;
    public actualizar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View miVista= inflater.inflate(R.layout.fragment_actualizar, container, false);
        miBoton= miVista.findViewById(R.id.btnAct);
        salonid=miVista.findViewById(R.id.idtxt);
        nsalon=miVista.findViewById(R.id.salontxt);
        nedificio=miVista.findViewById(R.id.edificiotxt);
        nsede=miVista.findViewById(R.id.sedetxt);
        nlatitud=miVista.findViewById(R.id.latitudtxt);
        nlongitud=miVista.findViewById(R.id.longitudtxt);
        miBoton.setOnClickListener(this);


        return miVista;
    }


    @Override
    public void onClick(View v) {
        int id=Integer.parseInt(salonid.getText().toString());
        int salon=Integer.parseInt(nsalon.getText().toString());
        String edificio= nedificio.getText().toString();
        String sede= nsede.getText().toString();
        Double latitud= Double.parseDouble(nlatitud.getText().toString());
        Double longitud= Double.parseDouble(nlongitud.getText().toString());

        Ubicacion miUbicacion= new Ubicacion();
        miUbicacion.setId(id);
        miUbicacion.setSalon(salon);
        miUbicacion.setEdificio(edificio);
        miUbicacion.setSede(sede);
        miUbicacion.setLongitud(longitud);
        miUbicacion.setLatitud(latitud);

        MainActivity.miDatabase.UbicacionDao().actualizarUbicacion(miUbicacion);
        Toast.makeText(getActivity(),"Actualizado Correctamente",Toast.LENGTH_SHORT).show();
        salonid.setText("");
        nsalon.setText("");
        nedificio.setText("");
        nsede.setText("");
        nlongitud.setText("");
        nlatitud.setText("");
    }
}
