package codigo.repositories;


import codigo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PuestoHabilidadRepository extends JpaRepository<PuestoHabilidad, Long> {

    List<PuestoHabilidad> findByPuesto(Puesto puesto);

}
