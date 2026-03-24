package codigo.services;

import codigo.models.Empresa;

import java.util.List;
import java.util.Optional;

public interface IEmpresaService {
    List<Empresa> findAll();

    List<Empresa> findAllAprovados();

    Optional<Empresa> findById(Long id);

    List<Empresa> findByNombreContaining(String nombre);

    Empresa save(Empresa empresa);

    Empresa update(Empresa empresa);

    void delete(Long id);

}
