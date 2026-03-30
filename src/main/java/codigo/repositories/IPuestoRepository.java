package codigo.repositories;

import codigo.models.Empresa;
import codigo.models.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPuestoRepository  extends JpaRepository<Puesto, Long> {

    List<Puesto> findByActivoTrue();

    Optional<Puesto> findByActivoTrueAndDescripcionContainingIgnoreCase(String nombre);

    List<Puesto> findByEmpresaId(Long empresaId);

    @Query("""

            SELECT p
FROM Puesto p
WHERE MONTH(p.fecha) = :mes
AND YEAR(p.fecha) = :anio
""")
    List<Puesto> findPuestosByMesAndAnio(int mes, int anio);

    List<Puesto> findTop5ByPublicoTrueAndActivoTrueOrderByFechaDesc();

}