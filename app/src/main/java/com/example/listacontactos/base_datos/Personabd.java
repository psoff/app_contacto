package com.example.listacontactos.base_datos;
import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {Persona.class},version = 1)
    public abstract class Personabd extends RoomDatabase {

        public abstract PersonaDao getPersonaDao();

    }


