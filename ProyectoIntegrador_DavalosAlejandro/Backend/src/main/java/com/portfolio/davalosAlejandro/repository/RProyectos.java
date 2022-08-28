
package com.portfolio.davalosAlejandro.repository;

import com.portfolio.davalosAlejandro.entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    Optional<Proyectos> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo); 
    
}
