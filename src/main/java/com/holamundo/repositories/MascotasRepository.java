package com.holamundo.repositories;

import com.holamundo.models.Mascota;
import java.util.List;

public interface MascotasRepository {
    //Regrese todas las mascotas
    public List<Mascota> findAll();
    //Regrese una mascota por id
    public Mascota getMascota(int id);
    //Agregar una mascota
    public void save(Mascota mascota);
    //Eliminar una mascotas
    public void delete(int id);
    //Actualizar una mascota
    public void update(Mascota mascota);
}
