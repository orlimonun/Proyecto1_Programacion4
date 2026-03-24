package codigo.services;

import codigo.models.Oferente;

import java.util.List;
import java.util.Optional;

public interface IOferenteService {

    List<Oferente> findAll();

    List<Oferente> findAllAprovados();

    Optional<Oferente> findById(Long id);

    List<Oferente> findByNombreContaining(String nombre);

    Oferente save(Oferente oferente);

    Oferente update(Oferente oferente);

    void delete(Long id);
    
}
