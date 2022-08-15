
package com.portfolio.davalosAlejandro.Security.Repository;

import com.portfolio.davalosAlejandro.Security.Entity.Rol;
import com.portfolio.davalosAlejandro.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> finByRolNombre(RolNombre rolNombre);
}
