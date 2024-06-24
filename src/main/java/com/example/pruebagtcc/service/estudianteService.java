/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.service;

import com.example.pruebagtcc.entity.Estudiante;
import com.example.pruebagtcc.repository.estudianteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class estudianteService {
    @Autowired
    private estudianteRepository estudianteRepository;

    public List<Estudiante> getAll(){
        return estudianteRepository.getAll();
    }

    public Optional<Estudiante> getEstudiante(long Id){
        return estudianteRepository.getEstudiante(Id);
    }

    public Estudiante save(Estudiante estudiante){
        if(estudiante.getId()==null){
            return estudianteRepository.save(estudiante);
        }else{
            Optional<Estudiante> e=estudianteRepository.getEstudiante(estudiante.getId());
            if(e.isEmpty()){
                return estudianteRepository.save(estudiante);
            }else{
                return estudiante;
            }
        }
    }

    public Estudiante update(Estudiante estudiante){
        if(estudiante.getId()!=null){
            return estudianteRepository.save(estudiante);
        }else{
            Optional<Estudiante> e=estudianteRepository.getEstudiante(estudiante.getId());
            if(!e.isEmpty()){
                if(estudiante.getTipoDocumento()!=null){
                    e.get().setTipoDocumento(estudiante.getTipoDocumento());
                }
                if(estudiante.getNombres()!=null){
                    e.get().setNombres(estudiante.getNombres());
                }
                if(estudiante.getApellidos()!=null){
                    e.get().setApellidos(estudiante.getApellidos());
                }
                if(estudiante.getFechaNacimiento()!=null){
                    e.get().setFechaNacimiento(estudiante.getFechaNacimiento());
                }
                
                //(.....)
                //demas

                estudianteRepository.save(e.get());
                return e.get();
            }else{
                return estudiante;
            }
        }
    }

    public boolean deleteEstudiante(long Nit){
        Boolean aBoolean=getEstudiante(Nit).map(estudiante -> {
            estudianteRepository.delete(estudiante);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
    
}
