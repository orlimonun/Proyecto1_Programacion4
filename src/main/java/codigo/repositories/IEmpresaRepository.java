package codigo.repositories;

import codigo.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IEmpresaRepository extends JpaRepository<Empresa,Long> {

    List<Empresa> findByAprobadoTrue();

    Optional <Empresa>findByAprobadoTrueAndNombreContainingIgnoreCase(String nombre);

    boolean existsByEmail(String email);

    Optional<Empresa> findByEmail(String email);

}
