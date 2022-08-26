
package com.portfolio.davalosAlejandro.Service;

import com.portfolio.davalosAlejandro.Interface.IPersonaService;
import com.portfolio.davalosAlejandro.entity.Persona;
import com.portfolio.davalosAlejandro.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonarepository;

    @Override
    public List<Persona> verPersonas() {
        return ipersonarepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonarepository.findById(id).orElse(null);
        return persona;        
    }
    @Override
    public Persona editarPersona(Persona persona) {
        return ipersonarepository.save(persona);
    }
    
}
