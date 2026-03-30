package codigo.repositories;

import codigo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAdministradorRepository extends JpaRepository<Usuario,Long> {

    List<Usuario> findAll();

    List<Usuario> findByAprobadoTrue();

    
}