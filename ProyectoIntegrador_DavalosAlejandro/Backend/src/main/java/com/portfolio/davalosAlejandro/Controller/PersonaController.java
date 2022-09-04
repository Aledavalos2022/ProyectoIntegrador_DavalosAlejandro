
package com.portfolio.davalosAlejandro.Controller;

import com.portfolio.davalosAlejandro.Interface.IPersonaService;
import com.portfolio.davalosAlejandro.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "https://frontend2022-aeae3.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
     @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas (){
        return ipersonaService.verPersonas();    }
    
    
    @GetMapping ("/ver/personas/{id}")
    @ResponseBody
    public Persona verPersona (@PathVariable Long id){
      return ipersonaService.findPersona(id);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //@PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("/personas/update")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona) {
        Persona updatePersona = ipersonaService.editarPersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }
   
    
}
