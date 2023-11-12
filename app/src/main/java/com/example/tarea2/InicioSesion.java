package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {

    private EditText etUsuario, etPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        etUsuario = findViewById(R.id.et_Usuario);
        etPassword = findViewById(R.id.et_pass);
        progressBar = findViewById(R.id.pb_inicio);
    }
    public void Home2(View view){
        Intent hom2e= new Intent(this, MainActivity.class);
        startActivity(hom2e);

        finish();
    }

    public void IniciarSesion(View view) {
        String usuario = etUsuario.getText().toString();
        String password = etPassword.getText().toString();

        // Verificar los datos almacenados en SharedPreferences
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        String storedUsuario = preferences.getString("usuario", "");
        String storedPassword = preferences.getString("password", "");

        // Mostrar la ProgressBar al presionar el botón
        progressBar.setVisibility(View.VISIBLE);

        // Simular un retraso para mostrar la ProgressBar (puedes eliminar esto en un entorno de producción)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Verificar las credenciales
                if (usuario.equals(storedUsuario) && password.equals(storedPassword)) {
                    // Datos de inicio de sesión correctos, redirigir a Resultado
                    Intent intent = new Intent(InicioSesion.this, Resultado.class);
                    intent.putExtra("Usuario", usuario);
                    startActivity(intent);
                    finish();
                } else {
                    // Datos de inicio de sesión incorrectos, mostrar mensaje Toast
                    Toast.makeText(InicioSesion.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

                // Ocultar la ProgressBar después de verificar las credenciales
                progressBar.setVisibility(View.GONE);
            }
        }, 2000); // Simula un retraso de 2 segundos, puedes ajustar esto según tus necesidades
    }
}

