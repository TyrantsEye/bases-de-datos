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

public class borrar extends Fragment implements View.OnClickListener {
    private Button miBoton;
    private EditText miTexto;

    public borrar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_borrar, container, false);
        miBoton= vista.findViewById(R.id.btnBorrar);
        miTexto=vista.findViewById(R.id.borrarU);
        miBoton.setOnClickListener(this);



        return vista;
    }

    @Override
    public void onClick(View v) {
        int id=Integer.parseInt(miTexto.getText().toString());
        Ubicacion miUbicacion= new Ubicacion();
        miUbicacion.setId(id);
        MainActivity.miDatabase.UbicacionDao().deleteUbicacion(miUbicacion);
        Toast.makeText(getActivity(),"Eliminado Satisfactoriamente.. ",Toast.LENGTH_SHORT).show();
        miTexto.setText("");
    }
}
