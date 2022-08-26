
package com.portfolio.davalosAlejandro.Interface;

import com.portfolio.davalosAlejandro.entity.Persona;
import java.util.List;




public interface IPersonaService {
    public List<Persona> verPersonas();
    public void savePersona (Persona persona);
    public void deletePersona (Long id);
    public Persona findPersona (Long id);
    public Persona editarPersona(Persona persona);
    
}
