package codigo.repositories;
 import codigo.models.Oferente;
import java.util.List;
import java.util.Optional;



public interface IOferenteRepository {

    List<Oferente> findAll();

    List<Oferente> findAllActive();

    Optional<Oferente> findById(Long id);

    List<Oferente> findByNameContaining(String name);

    Oferente save(Oferente oferente);

    Oferente update(Oferente oferente);
    
}
