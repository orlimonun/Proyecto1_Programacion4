package codigo.repositories;

import codigo.models.Oferente;
import codigo.models.OferenteHabilidad;
import codigo.models.Puesto;
import codigo.models.PuestoHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OferenteHabilidadRepository extends JpaRepository<OferenteHabilidad,Long> {

    List<OferenteHabilidad> findByOferente(Oferente oferente);


}
