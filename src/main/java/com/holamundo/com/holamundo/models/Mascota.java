package com.holamundo.com.holamundo.models;

public class Mascota {
    private int id;
    private String nombre;
    private int edad;
    private String observaciones;

    public Mascota(int id, String nombre, int edad, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.observaciones = observaciones;
    }

    public Mascota() {

    }

    public void setId(int id) { this.id = id; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setEdad(int edad) { this.edad = edad; }

    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public int getEdad() { return edad; }

    public String getObservaciones() { return observaciones; }
}
