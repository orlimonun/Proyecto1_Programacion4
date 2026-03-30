package codigo.services;

import codigo.dtos.administrador.CreateAdministradorRequest;
import codigo.dtos.administrador.AdministradorResponse;
import codigo.dtos.administrador.UpdateAdministradorRequest;
import codigo.exceptions.AdministradorNotFoundException;
import codigo.models.Empresa;
import codigo.models.Oferente;
import codigo.models.Rol;
import codigo.models.Usuario;
import codigo.repositories.IAdministradorRepository;
import codigo.repositories.IEmpresaRepository;
import codigo.repositories.IOferenteRepository;
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
    private final IEmpresaRepository empresaRepository;
    private final IOferenteRepository oferenteRepository;


    public AdministradorService(IAdministradorRepository repository, AppProperties appProperties, IEmpresaRepository empresaRepository, IOferenteRepository oferenteRepository) {
        this.repository = repository;
        this.appProperties = appProperties;
        this.empresaRepository = empresaRepository;
        this.oferenteRepository = oferenteRepository;
    }

    public List<AdministradorResponse> getAllAdministradors() {
        log.info("Fetching all administradors from the database");

        return repository.findByAprobadoTrue().stream().map(this::toResponse).toList();
    }

    public AdministradorResponse getAdministradorById(Long id) {
        log.info("Fetching administrador with id {} from the database", id);

        Usuario administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        return toResponse(administrador);
    }

    public Usuario getDomainAdministradorById(Long id) {
        log.info("Fetching administrador with id {} from the database", id);

        return repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));
    }

    public AdministradorResponse createAdministrador(CreateAdministradorRequest request) {
        log.info("Creating new administrador from the database");

        Usuario administrador = new Usuario(request.getIdentificacion(), request.getCorreo(), request.getClave(), Rol.ADMIN,true);

        Usuario saved = repository.save(administrador);

        return toResponse(saved);
    }

    public AdministradorResponse updateAdministrador(Long id, UpdateAdministradorRequest request) {
        log.info("Updating administrador with id {} in the database", id);

        Usuario administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        administrador.setEmail(request.getCorreo());
        administrador.setPassword(request.getClave());

        Usuario updated = repository.save(administrador);

        return toResponse(updated);
    }

    public void deleteLogical(Long id) {
        log.info("Logically deleting administrador with id {} in the database", id);

        Usuario administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        administrador.setAprobado(false);

        repository.save(administrador);
    }

    public UpdateAdministradorRequest buildUpdateRequest(Long id) {
        log.info("Building update request for administrador with id {} from the database", id);

        Usuario administrador = repository.findById(id).orElseThrow(() -> new AdministradorNotFoundException(id));

        return new UpdateAdministradorRequest(administrador.getId(), administrador.getEmail(), administrador.getPassword());
    }

    private AdministradorResponse toResponse(Usuario administrador) {

        return new AdministradorResponse(administrador.getId(), administrador.getEmail(), administrador.getPassword(),administrador.isAprobado());
    }
    //Implementar
    public void aprobarEmpresa(Long id){

        log.info("Approving empresa with id {}", id);

        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa not found with id " + id));

        empresa.setAprobado(true);

        empresaRepository.save(empresa);

    }
    public void aprobarOferente(Long id){

        log.info("Approving oferente with id {}", id);

        Oferente oferente = oferenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oferente not found with id " + id));

        oferente.setAprobado(true);

        oferenteRepository.save(oferente);

    }
    
}
