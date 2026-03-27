package codigo.services;

import codigo.config.AppProperties;

import codigo.dtos.empresa.CreateEmpresaRequest;
import codigo.dtos.empresa.EmpresaResponse;
import codigo.dtos.empresa.UpdateEmpresaRequest;
import codigo.dtos.puesto.CreatePuestoRequest;
import codigo.dtos.puesto.HabilidadNivel;
import codigo.dtos.puesto.PuestoResponse;
import codigo.exceptions.EmpresaNotFoundException;
import codigo.models.Empresa;
import codigo.models.Habilidad;
import codigo.models.Puesto;
import codigo.models.PuestoHabilidad;
import codigo.repositories.HabilidadRepository;
import codigo.repositories.IEmpresaRepository;
import codigo.repositories.IPuestoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*@Service
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
    
}*/
@Service
public class EmpresaService {

    @Autowired
    private IEmpresaRepository empresaRepository;

    @Autowired
    private IPuestoRepository puestoRepository;

    @Autowired
    private HabilidadRepository habilidadRepository;


    public EmpresaResponse registrar(CreateEmpresaRequest dto) {

        if (empresaRepository.existsByCorreo(dto.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Empresa empresa = new Empresa();
        empresa.setNombre(dto.getNombre());
        empresa.setEmail(dto.getCorreo());
        empresa.setPassword(dto.getClave());
        empresa.setDescripcion(dto.getDescripcion());
        empresa.setTelefono(dto.getTelefono());
        empresa.setLocalizacion(dto.getLocalizacion());

        empresa.setAprobado(false);

        empresaRepository.save(empresa);

        return mapToResponse(empresa);
    }

    public EmpresaResponse login(String correo, String clave) {

        Empresa empresa = empresaRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        if (!empresa.getPassword().equals(clave)) {
            throw new RuntimeException("Clave incorrecta");
        }

        if (!empresa.isAprobado()) {
            throw new RuntimeException("Empresa no aprobada aún");
        }

        return mapToResponse(empresa);
    }


    public List<PuestoResponse> listarMisPuestos(Long empresaId) {

        List<Puesto> puestos = puestoRepository.findById(empresaId);

        return puestos.stream()
                .map(this::mapPuestoToResponse)
                .toList();
    }



    public PuestoResponse publicarPuesto(Long empresaId, CreatePuestoRequest dto) {

        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        if (!empresa.isAprobado()) {
            throw new RuntimeException("Empresa no autorizada");
        }

        Puesto puesto = new Puesto();
        puesto.setDescripcion(dto.getDescripcion());
        puesto.setSalario(dto.getSalario());
        puesto.setPublico(dto.isPublico());
        puesto.setActivo(true);
        puesto.setEmpresa(empresa);


        List<PuestoHabilidad> habilidades = new ArrayList<>();

        for (HabilidadNivel hDto : dto.getHabilidades()) {

            Habilidad habilidad = habilidadRepository.findById(hDto.getHabilidadId())
                    .orElseThrow(() -> new RuntimeException("Habilidad no existe"));

            PuestoHabilidad ph = new PuestoHabilidad();
            ph.setHabilidad(habilidad);
            ph.setNivelRequerido(hDto.getNivel());
            ph.setPuesto(puesto);

            habilidades.add(ph);
        }

        puesto.setHabilidades(habilidades);

        puestoRepository.save(puesto);

        return mapPuestoToResponse(puesto);
    }


    public void desactivarPuesto(Long puestoId) {

        Puesto puesto = puestoRepository.findById(puestoId)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        puesto.setActivo(false);

        puestoRepository.save(puesto);
    }

    private EmpresaResponse mapToResponse(Empresa e) {
        EmpresaResponse dto = new EmpresaResponse();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setCorreo(e.getCorreo());
        dto.setDescripcion(e.getDescripcion());
        return dto;
    }

    private PuestoResponse mapPuestoToResponse(Puesto p) {
        PuestoResponse dto = new PuestoResponse();
        dto.setId(p.getId());
        dto.setDescripcion(p.getDescripcion());
        dto.setSalario(p.getSalario());
        dto.setPublico(p.isPublico());
        dto.setActivo(p.isActivo());
        return dto;
    }
}
