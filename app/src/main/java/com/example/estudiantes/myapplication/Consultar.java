package com.example.estudiantes.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class Consultar extends Fragment implements View.OnClickListener,OnMapReadyCallback {
    private static Object OnMapReadyCallback = null;
    private MapView miMapa;
private GoogleMap mMap;
private EditText miTexto;
private TextView miTexto2;
private Button miBoton;
private Double latitudmapa;
private Double longitudmapa;
private int salonmapa;

@Override
public void onResume() {
    super.onResume();
    miMapa.onResume();
}
    @Override
    public void onDestroy(){
    super.onDestroy();
    miMapa.onDestroy();
    }
    @Override
    public void onPause(){
        super.onPause();
        miMapa.onPause();
    }
    @Override

    public void onMapReady(GoogleMap map) {
        mMap = map;

    }

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
        miMapa=(MapView) vista3.findViewById(R.id.vermapa);
        miMapa.onCreate(savedInstanceState);
        miMapa.onResume();
        miMapa.getMapAsync(this);
        miMapa.onStart();
        return vista3;
    }


    @Override
    public void onClick(View v) {
         int cont=0;
        int misalon=Integer.parseInt(miTexto.getText().toString());
        List<Ubicacion> ubicacions = MainActivity.miDatabase.UbicacionDao().getSalon();
        String informacion="";
        for(Ubicacion ubicacion: ubicacions){
            if(ubicacion.getSalon()==misalon){
                int id=ubicacion.getId();
                int salon=ubicacion.getSalon();
                salonmapa=ubicacion.getSalon();
                String edificio= ubicacion.getEdificio();
                String sede=ubicacion.getSede();
                latitudmapa=ubicacion.getLatitud();

                longitudmapa=ubicacion.getLongitud();

              informacion=informacion+"\n\n"+"ID :"+id+"\n Salon :"+salon+"\n Edificio :"+edificio+"\n Sede :"+sede+"\n lon :"+longitudmapa+"\n lat :"+latitudmapa;
            }
        }
        miTexto2.setText(informacion);
        LatLng sydney = new LatLng(latitudmapa, -74.065492);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Salon : "+salonmapa));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));



    }

}