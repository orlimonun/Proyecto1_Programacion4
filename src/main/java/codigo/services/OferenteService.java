package codigo.services;

import codigo.config.AppProperties;
import codigo.dtos.empresa.CreateEmpresaRequest;
import codigo.dtos.empresa.EmpresaResponse;
import codigo.dtos.oferente.CreateOferenteRequest;
import codigo.dtos.oferente.OferenteResponse;
import codigo.dtos.oferente.UpdateOferenteRequest;
import codigo.exceptions.OferenteNotFoundException;
import codigo.models.*;
import codigo.repositories.HabilidadRepository;
import codigo.repositories.IOferenteRepository;
import codigo.repositories.OferenteHabilidadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class OferenteService {

    private final IOferenteRepository oferenteRepository;
    private final OferenteHabilidadRepository oferenteHabilidadRepository;
    private final HabilidadRepository habilidadRepository;


    public OferenteService(IOferenteRepository oferenteRepository, OferenteHabilidadRepository oferenteHabilidadRepository, HabilidadRepository habilidadRepository) {
        this.oferenteRepository = oferenteRepository;
        this.oferenteHabilidadRepository = oferenteHabilidadRepository;
        this.habilidadRepository = habilidadRepository;
    }

    public List<OferenteResponse> getAllOferentes() {
        return oferenteRepository.findByAprobadoTrue()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public OferenteResponse getOferenteById(Long id) {

        Oferente oferente = oferenteRepository.findById(id)
                .orElseThrow(() -> new OferenteNotFoundException(id));

        return toResponse(oferente);
    }

    public OferenteResponse createOferente(CreateOferenteRequest request) {

        Oferente oferente = new Oferente(
                request.getIdentificacion(),
                request.getCorreo(),
                request.getClave(),
                Rol.OFERENTE,
                false,
                request.getNombre(),
                request.getPrimerApellido(),
                request.getNacionalidad(),
                request.getTelefono(),
                request.getResidencia()
        );

        Oferente saved = oferenteRepository.save(oferente);

        return toResponse(saved);
    }


    public void agregarHabilidad(Long oferenteId, Long habilidadId, int nivel) {

        Oferente oferente = oferenteRepository.findById(oferenteId)
                .orElseThrow(() -> new RuntimeException("Oferente no encontrado"));

        Habilidad habilidad = habilidadRepository.findById(habilidadId)
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada"));

        OferenteHabilidad oh = new OferenteHabilidad();
        oh.setOferente(oferente);
        oh.setHabilidad(habilidad);
        oh.setNivel(nivel);

        oferenteHabilidadRepository.save(oh);
    }

    public void actualizarNivel(Long oferenteId, Long habilidadId, int nivel) {

        Oferente oferente = oferenteRepository.findById(oferenteId)
                .orElseThrow(() -> new RuntimeException("Oferente no encontrado"));

        Habilidad habilidad = habilidadRepository.findById(habilidadId)
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada"));

        OferenteHabilidad oh = oferenteHabilidadRepository
                .findByOferenteAndHabilidad(oferente, habilidad)
                .orElseThrow(() -> new RuntimeException("Habilidad no asignada al oferente"));

        oh.setNivel(nivel);

        oferenteHabilidadRepository.save(oh);
    }

    public void eliminarHabilidad(Long oferenteId, Long habilidadId) {

        Oferente oferente = oferenteRepository.findById(oferenteId)
                .orElseThrow(() -> new RuntimeException("Oferente no encontrado"));

        Habilidad habilidad = habilidadRepository.findById(habilidadId)
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada"));

        OferenteHabilidad oh = oferenteHabilidadRepository
                .findByOferenteAndHabilidad(oferente, habilidad)
                .orElseThrow(() -> new RuntimeException("Habilidad no asignada"));

        oferenteHabilidadRepository.delete(oh);
    }

    public List<OferenteHabilidad> listarHabilidades(Long oferenteId) {

        Oferente oferente = oferenteRepository.findById(oferenteId)
                .orElseThrow(() -> new RuntimeException("Oferente no encontrado"));

        return oferenteHabilidadRepository.findByOferente(oferente);
    }

    public OferenteResponse updateOferente(Long id, UpdateOferenteRequest request) {

        Oferente oferente = oferenteRepository.findById(id)
                .orElseThrow(() -> new OferenteNotFoundException(id));

        oferente.setEmail(request.getCorreo());
        oferente.setPassword(request.getClave());
        oferente.setNombre(request.getNombre());
        oferente.setPrimerApellido(request.getPrimerApellido());
        oferente.setNacionalidad(request.getNacionalidad());
        oferente.setTelefono(request.getTelefono());
        oferente.setResidencia(request.getResidencia());

        return toResponse(oferenteRepository.save(oferente));
    }

    public void deleteLogical(Long id) {

        Oferente oferente = oferenteRepository.findById(id)
                .orElseThrow(() -> new OferenteNotFoundException(id));

        oferente.setAprobado(false);

        oferenteRepository.save(oferente);
    }

    private OferenteResponse toResponse(Oferente oferente) {

        return new OferenteResponse(
                oferente.getId(),
                oferente.getEmail(),
                oferente.getPassword(),
                oferente.isAprobado(),
                oferente.getNombre(),
                oferente.getPrimerApellido(),
                oferente.getNacionalidad(),
                oferente.getTelefono(),
                oferente.getResidencia()
        );
    }
}
