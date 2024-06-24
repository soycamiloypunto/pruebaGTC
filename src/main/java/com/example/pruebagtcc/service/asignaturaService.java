/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.service;

import com.example.pruebagtcc.entity.Asignatura;
import com.example.pruebagtcc.repository.asignaturaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class asignaturaService {
    @Autowired
    private asignaturaRepository asignaturaRepository;

    public List<Asignatura> getAll(){
        return asignaturaRepository.getAll();
    }

    public Optional<Asignatura> getAsignatura(int Id){
        return asignaturaRepository.getAsignatura(Id);
    }

    public Asignatura save(Asignatura asignatura){
        if(asignatura.getId()==null){
            return asignaturaRepository.save(asignatura);
        }else{
            Optional<Asignatura> e=asignaturaRepository.getAsignatura(asignatura.getId());
            if(e.isEmpty()){
                return asignaturaRepository.save(asignatura);
            }else{
                return asignatura;
            }
        }
    }

    public Asignatura update(Asignatura asignatura){
        if(asignatura.getId()!=null){
            return asignaturaRepository.save(asignatura);
        }else{
            Optional<Asignatura> e=asignaturaRepository.getAsignatura(asignatura.getId());
            if(!e.isEmpty()){
                if(asignatura.getNombre()!=null){
                    e.get().setNombre(asignatura.getNombre());
                }
                if(asignatura.getEstudiante()!=null){
                    e.get().setEstudiante(asignatura.getEstudiante());
                }
                if(asignatura.getDocente()!=null){
                    e.get().setDocente(asignatura.getDocente());
                }
                
                //(.....)
                //demas

                asignaturaRepository.save(e.get());
                return e.get();
            }else{
                return asignatura;
            }
        }
    }

    public boolean deleteAsignatura(int id){
        Boolean aBoolean=getAsignatura(id).map(asignatura -> {
            asignaturaRepository.delete(asignatura);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
    
}
