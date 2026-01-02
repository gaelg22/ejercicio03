package com.holamundo.services;

//Extends - Herencia - Heredar las propiedades de otra clase
//Implementsn - Usar o implementar los metodos de otra case

import com.holamundo.models.Mascota;
import com.holamundo.repositories.MascotasRepository;


import java.util.ArrayList;
import java.util.List;

public class MascotasService implements MascotasRepository{
    //Requerimos
    //1. acceso a una base de datos - Aun no
    //2. Acceso a un listado en memoria

    private List<Mascota> mascotas;
    private int lastId = 0;

    public MascotasService()
    {

        //Evitar en NULL pointer excpetion
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(1, "Pluto", 5, "Mascota Nick"));
        mascotas.add(new Mascota(2, "Firulais", 5, "Un perro muy amable"));
        lastId = 3;;
    }

    //Investigar programación funcional para agregar, eliminar y actualizar mascota

    @Override
    public List<Mascota> findAll() {
        return mascotas;
    }

    @Override
    public Mascota getMascota(int id) {

        return mascotas.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Mascota mascota) {
        lastId++;
        mascota.setId(mascotas.size()+1);
        mascotas.add(mascota);
    }

    @Override
    public void delete(int id) {
        mascotas.removeIf(m -> m.getId() == id);
    }

    @Override
    public void update(Mascota mascota) {
        //Es por referencia
        Mascota m = getMascota(mascota.getId());
        m.setNombre(mascota.getNombre());
        m.setEdad(mascota.getEdad());
        m.setObservaciones(mascota.getObservaciones());

    }
}
