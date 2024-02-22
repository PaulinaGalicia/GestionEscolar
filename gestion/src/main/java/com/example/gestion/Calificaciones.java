package com.example.gestion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Calificaciones")
public class Calificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_calificacion;
    private int id_alumno;
    private int id_materia;
    private float calificacion;

    public int getIdCalificacion() {
        return id_calificacion;
    }

    public void setIdCalificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getIdMateria() {
        return id_materia;
    }

    public void setIdMateria(int id_materia) {
        this.id_materia = id_materia;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

}