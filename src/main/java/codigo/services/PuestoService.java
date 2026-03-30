package codigo.services;

import codigo.config.AppProperties;
import codigo.dtos.puesto.CreatePuestoRequest;
import codigo.dtos.puesto.HabilidadNivel;
import codigo.dtos.puesto.PuestoResponse;
import codigo.exceptions.EmpresaNotFoundException;
import codigo.exceptions.PuestoNotFoundException;
import codigo.models.Empresa;
import codigo.models.Puesto;
import codigo.models.PuestoHabilidad;
import codigo.repositories.HabilidadRepository;
import codigo.repositories.IEmpresaRepository;
import codigo.repositories.IPuestoRepository;
import codigo.repositories.PuestoHabilidadRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PuestoService {

    private final IPuestoRepository puestoRepository;
    private final IEmpresaRepository empresaRepository;
    private final AppProperties appProperties;
    private final HabilidadRepository habilidadRepository;
    private final PuestoHabilidadRepository puestoHabilidadRepository;

    public PuestoService(
            IPuestoRepository puestoRepository,
            IEmpresaRepository empresaRepository,
            AppProperties appProperties,
            HabilidadRepository habilidadRepository,
            PuestoHabilidadRepository puestoHabilidadRepository) {

        this.puestoRepository = puestoRepository;
        this.empresaRepository = empresaRepository;
        this.appProperties = appProperties;
        this.habilidadRepository = habilidadRepository;
        this.puestoHabilidadRepository = puestoHabilidadRepository;
    }

    @Transactional(readOnly = true)
    public List<PuestoResponse> findAll() {
        return puestoRepository
                .findByAprovadoTrue()
                .stream()
                .map(this::toView)
                .toList();
    }

    @Transactional(readOnly = true)
    public PuestoResponse findById(Long id) {

        Puesto puesto = puestoRepository
                .findById(id)
                .orElseThrow(() -> new PuestoNotFoundException(id));

        return toView(puesto);
    }

    @Transactional(readOnly = true)
    public List<PuestoResponse> searchByName(String descripcion) {

        return puestoRepository
                .findByAprovadoTrueAndNombreContainingIgnoreCase(descripcion.trim())
                .stream()
                .map(this::toView)
                .toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void create(CreatePuestoRequest form) {

        Empresa empresa = empresaRepository
                .findById(form.getEmpresaId())
                .orElseThrow(() -> new EmpresaNotFoundException(form.getEmpresaId()));

        Puesto puesto = new Puesto();

        puesto.setDescripcion(form.getDescripcion().trim());
        puesto.setEmpresa(empresa);
        puesto.setSalario(form.getSalario());
        puesto.setActivo(true);

        puestoRepository.save(puesto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteLogical(Long id) {

        Puesto puesto = puestoRepository
                .findById(id)
                .orElseThrow(() -> new PuestoNotFoundException(id));

        puesto.setActivo(false);

        puestoRepository.save(puesto);
    }

    private PuestoResponse toView(Puesto puesto) {

        List<HabilidadNivel> habilidades = puestoHabilidadRepository
                .findByPuesto(puesto)
                .stream()
                .map(ph -> new HabilidadNivel(
                        ph.getHabilidad().getId(),
                        ph.getNivelRequerido()
                ))
                .toList();

        return new PuestoResponse(
                puesto.getId(),
                puesto.getDescripcion(),
                puesto.getSalario(),
                puesto.isPublico(),
                puesto.isActivo(),
                puesto.getEmpresa().getNombre(),
                habilidades
        );
    }

    @Transactional(readOnly = true)
    public List<PuestoResponse> ultimos5Publicos() {

        return puestoRepository
                .findTop5ByPublicoTrueAndActivoTrueOrderByFechaDesc()
                .stream()
                .map(this::toView)
                .toList();
    }

}
