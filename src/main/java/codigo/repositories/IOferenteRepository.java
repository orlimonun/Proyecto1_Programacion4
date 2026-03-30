package codigo.repositories;
 import codigo.models.Empresa;
 import codigo.models.Oferente;
 import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.List;
import java.util.Optional;



public interface IOferenteRepository extends JpaRepository<Oferente,Long> {

    List<Oferente> findByAprobadoTrue();

    Optional <Oferente>findByAprobadoTrueAndNombreContainingIgnoreCase(String nombre);

    boolean existsByEmail(String email);
    Optional<Oferente> findByEmail(String email);
}
