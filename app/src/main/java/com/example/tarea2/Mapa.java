package com.example.tarea2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng Chile = new LatLng(-35.675147, -71.542969);
        mMap.addMarker(new MarkerOptions().position(Chile).title("Veterinaria Layso"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chile));
    }
    public void Result(View view){
        Intent resultIntent = new Intent(this, Resultado.class);

        // Obtener el nombre de usuario de SharedPreferences o de donde sea que lo estés almacenando
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        String nombreUsuario = preferences.getString("usuario", "");

        // Pasar el nombre de usuario como extra al Intent
        resultIntent.putExtra("Usuario", nombreUsuario);

        // Iniciar la actividad Resultado con el nombre de usuario
        startActivity(resultIntent);
    }
}