package com.example.estudiantes.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UbicacionDAO {
    @Insert
    public void insertUbicacion(Ubicacion miUbicacion);

    @Query("select * from salones" )
    public List<Ubicacion> getSalon();

}
