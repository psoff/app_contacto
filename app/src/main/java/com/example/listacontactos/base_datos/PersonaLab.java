package com.example.listacontactos.base_datos;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

/*
 * LA SIGUIENTE CLASE UTILIZA LOS MÉTODOS DE LA INTERFACE PERSONA DAO
 * PARA PODER USARLOS EN LA CLASE MAIN
 *
 * */

public class PersonaLab {
    @SuppressLint("StaticFieldLeak")
    private static PersonaLab sPersonaLab;

    private PersonaDao mPersonaDao;

    public PersonaLab(Context context) {
        Context appContext = context.getApplicationContext();
        Personabd database = Room.databaseBuilder(appContext, Personabd.class, "persona")
                .allowMainThreadQueries().build();
        mPersonaDao = database.getPersonaDao();
    }

    public static PersonaLab get(Context context) {
        if (sPersonaLab == null) {
            sPersonaLab = new PersonaLab(context);
        }
        return sPersonaLab;
    }

    public List<Persona> getPersonas() {
        return mPersonaDao.getPersona();
    }

    public Persona getPersona(String id) {
        return mPersonaDao.getPersona(id);
    }

    public void addPersona(Persona persona) {
        mPersonaDao.addPersona(persona);
    }

    public void updatePersona(Persona persona) {
        mPersonaDao.updatePersona(persona);
    }

    public void deletePersona(Persona persona) {
        mPersonaDao.deletePersona(persona);
    }
    public void deleteAllPersona() {
        mPersonaDao.deleteAllPersona();
    }
}