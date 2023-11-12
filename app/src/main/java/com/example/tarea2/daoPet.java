package com.example.tarea2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoPet {

    SQLiteDatabase bd;
    ArrayList<Pet>lista = new ArrayList<Pet>();
    Pet c;
    Context ct;
    String nombreBD = "BDPet";

    String tabla = "create table if not exists pet(id integer primary key autoincrement, nombre text, edad text, animal text, telefonoDueño text, razon text)";

    public daoPet(Context c){
        this.ct=c;
        bd= c.openOrCreateDatabase(nombreBD, Context.MODE_PRIVATE, null);
        bd.execSQL(tabla);
    }

    public boolean insetar(Pet c){
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("edad", c.getEdad());
        contenedor.put("animal", c.getAnimal());
        contenedor.put("telefonoDueño", c.getTelefonoDueño());
        contenedor.put("razon", c.getRazon());
        return (bd.insert("pet", null, contenedor))>0;

    }
    public boolean eliminar(int id){

        return (bd.delete("pet", "id=" + id, null)) > 0;
    }
    public boolean editar(Pet c){
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("edad", c.getEdad());
        contenedor.put("animal", c.getAnimal());
        contenedor.put("telefonoDueño", c.getTelefonoDueño());
        contenedor.put("razon", c.getRazon());
        return (bd.update("pet", contenedor, "id=" + c.getId(), null)) > 0;
    }
    public ArrayList<Pet>verTodo(){
        lista.clear();
        Cursor cursor = bd.rawQuery("select * from pet", null);
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                lista.add(new Pet(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4),
                        cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return  lista;
    }
    public Pet verUno(int posicion){
        Cursor cursor = bd.rawQuery("select * from pet", null);
        cursor.moveToPosition(posicion);
        c= new Pet(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5));
        return c;
    }


}
