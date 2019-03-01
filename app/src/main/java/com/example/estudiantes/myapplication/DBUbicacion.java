package com.example.estudiantes.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
@Database(entities = Ubicacion.class,version = 1)
public abstract class DBUbicacion extends RoomDatabase {

    public abstract UbicacionDAO UbicacionDao();
}
