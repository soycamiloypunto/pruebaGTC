/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cktv
 */

@Entity
@Table (name="Asignatura")
public class Asignatura implements Serializable{
    @Id
    private Integer id;
    
    @Column(length = 512)
    private String nombre;
    
    //muchas asignaturas un estudiante
    @ManyToOne
    @JoinColumn(name = "docenteId"/* , updatable = false */)
    @JsonIgnoreProperties(value = "asignaturas")
    private Docente docente;
    
    @ManyToOne
    @JoinColumn(name = "estudianteId"/* , updatable = false */)
    @JsonIgnoreProperties(value = "asignaturas")
    private Estudiante estudiante;

    public Asignatura() {
    }

    public Asignatura(Integer id, String nombre, Docente docente, Estudiante estudiante) {
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
        this.estudiante = estudiante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
    
}
