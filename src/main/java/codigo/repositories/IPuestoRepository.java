package codigo.repositories;

import codigo.models.Empresa;
import codigo.models.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPuestoRepository  extends JpaRepository<Puesto, Long> {

    List<Empresa> findByAprovadoTrue();

    Optional<Empresa> findByAprovadoTrueAndNombreContainingIgnoreCase(String nombre);

}
