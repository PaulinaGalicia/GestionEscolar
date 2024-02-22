package com.example.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
//import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Calificaciones> obtenerTodasLasCalificaciones() {
        return calificacionRepository.findAll();
    }

    public List<Calificaciones> obtenerCalificacionPorid(int id_alumno) {
        Optional<Calificaciones> calificaciones = calificacionRepository.findById(id_alumno);
        return (List<Calificaciones>) calificaciones.orElse(null);
    }

    public Calificaciones guardarCalificacion(Calificaciones calificaciones) {
        return calificacionRepository.save(calificaciones);
    }

    public void eliminarCalificacion(int calificacion) {
        calificacionRepository.deleteById(calificacion);
    }

    public Calificaciones actualizarCalificacion(int id, Calificaciones calificacionActualizada) {
        Optional<Calificaciones> calificacionOptional = calificacionRepository.findById(id);
        if (calificacionOptional.isPresent()) {
            Calificaciones calificacionExistente = calificacionOptional.get();
            calificacionExistente.setCalificacion(calificacionActualizada.getCalificacion());
            return calificacionRepository.save(calificacionExistente);
        } else {
            return null;
        }
    }

    public Optional<Calificaciones> obtenerCalificacionesPorId_alumno(int id_alumno) {

        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id_alumno);

        if (alumnoOptional.isPresent()) {
            return calificacionRepository.findById(id_alumno);
        } else {
            throw new NoSuchElementException("No se encontró ningún alumno con el ID proporcionado: "
                    + id_alumno);
        }
    }

}
