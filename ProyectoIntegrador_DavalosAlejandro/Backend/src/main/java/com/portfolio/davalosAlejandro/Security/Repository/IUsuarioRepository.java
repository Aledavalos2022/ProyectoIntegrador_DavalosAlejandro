
package com.portfolio.davalosAlejandro.Security.Repository;

import com.portfolio.davalosAlejandro.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> finByNombreUsuario (String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByNombreEmail(String email);
}
