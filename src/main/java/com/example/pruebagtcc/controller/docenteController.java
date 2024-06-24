/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.controller;

import com.example.pruebagtcc.entity.Docente;
import com.example.pruebagtcc.service.docenteService;
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
@RequestMapping("/api/docente")
public class docenteController {
    @Autowired
    private docenteService docenteService;

    @GetMapping("/all")
    public List<Docente> getDocentes(){
        return docenteService.getAll();
    }

    @GetMapping("/{Id}")
    public Optional<Docente> getDocente(@PathVariable("Id") long Id){
        return docenteService.getDocente(Id);
    }

    @PostMapping(value = "/save", consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Docente save(@RequestBody Docente docente){
        return docenteService.save(docente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Docente update(@RequestBody Docente docente){
        return docenteService.update(docente);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("Nit") long Nit){
        return docenteService.deleteDocente(Nit);
    }
}
