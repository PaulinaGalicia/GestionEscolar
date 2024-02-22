package com.example.gestion;

import java.util.List;

public class AlumnoConCalificacionesDTO {
    private Alumno alumno;
    private List<Calificaciones> calificaciones;

    public AlumnoConCalificacionesDTO() {
    }

    public AlumnoConCalificacionesDTO(Alumno alumno, List<Calificaciones> calificaciones) {
        this.alumno = alumno;
        this.calificaciones = calificaciones;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Calificaciones> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
