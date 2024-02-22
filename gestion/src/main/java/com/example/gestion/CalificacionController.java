package com.example.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public List<Calificaciones> obtenerTodasLasCalificaciones() {
        return calificacionService.obtenerTodasLasCalificaciones();
    }

    @GetMapping("/{id}")
    public Calificaciones obtenerCalificacionPorid(@PathVariable int id) {
        return (Calificaciones) calificacionService.obtenerCalificacionPorid(id);
    }

    @PostMapping
    public Calificaciones guardarCalificacion(@RequestBody Calificaciones calificaciones) {
        return calificacionService.guardarCalificacion(calificaciones);
    }

    @PutMapping("/update/{id}")
    public Calificaciones updateCalificacion(@PathVariable int id,
            @RequestBody Calificaciones calificacionActualizada) {
        return calificacionService.actualizarCalificacion(id, calificacionActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarCalificacion(@PathVariable int id) {
        calificacionService.eliminarCalificacion(id);
    }

}
