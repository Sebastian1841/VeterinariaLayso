package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {
    private TextView et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        et3 = findViewById(R.id.txt_welcome);

        Intent intent = getIntent();
        if (intent != null) {
            String nombreUsuario = intent.getStringExtra("Usuario");
            et3.setText("Bienvenido: " + nombreUsuario);
        }
    }

    public void Agenda(View view){
        Intent agenda= new Intent(this, Agenda.class);
        startActivity(agenda);
    }
    public void Mapa(View view){
        Intent mapa= new Intent(this, Mapa.class);
        startActivity(mapa);
    }
    public void cerrarSesion(View view) {
        // Lógica para cerrar sesión (puedes implementar aquí la lógica que necesites)
        Toast.makeText(this, "Cerrar Sesión", Toast.LENGTH_SHORT).show();

        // Borrar los datos del registro en SharedPreferences
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("usuario");
        editor.remove("password");
        editor.apply();

        // Redirigir a la MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // Cierra la actividad actual
        finish();
    }
}