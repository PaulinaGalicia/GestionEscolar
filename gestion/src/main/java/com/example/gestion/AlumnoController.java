package com.example.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoService.obtenerTodosLosAlumnos();
    }

    @GetMapping("/{id}")
    public Alumno obtenerAlumnoPorId(@PathVariable int id) {
        return alumnoService.obtenerAlumnoPorId(id);
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.guardarAlumno(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumnoActualizado) {
        return alumnoService.actualizarAlumno(id, alumnoActualizado);
    }

    @DeleteMapping("/{id}")
    public void borrarAlumnoPorId(@PathVariable int id) {
        alumnoService.borrarAlumnoPorId(id);
    }
}
