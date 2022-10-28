
package com.portfolio.davalosAlejandro.Controller;

import com.portfolio.davalosAlejandro.Dto.dtoSkills;
import com.portfolio.davalosAlejandro.Security.Controller.Mensaje;
import com.portfolio.davalosAlejandro.Service.SSkills;
import com.portfolio.davalosAlejandro.entity.Skills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins= "https://frontend2022-aeae3.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CSkills {
    
    @Autowired
    SSkills sSkills;

    
    //Traer
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")int id){
        if(!sSkills.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    //Borrar

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Skills> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

// Crear

    //@PostMapping("/create")
    //public void create(@RequestBody Skills skills){
    //    sSkills.save(skills);
   // }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombreSkill())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sSkills.existsByNombreSkill(dtoskills.getNombreSkill())){
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = new Skills(dtoskills.getSkillsLevel(), dtoskills.getNombreSkill());
        sSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    

 
    //Actualizar
    //@PutMapping("/update/{id}")
    //public void update(@RequestBody Skills skills) {
    //    sSkills.save(skills);  
   // }
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills) {
        //Validamos si existe el ID
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sSkills.existsByNombreSkill(dtoskills.getNombreSkill()) && sSkills.getByNombreSkill(dtoskills.getNombreSkill()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoskills.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = sSkills.getOne(id).get();
        skills.setNombreSkill(dtoskills.getNombreSkill());
        skills.setSkillsLevel(dtoskills.getSkillsLevel());

        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
    
}
