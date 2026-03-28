package codigo.repositories;

import codigo.models.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabilidadRepository extends JpaRepository<Habilidad,Long> {

    List<Habilidad> findByParentIsNull();

}
