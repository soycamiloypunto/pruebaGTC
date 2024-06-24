/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.repository;

import com.example.pruebagtcc.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class estudianteRepository {
    @Autowired
    private estudianteCRUDRepository estudianteCRUDRepository;

    //Get ALl
    public List<Estudiante> getAll(){
        return (List<Estudiante>) estudianteCRUDRepository.findAll();
    }

    //Get por Id
    public Optional<Estudiante> getEstudiante(long id){
        return estudianteCRUDRepository.findById(id);
    }

    //SAVE
    public Estudiante save(Estudiante estudiante){
        return estudianteCRUDRepository.save(estudiante);
    }

    //DELETE
    public void delete(Estudiante estudiante){
        estudianteCRUDRepository.delete(estudiante);
    }
}
