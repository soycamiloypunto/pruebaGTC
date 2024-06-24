/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.controller;

import com.example.pruebagtcc.entity.Estudiante;
import com.example.pruebagtcc.service.estudianteService;
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
@RequestMapping("/api/estudiante")
public class estudianteController {
    @Autowired
    private estudianteService estudianteService;

    @GetMapping("/all")
    public List<Estudiante> getEstudiantes(){
        return estudianteService.getAll();
    }

    @GetMapping("/{Id}")
    public Optional<Estudiante> getEstudiante(@PathVariable("Nit") long Id){
        return estudianteService.getEstudiante(Id);
    }

    @PostMapping(value = "/save", consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante save(@RequestBody Estudiante estudiante){
        return estudianteService.save(estudiante);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante update(@RequestBody Estudiante estudiante){
        return estudianteService.update(estudiante);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("Nit") long Nit){
        return estudianteService.deleteEstudiante(Nit);
    }
}
