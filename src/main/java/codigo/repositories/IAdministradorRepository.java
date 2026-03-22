package codigo.repositories;

import codigo.models.Administrador;


import java.util.List;
import java.util.Optional;

public interface IAdministradorRepository {

    List<Administrador> findAll();

    List<Administrador> findAllActive();

    Optional<Administrador> findById(Long id);

    List<Administrador> findByNameContaining(String name);

    Administrador save(Administrador administrador);

    Administrador update(Administrador administrador);
    
}
