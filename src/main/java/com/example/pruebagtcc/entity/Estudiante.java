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
@Table (name="Estudiante")
public class Estudiante {
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
    private String ciudadResidencia;
    
    @Column(length = 512)
    private String direccionResidencia;
    
    @Column(length = 512)
    private String email;
    
    @Column
    private Long telefonoFijo;
    
    @Column
    private Long celular;
    
    @Column(length = 1024)
    private String nombreCompletoAcudiente;
    
    //muchos estudiantes con un docente
    @OneToMany(cascade ={CascadeType.ALL}, mappedBy = "docente")
    @JsonBackReference
    private List<Estudiante> estudiantes;
    
    //muchos estudiantes con muchas asignaturas    
    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnore
    //@JsonIgnoreProperties(value="ods")
    private List<Grupo> grupos;

    public Estudiante() {
        
    }

    public Estudiante(String tipoDocumento, Long id, String nombres, String apellidos, Date fechaNacimiento, String grado, String ciudadResidencia, String direccionResidencia, String email, Long telefonoFijo, Long celular, String nombreCompletoAcudiente, List<Estudiante> estudiantes, List<Grupo> grupos) {
        this.tipoDocumento = tipoDocumento;
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadResidencia = ciudadResidencia;
        this.direccionResidencia = direccionResidencia;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
        this.nombreCompletoAcudiente = nombreCompletoAcudiente;
        this.estudiantes = estudiantes;
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

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
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

    public String getNombreCompletoAcudiente() {
        return nombreCompletoAcudiente;
    }

    public void setNombreCompletoAcudiente(String nombreCompletoAcudiente) {
        this.nombreCompletoAcudiente = nombreCompletoAcudiente;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    
}
