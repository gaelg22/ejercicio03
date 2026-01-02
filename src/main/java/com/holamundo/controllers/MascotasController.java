package com.holamundo.controllers;

import com.holamundo.models.Mascota;
import com.holamundo.services.MascotasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MascotasController {
    //Mostrar el listado
    MascotasService mascotaService = new MascotasService();
    @GetMapping("/mascotas")
    public String mascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.findAll());
        return "mascotas-listado";
    }

    //Guardar una mascota
    @GetMapping("/mascotas/agregar")
    //1. Mostar el formulario
    public String nuevaMascotaFormulario(Model model) {
        Mascota mascota = new Mascota();
        model.addAttribute("mascota", mascota);
        return "mascotas-agregar";
    }

    //2. Guardar la mascota y redireccionar al listado
    @PostMapping("/mascotas/agregar")
    public String nuevaMascotaAgregar(@ModelAttribute("mascota") Mascota mascota)
    {
        mascotaService.save(mascota);
        return "redirect:/mascotas";
    }

    //Eliminar una mascota
    // 1. Mostrar mascota en el formulario
    @GetMapping("/mascotas/eliminar/{id}")
    public String eliminarMascotaFormulario(@PathVariable int id, Model model)
    {
        Mascota mascota = mascotaService.getMascota(id);
        if (mascota != null)
        {
            model.addAttribute("mascota", mascota);
            return "mascotas-eliminar";
        }
        else
            return "mascotas-eliminar";
    }
    // 2. Eliminar la mascota y redireccionar al listado
    @PostMapping("/mascotas/eliminar")
    public String eliminarMascota(@ModelAttribute("mascota") Mascota mascota)
    {
        System.out.println("eliminando mascota: " + mascota.getId());
        mascotaService.delete(mascota.getId());
        return "redirect:/mascotas";
    }

    //Actualizar una mascota
    //1. Mostrar el formulario para actualizar
    @GetMapping("/mascotas/actualizar/{id}")
    public String actualiarMasccotaFormulario(@PathVariable int id, Model model)
    {
        Mascota mascota = mascotaService.getMascota(id);
        if (mascota != null)
        {
            model.addAttribute("mascota", mascota);
            return "mascotas-actualizar";
        }
        else return "redirect:/mascotas";

    }
    //2. Actualizar y redireccionar al listado
    @PostMapping("/mascotas/actualizar")
    public String actualizarMascota(@ModelAttribute("mascota") Mascota mascota)
    {
        mascotaService.update(mascota);
        return "redirect:/mascotas";
    }
}
