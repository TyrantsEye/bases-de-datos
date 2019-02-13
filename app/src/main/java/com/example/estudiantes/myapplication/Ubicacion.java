package com.example.estudiantes.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Ubicacion {
    @PrimaryKey
    private int id;
    private int salon;
    private String ubicacion;

    public int getId() {
        return id;
    }

    public int getSalon() {
        return salon;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
