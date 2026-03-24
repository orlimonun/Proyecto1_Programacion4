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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpresaService implements IEmpresaService {

    private static final Logger log = LoggerFactory.getLogger(EmpresaService.class);
    private final IEmpresaRepository repository;
    private final AppProperties appProperties;

    public EmpresaService(IEmpresaRepository repository, AppProperties appProperties) {
        this.repository = repository;
        this.appProperties = appProperties;
    }
    @Override
    @Transactional(readOnly = true)
   public List<Empresa> findAll(){

        log.info("Fetching all products from the database");

        return repository.findByAprovadoTrue().stream().map(this::toResponse).toList();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Empresa> findAllAprovados(){return repository.findAll();}
    
    @Override
    @Transactional(readOnly = true)
   public Optional<Empresa> findById(Long id){return repository.findById(id);}
    
    @Override
    @Transactional(readOnly = true)
    public List<Empresa> findByNombreContaining(String nombre){return repository.findByAprovadoTrueAndNombreContainingIgnoreCase(nombre).stream().toList();}
    
    @Override
    @Transactional(readOnly = true)
    public Empresa save(Empresa empresa){return repository.save(empresa);}
    
    @Override
    @Transactional(readOnly = true)
    public Empresa update(Empresa empresa){return repository.save(empresa);}
    
    @Override
    @Transactional(readOnly = true)
    public void delete(Long id){repository.deleteById(id);}
    
}
