/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.controller;

/**
 *
 * @author cktv
 */

import com.example.pruebagtcc.entity.Asignatura;
import com.example.pruebagtcc.service.asignaturaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cktv
 */
@RestController
@RequestMapping("/api/asignatura")
public class asignaturaController {
    @Autowired
    private asignaturaService asignaturaService;

    @GetMapping("/all")
    public List<Asignatura> getAsignaturas(){
        return asignaturaService.getAll();
    }

    @GetMapping("/{Id}")
    public Optional<Asignatura> getAsignatura(@PathVariable("Nit") int Id){
        return asignaturaService.getAsignatura(Id);
    }

    @PostMapping(value = "/save", consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Asignatura save(@RequestBody Asignatura asignatura){
        return asignaturaService.save(asignatura);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Asignatura update(@RequestBody Asignatura asignatura){
        return asignaturaService.update(asignatura);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return asignaturaService.deleteAsignatura(id);
    }
}
