package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void Login(View view){
        Intent login= new Intent(this, InicioSesion.class);
        startActivity(login);
    }
    public void Register(View view){
        Intent regis= new Intent(this, Registro.class);
        startActivity(regis);
    }
}