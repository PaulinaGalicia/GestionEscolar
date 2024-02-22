package com.example.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expediente")
public class AlumnoConCalificacionesController {
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/{id_alumno}")
    public AlumnoConCalificacionesDTO obtenerAlumnoConCalificaciones(@PathVariable int id_alumno) {

        Alumno alumno = alumnoService.obtenerAlumnoPorId(id_alumno);
        if (alumno == null) {

            return null;
        }

        List<Calificaciones> calificaciones = calificacionService.obtenerCalificacionesPorId_alumno(id_alumno)
                .map(List::of)
                .orElse(null);

        return new AlumnoConCalificacionesDTO(alumno, calificaciones);
    }

}
