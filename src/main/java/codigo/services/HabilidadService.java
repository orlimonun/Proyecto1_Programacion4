package codigo.services;

import codigo.dtos.habilidad.CreateHabilidadRequest;
import codigo.dtos.habilidad.HabilidadResponse;
import codigo.dtos.habilidad.UpdateHabilidadRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService {
    List<HabilidadResponse> getAll(){}
    HabilidadResponse create(CreateHabilidadRequest request){}
    HabilidadResponse update(Long id, UpdateHabilidadRequest request){}
    void delete(Long id){}

}
