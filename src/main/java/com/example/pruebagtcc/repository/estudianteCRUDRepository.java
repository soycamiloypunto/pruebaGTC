/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.repository;

/**
 *
 * @author cktv
 */
import com.example.pruebagtcc.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;


public interface estudianteCRUDRepository extends CrudRepository<Estudiante, Long> {

}
