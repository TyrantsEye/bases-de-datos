package com.example.estudiantes.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Consultar extends Fragment {

    public Consultar() {
        // Required empty public constructor
    }
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   return inflater.inflate(R.layout.fragment_consultar, container, false);

    }


}
