/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cktv
 */

@Entity
@Table (name="Grupo")
public class Grupo {
    @Id
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "docenteId"/* , updatable = false */)
    @JsonIgnoreProperties(value = "grupos")
    private Docente docente;
    
    @ManyToMany(mappedBy = "grupos")
    @JsonIgnore
    //@JsonIgnoreProperties(value="ods")
    private List<Estudiante> estudiantes;

    public Grupo() {
    }

    public Grupo(Integer id, Docente docente, List<Estudiante> estudiantes) {
        this.id = id;
        this.docente = docente;
        this.estudiantes = estudiantes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
    
    
}
