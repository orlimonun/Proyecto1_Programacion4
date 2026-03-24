package codigo.services;
/*
import codigo.dtos.administrador.CreateAdministradorRequest;
import codigo.dtos.administrador.AdministradorResponse;
import codigo.dtos.administrador.UpdateAdministradorRequest;
import codigo.exceptions.AdministradorNotFoundException;
import codigo.models.Administrador;
import codigo.repositories.IAdministradorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import codigo.config.AppProperties;
import java.util.List;



@Service
public class AdministradorService {
    private static final Logger log = LoggerFactory.getLogger(AdministradorService.class);
    private final IAdministradorRepository repository;
    private final AppProperties appProperties;

    public AdministradorService(IAdministradorRepository repository, AppProperties appProperties) {
        this.repository = repository;
        this.appProperties = appProperties;
    }

    public List<AdministradorResponse> getAllAdministradors() {
        log.info("Fetching all administradors from the database");

        return repository.findAllActive().stream().map(this::toResponse).toList();
    }

    public AdministradorResponse getAdministradorById(String id) {
        log.info("Fetching administrador with id {} from the database", id);

        Administrador administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        return toResponse(administrador);
    }

    public Administrador getDomainAdministradorById(String id) {
        log.info("Fetching administrador with id {} from the database", id);

        return repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));
    }

    public AdministradorResponse createAdministrador(CreateAdministradorRequest request) {
        log.info("Creating new administrador from the database");

        Administrador administrador = new Administrador(request.getIdentificacion(), request.getCorreo(), request.getClave(),true);

        Administrador saved = repository.save(administrador);

        return toResponse(saved);
    }

    public AdministradorResponse updateAdministrador(String id, UpdateAdministradorRequest request) {
        log.info("Updating administrador with id {} in the database", id);

        Administrador administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        administrador.setEmail(request.getCorreo());
        administrador.setPassword(request.getClave());

        Administrador updated = repository.update(administrador);

        return toResponse(updated);
    }

    public void deleteLogical(String id) {
        log.info("Logically deleting administrador with id {} in the database", id);

        Administrador administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        administrador.setAprobado(false);

        repository.update(administrador);
    }

    public UpdateAdministradorRequest buildUpdateRequest(String id) {
        log.info("Building update request for administrador with id {} from the database", id);

        Administrador administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        return new UpdateAdministradorRequest(administrador.getId().toString(), administrador.getEmail(), administrador.getPassword());
    }

    private AdministradorResponse toResponse(Administrador administrador) {

        return new AdministradorResponse(administrador.getId().toString(), administrador.getEmail(), administrador.getPassword(),administrador.isAprobado());
    }    
    
    
}*/
