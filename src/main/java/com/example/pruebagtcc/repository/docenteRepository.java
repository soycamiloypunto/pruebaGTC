/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.repository;

/**
 *
 * @author cktv
 */

import com.example.pruebagtcc.entity.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class docenteRepository {
    @Autowired
    private docenteCRUDRepository docenteCRUDRepository;

    //Get ALl
    public List<Docente> getAll(){
        return (List<Docente>) docenteCRUDRepository.findAll();
    }

    //Get por Id
    public Optional<Docente> getDocente(long id){
        return docenteCRUDRepository.findById(id);
    }

    //SAVE
    public Docente save(Docente docente){
        return docenteCRUDRepository.save(docente);
    }

    //DELETE
    public void delete(Docente docente){
        docenteCRUDRepository.delete(docente);
    }
}
