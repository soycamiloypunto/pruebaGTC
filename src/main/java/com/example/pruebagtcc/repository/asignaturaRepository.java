/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.repository;


import com.example.pruebagtcc.entity.Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class asignaturaRepository {
    @Autowired
    private asignaturaCRUDRepository asignaturaCRUDRepository;

    //Get ALl
    public List<Asignatura> getAll(){
        return (List<Asignatura>) asignaturaCRUDRepository.findAll();
    }

    //Get por Id
    public Optional<Asignatura> getAsignatura(int id){
        return asignaturaCRUDRepository.findById(id);
    }

    //SAVE
    public Asignatura save(Asignatura asignatura){
        return asignaturaCRUDRepository.save(asignatura);
    }

    //DELETE
    public void delete(Asignatura asignatura){
        asignaturaCRUDRepository.delete(asignatura);
    }
}
