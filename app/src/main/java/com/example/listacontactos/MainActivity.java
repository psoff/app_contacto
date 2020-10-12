package com.example.listacontactos;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.listacontactos.adaptador.ListAdapter;
import com.example.listacontactos.base_datos.Persona;
import com.example.listacontactos.base_datos.PersonaLab;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ListAdapter listItemAdapter;
    private ArrayList<Persona> listaNombres=new ArrayList<>();
    private ListView listView;
    private PersonaLab mPersonaLab;
    private Persona mPersona;
    private TextView guardar;
    private Button bguardar,blimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar);
        mPersonaLab=new PersonaLab(this);

        listView=(ListView) findViewById(R.id.list);
        guardar=(TextView) findViewById(R.id.editTextTextPersonName);
        bguardar=(Button) findViewById(R.id.buttonGuardar);
        blimpiar=(Button) findViewById(R.id.buttonLimpiar);
        bguardar.setOnClickListener(this);
        blimpiar.setOnClickListener(this);

        getAllPersonas();
        listItemAdapter=new ListAdapter(this,listaNombres);
        listView.setAdapter(listItemAdapter);


    }
    public void insertPersonas() {
        mPersona=new Persona();
        mPersona.setNombre(guardar.getText().toString());
        mPersonaLab.addPersona(mPersona);
        guardar.setText(" ");

    }
    // CONSULTA A LA BASE DE DATOS
    public void getAllPersonas(){
        listaNombres.clear();
        listaNombres.addAll(mPersonaLab.getPersonas());

    }

    // ACCION DE LOS BOTONES
    @Override
    public void onClick(View v) {
        if (v==blimpiar){
            mPersonaLab.deleteAllPersona();
            listaNombres.clear();
            listItemAdapter.notifyDataSetChanged();
        }
        if (v==bguardar){
            insertPersonas();
            getAllPersonas();
            listItemAdapter.notifyDataSetChanged();
        }
    }
    }
