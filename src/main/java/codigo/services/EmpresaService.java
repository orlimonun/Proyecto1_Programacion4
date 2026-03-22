package codigo.services;

import codigo.config.AppProperties;

import codigo.dtos.empresa.CreateEmpresaRequest;
import codigo.dtos.empresa.EmpresaResponse;
import codigo.dtos.empresa.UpdateEmpresaRequest;
import codigo.exceptions.EmpresaNotFoundException;
import codigo.models.Empresa;
import codigo.repositories.IEmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private static final Logger log = LoggerFactory.getLogger(EmpresaService.class);
    private final IEmpresaRepository repository;
    private final AppProperties appProperties;

    public EmpresaService(IEmpresaRepository repository, AppProperties appProperties) {
        this.repository = repository;
        this.appProperties = appProperties;
    }

    public List<EmpresaResponse> getAllEmpresas() {
        log.info("Fetching all empresas from the database");

        return repository.findAllActive().stream().map(this::toResponse).toList();
    }

    public EmpresaResponse getEmpresaById(Long id) {
        log.info("Fetching empresa with id {} from the database", id);

        Empresa empresa = repository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));

        return toResponse(empresa);
    }

    public Empresa getDomainEmpresaById(Long id) {
        log.info("Fetching empresa with id {} from the database", id);

        return repository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));
    }

    public EmpresaResponse createEmpresa(CreateEmpresaRequest request) {
        log.info("Creating new empresa from the database");

        Empresa empresa = new Empresa(request.getIdentificacion(), request.getCorreo(), request.getClave(),true, request.getDescripcion(),
                request.getTelefono(), request.getLocalizacion(),request.getNombre());

        Empresa saved = repository.save(empresa);

        return toResponse(saved);
    }

    public EmpresaResponse updateEmpresa(Long id, UpdateEmpresaRequest request) {
        log.info("Updating empresa with id {} in the database", id);

        Empresa empresa = repository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));

        empresa.setCorreo(request.getCorreo());
        empresa.setClave(request.getClave());
        empresa.setNombre(request.getNombre());
        empresa.setDescripcion(request.getDescripcion());
        empresa.setLocalizacion(request.getLocalizacion());
        empresa.setTelefono(request.getTelefono());

        Empresa updated = repository.update(empresa);

        return toResponse(updated);
    }

    public void deleteLogical(Long id) {
        log.info("Logically deleting empresa with id {} in the database", id);

        Empresa empresa = repository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));

        empresa.setActivo(false);

        repository.update(empresa);
    }

    public UpdateEmpresaRequest buildUpdateRequest(Long id) {
        log.info("Building update request for empresa with id {} from the database", id);

        Empresa empresa = repository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));

        return new UpdateEmpresaRequest(empresa.getIdentificacion(), empresa.getCorreo(), empresa.getClave(), empresa.getDescripcion(),
                empresa.getTelefono(), empresa.getLocalizacion(),empresa.getNombre());
    }

    private EmpresaResponse toResponse(Empresa empresa) {

        return new EmpresaResponse(empresa.getIdentificacion(), empresa.getCorreo(), empresa.getClave(),empresa.isActivo(), empresa.getDescripcion(),
                empresa.getTelefono(), empresa.getLocalizacion(),empresa.getNombre());
    }


}
