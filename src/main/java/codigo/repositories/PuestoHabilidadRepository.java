package codigo.repositories;

import codigo.dtos.puesto.HabilidadNivel;
import codigo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PuestoHabilidadRepository extends JpaRepository<HabilidadNivel, Long> {

    List<HabilidadNivel> findByAprovadoTrue();

    Optional<Empresa> findByAprovadoTrueAndNombreContainingIgnoreCase(String nombre);

    List<PuestoHabilidad> findByPuesto(Puesto puesto);


}
