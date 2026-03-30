package codigo.services;

import codigo.dtos.habilidad.CreateHabilidadRequest;
import codigo.dtos.habilidad.HabilidadResponse;
import codigo.dtos.habilidad.UpdateHabilidadRequest;
import codigo.models.Habilidad;
import codigo.repositories.HabilidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabilidadService {


    private final HabilidadRepository habilidadRepository;

    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    public List<HabilidadResponse> getAll(){

        return habilidadRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public HabilidadResponse getById(Long id) {

        Habilidad habilidad = habilidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada"));

        return toResponse(habilidad);
    }

   public HabilidadResponse create(CreateHabilidadRequest request){

        Habilidad habilidad = new Habilidad();
        habilidad.setNombre(request.getNombre());

        if (request.getPadreId() != null) {

            Habilidad parent = habilidadRepository.findById(request.getPadreId())
                    .orElseThrow(() -> new RuntimeException("Habilidad padre no encontrada"));

            habilidad.setParent(parent);
        }

        habilidadRepository.save(habilidad);

        return toResponse(habilidad);

    }
   public HabilidadResponse update(Long id, UpdateHabilidadRequest request){

        Habilidad habilidad = habilidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada"));

        habilidad.setNombre(request.getNombre());

        habilidadRepository.save(habilidad);

        return toResponse(habilidad);

    }
    public void delete(Long id){

        Habilidad habilidad = habilidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada"));

        habilidadRepository.delete(habilidad);

    }
    private HabilidadResponse toResponse(Habilidad habilidad) {

        Long padreId = null;

        if (habilidad.getParent() != null) {
            padreId = habilidad.getParent().getId();
        }

        return new HabilidadResponse(
                habilidad.getId(),
                habilidad.getNombre(),
                padreId
        );
    }

}
