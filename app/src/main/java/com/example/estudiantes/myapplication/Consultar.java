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

public class Consultar extends Fragment implements View.OnClickListener {

private TextView miTexto2;
private Button miBoton;
    public Consultar() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista3=inflater.inflate(R.layout.fragment_consultar, container, false);
        miBoton=(Button)  vista3.findViewById(R.id.btnConsultar);
        miBoton.setOnClickListener(this);
        miTexto2=(TextView) vista3.findViewById(R.id.mostrarsalon);
                return vista3;

    }


    @Override
    public void onClick(View v) {
        miTexto2.setText("Aqui pondria la Informacion");
    }
}