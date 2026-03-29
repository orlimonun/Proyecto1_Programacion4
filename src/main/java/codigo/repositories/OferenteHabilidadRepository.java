package codigo.repositories;

import codigo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OferenteHabilidadRepository extends JpaRepository<OferenteHabilidad,Long> {

    List<OferenteHabilidad> findByOferente(Oferente oferente);

    Optional<OferenteHabilidad> findByOferenteAndHabilidad(Oferente oferente, Habilidad habilidad);

}
