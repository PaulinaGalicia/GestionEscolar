
package com.example.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerAlumnoPorId(int id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        return alumnoOptional.orElse(null);
    }

    @SuppressWarnings("null")
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void borrarAlumnoPorId(int id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno actualizarAlumno(int id, Alumno alumnoActualizado) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        if (alumnoOptional.isPresent()) {
            Alumno alumnoExistente = alumnoOptional.get();
            alumnoExistente.setNombre(alumnoActualizado.getNombre());
            alumnoExistente.setApellido(alumnoActualizado.getApellido());
            alumnoExistente.setPromedio_general(alumnoActualizado.getPromedio_general());
            return alumnoRepository.save(alumnoExistente);
        } else {
            return null;
        }
    }
}
