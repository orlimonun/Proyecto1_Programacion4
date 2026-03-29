package codigo.repositories;

import codigo.models.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAdministradorRepository extends JpaRepository<Administrador,Long> {

    List<Administrador> findAll();

    List<Administrador> findAllActive();

    Optional<Administrador> findById(Long id);

    List<Administrador> findByNameContaining(String name);

    List<Administrador> findByAprovadoTrue();

    Administrador save(Administrador administrador);

    Administrador update(Administrador administrador);
    
}