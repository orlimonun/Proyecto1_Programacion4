package codigo.services;

import codigo.config.AppProperties;
import codigo.dtos.oferente.CreateOferenteRequest;
import codigo.dtos.oferente.OferenteResponse;
import codigo.dtos.oferente.UpdateOferenteRequest;
import codigo.exceptions.OferenteNotFoundException;
import codigo.models.Oferente;
import codigo.repositories.IOferenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class OferenteService {

    private static final Logger log = LoggerFactory.getLogger(OferenteService.class);
    private final IOferenteService service;
    private final AppProperties appProperties;

    public OferenteService(IOferenteService service, AppProperties appProperties) {
        this.service = service;
        this.appProperties = appProperties;
    }

    public List<OferenteResponse> getAllOferentes() {
        log.info("Fetching all oferentes from the database");

        return service.findAllAprovados().stream().map(this::toResponse).toList();
    }

    public OferenteResponse getOferenteById(Long id) {
        log.info("Fetching oferente with id {} from the database", id);

        Oferente oferente = service.findById(id).orElseThrow(() -> new OferenteNotFoundException(id));

        return toResponse(oferente);
    }

    public Oferente getDomainOferenteById(Long id) {
        log.info("Fetching oferente with id {} from the database", id);

        return service.findById(id).orElseThrow(() -> new OferenteNotFoundException(id));
    }

    public OferenteResponse createOferente(CreateOferenteRequest request) {
        log.info("Creating new oferente from the database");

        Oferente oferente = new Oferente(request.getIdentificacion(), request.getCorreo(), request.getClave(),request.,true, request.getNombre(),
                request.getPrimerApellido(), request.getNacionalidad(),request.getTelefono(), request.getResidencia());

        Oferente saved = service.save(oferente);

        return toResponse(saved);
    }

    public OferenteResponse updateOferente(Long id, UpdateOferenteRequest request) {
        log.info("Updating oferente with id {} in the database", id);

        Oferente oferente = service.findById(id).orElseThrow(() -> new OferenteNotFoundException(id));

        oferente.setEmail(request.getCorreo());
        oferente.setPassword(request.getClave());
        oferente.setNombre(request.getNombre());
        oferente.setPrimerApellido(request.getPrimerApellido());
        oferente.setNacionalidad(request.getNacionalidad());
        oferente.setTelefono(request.getTelefono());
        oferente.setResidencia(request.getResidencia());

        Oferente updated = service.update(oferente);

        return toResponse(updated);
    }

    public void deleteLogical(Long id) {
        log.info("Logically deleting oferente with id {} in the database", id);

        Oferente oferente = service.findById(id).orElseThrow(() -> new OferenteNotFoundException(id));

        oferente.setActivo(false);

        service.update(oferente);
    }

    public UpdateOferenteRequest buildUpdateRequest(Long id) {
        log.info("Building update request for oferente with id {} from the database", id);

        Oferente oferente = service.findById(id).orElseThrow(() -> new OferenteNotFoundException(id));

        return new UpdateOferenteRequest(oferente.getId(), oferente.getEmail(),oferente.getPassword(),
                oferente.getNombre(),oferente.getPrimerApellido(), oferente.getNacionalidad(), oferente.getTelefono(), oferente.getResidencia());
    }

    private OferenteResponse toResponse(Oferente oferente) {

        return new OferenteResponse(oferente.getIdentificacion(), oferente.getCorreo(),oferente.getClave(), oferente.isActivo(),
                oferente.getNombre(),oferente.getPrimerApellido(), oferente.getNacionalidad(), oferente.getTelefono(), oferente.getResidencia());
    }

}
