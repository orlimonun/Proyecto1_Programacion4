package codigo.repositories;

import codigo.dtos.puesto.HabilidadNivel;
import codigo.models.Empresa;
import codigo.models.Habilidad;
import codigo.models.PuestoHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PuestoHabilidadRepository extends JpaRepository<HabilidadNivel, Long> {

    List<HabilidadNivel> findByAprovadoTrue();

    Optional<Empresa> findByAprovadoTrueAndNombreContainingIgnoreCase(String nombre);

}
