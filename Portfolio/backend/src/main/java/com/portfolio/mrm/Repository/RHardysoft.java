/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mrm.Repository;

import com.portfolio.mrm.Entity.Hardysoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ricardo
 */
public interface RHardysoft extends JpaRepository<Hardysoft, Integer> {
    Optional<Hardysoft> findByNombre(String nombre);
    
    public boolean  existsByNombre(String nombre);
         
    
}
