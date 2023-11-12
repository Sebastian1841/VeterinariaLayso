package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText etUsuario, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario = findViewById(R.id.et_UsuarioIncioRegiter);
        etPassword = findViewById(R.id.et_passInicioRegiter);

        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        etUsuario.setText(preferences.getString("usuario", ""));
        etPassword.setText(preferences.getString("password", ""));
    }

    public void Guardar(View view) {
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario", etUsuario.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.apply();

        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();

        finish();
    }
    public void Home(View view){
        Intent home= new Intent(this, MainActivity.class);
        startActivity(home);

        finish();
    }
}