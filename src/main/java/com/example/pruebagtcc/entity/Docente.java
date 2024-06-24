/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.entity;

/**
 *
 * @author cktv
 */
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
@Table (name="Docente")
public class Docente {
    
    @Column(length = 512)
    private String tipoDocumento;
    
    @Id
    @Column
    private Long id;
    
    @Column(length = 1024)
    private String nombres;
    
    @Column(length = 1024)
    private String apellidos;
    
    @Column(length = 1024)
    private Date fechaNacimiento;
    
    @Column(length = 512)
    private String gradoEscolaridad;
    
    @Column(length = 512)
    private String email;
    
    @Column
    private Long telefonoFijo;
    
    @Column
    private Long celular;
    
    //Un docente muchas asignaturas
    @OneToMany(cascade ={CascadeType.ALL}, mappedBy = "docente")
    @JsonBackReference
    private List<Asignatura> asignaturas;
    
    //Un docente varios grupos
    @OneToMany(cascade ={CascadeType.ALL}, mappedBy = "docente")
    @JsonBackReference
    private List<Grupo> grupos;
    
    
    public Docente() {
    }

    public Docente(String tipoDocumento, Long id, String nombres, String apellidos, Date fechaNacimiento, String gradoEscolaridad, String gradoResponsable, String email, Long telefonoFijo, Long celular, List<Asignatura> asignaturas, List<Grupo> grupos) {
        this.tipoDocumento = tipoDocumento;
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.gradoEscolaridad = gradoEscolaridad;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
        this.asignaturas = asignaturas;
        this.grupos = grupos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGradoEscolaridad() {
        return gradoEscolaridad;
    }

    public void setGradoEscolaridad(String gradoEscolaridad) {
        this.gradoEscolaridad = gradoEscolaridad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(Long telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    
    
}
