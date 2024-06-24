/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pruebagtcc.service;

/**
 *
 * @author cktv
 */
import com.example.pruebagtcc.entity.Docente;
import com.example.pruebagtcc.repository.docenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class docenteService {
    @Autowired
    private docenteRepository docenteRepository;

    public List<Docente> getAll(){
        return docenteRepository.getAll();
    }

    public Optional<Docente> getDocente(long Id){
        return docenteRepository.getDocente(Id);
    }

    public Docente save(Docente docente){
        if(docente.getId()==null){
            return docenteRepository.save(docente);
        }else{
            Optional<Docente> e=docenteRepository.getDocente(docente.getId());
            if(e.isEmpty()){
                return docenteRepository.save(docente);
            }else{
                return docente;
            }
        }
    }

    public Docente update(Docente docente){
        if(docente.getId()!=null){
            return docenteRepository.save(docente);
        }else{
            Optional<Docente> e=docenteRepository.getDocente(docente.getId());
            if(!e.isEmpty()){
                if(docente.getTipoDocumento()!=null){
                    e.get().setTipoDocumento(docente.getTipoDocumento());
                }
                if(docente.getNombres()!=null){
                    e.get().setNombres(docente.getNombres());
                }
                if(docente.getApellidos()!=null){
                    e.get().setApellidos(docente.getApellidos());
                }
                if(docente.getFechaNacimiento()!=null){
                    e.get().setFechaNacimiento(docente.getFechaNacimiento());
                }
                
                //(.....)
                //demas

                docenteRepository.save(e.get());
                return e.get();
            }else{
                return docente;
            }
        }
    }

    public boolean deleteDocente(long Nit){
        Boolean aBoolean=getDocente(Nit).map(docente -> {
            docenteRepository.delete(docente);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
}
