package com.example.tarea2;

public class Pet {

    int id;
    String nombre;
    String edad;
    String animal;
    String telefonoDueño;
    String razon;


    public Pet(){

    }

    public Pet(String nombre, String edad, String animal, String telefonoDueño, String razon) {
        this.nombre = nombre;
        this.edad = edad;
        this.animal = animal;
        this.telefonoDueño = telefonoDueño;
        this.razon = razon;
    }

    public Pet(int id, String nombre, String edad, String animal, String telefonoDueño, String razon) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.animal = animal;
        this.telefonoDueño = telefonoDueño;
        this.razon = razon;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getAnimal() {
        return animal;
    }

    public String getTelefonoDueño() {
        return telefonoDueño;
    }

    public String getRazon() {
        return razon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setTelefonoDueño(String telefonoDueño) {
        this.telefonoDueño = telefonoDueño;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
