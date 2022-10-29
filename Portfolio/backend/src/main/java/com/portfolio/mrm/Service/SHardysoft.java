/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mrm.Service;

import com.portfolio.mrm.Entity.Hardysoft;
import com.portfolio.mrm.Repository.RHardysoft;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SHardysoft {
    @Autowired  
    RHardysoft rHardysoft;
    public List<Hardysoft> list(){
        return rHardysoft.findAll();
    }
    public Optional<Hardysoft> getOne(int id){
        return rHardysoft.findById(id);
    }
    
    public Optional<Hardysoft> getByNombre(String nombre){
        return rHardysoft.findByNombre(nombre);
       }
    public void save(Hardysoft skill){
        rHardysoft.save(skill);        
    }
    public void delete(int id){
        rHardysoft.deleteById(id);
    }
    public boolean existsById(int id){
        return rHardysoft.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return rHardysoft.existsByNombre(nombre);
    }
}
