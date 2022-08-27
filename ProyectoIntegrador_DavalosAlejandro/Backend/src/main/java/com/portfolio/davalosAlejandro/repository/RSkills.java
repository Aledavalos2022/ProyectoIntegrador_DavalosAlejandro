
package com.portfolio.davalosAlejandro.repository;

import com.portfolio.davalosAlejandro.entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository <Skills, Integer>{
    Optional<Skills> findByNombreSkill(String nombreSkill);
    boolean existsByNombreSkill(String nombreSkill); 
}
