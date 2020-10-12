package com.example.listacontactos.base_datos;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;

import java.util.List;
/*
 * LA SIGUIENTE INTERFACE ES DONDE SE IMPLEMENTA LAS SETENCIA DE ROOM'
 * PARA MANIPULAR LA BASE DE DATOS
 * COMO LAS CONSULTAS, EL INSERTAR, EL BORRAR
 *
 * */
@Dao
public interface PersonaDao {

    @Query("SELECT * FROM persona")
    public abstract List<Persona> getPersona();

    @Query("SELECT * FROM persona WHERE id LIKE :uuid")
    public abstract Persona getPersona(String uuid);

    @Insert
    public abstract void addPersona(Persona p);

    @Delete
    public abstract void deletePersona(Persona p);

    @Update
    public abstract void updatePersona(Persona p);

    @Query("DELETE FROM persona")
    public abstract void deleteAllPersona();

}