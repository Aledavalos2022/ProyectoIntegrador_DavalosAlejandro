
package com.portfolio.davalosAlejandro.Security.Service;

import com.portfolio.davalosAlejandro.Security.Entity.Rol;
import com.portfolio.davalosAlejandro.Security.Enums.RolNombre;
import com.portfolio.davalosAlejandro.Security.Repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.finByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
