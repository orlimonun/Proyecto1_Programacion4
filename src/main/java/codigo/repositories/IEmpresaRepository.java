package codigo.repositories;

import codigo.models.Empresa;

import java.util.List;
import java.util.Optional;

public interface IEmpresaRepository {

    List<Empresa> findAll();

    List<Empresa> findAllActive();

    Optional<Empresa> findById(Long id);

    List<Empresa> findByNameContaining(String name);

    Empresa save(Empresa empresa);

    Empresa update(Empresa empresa);
    
}
