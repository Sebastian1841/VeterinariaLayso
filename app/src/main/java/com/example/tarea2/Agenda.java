package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Agenda extends AppCompatActivity {

    daoPet dao;
    Adaptador adapter;
    ArrayList<Pet> lista;
    Pet c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        dao= new daoPet(Agenda.this);
        lista=dao.verTodo();
        adapter= new Adaptador(lista, dao, this);
        ListView list = findViewById(R.id.lista);
        Button insertar = findViewById(R.id.btn_insertar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Agenda.this);
                dialog.setTitle("Nuevo Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText nombre = dialog.findViewById(R.id.nombre);
                final EditText edad = dialog.findViewById(R.id.edad);
                final EditText animal = dialog.findViewById(R.id.animal);
                final EditText telefonoDueño = dialog.findViewById(R.id.telefonoDueño);
                final EditText razon = dialog.findViewById(R.id.razon);
                Button guardar = dialog.findViewById(R.id.btn_agregar);
                guardar.setText("Agregar");
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            c= new Pet(nombre.getText().toString(),
                                    edad.getText().toString(),
                                    animal.getText().toString(),
                                    telefonoDueño.getText().toString(),
                                    razon.getText().toString());
                            dao.insetar(c);
                            lista=dao.verTodo();
                            adapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(), "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    public void Menu(View view){
        Intent menuIntent = new Intent(this, Resultado.class);

        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        String nombreUsuario = preferences.getString("usuario", "");
        menuIntent.putExtra("Usuario", nombreUsuario);
        startActivity(menuIntent);
    }
}