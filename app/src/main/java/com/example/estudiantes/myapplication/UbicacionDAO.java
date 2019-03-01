package com.example.estudiantes.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UbicacionDAO {
    @Insert
    public void insertUbicacion(Ubicacion miUbicacion);

    @Query("select * from salones" )
    public List<Ubicacion> getSalon();

    @Delete
    public void deleteUbicacion(Ubicacion ubicacion);

    @Update
    public void actualizarUbicacion(Ubicacion ubicacion);

}
