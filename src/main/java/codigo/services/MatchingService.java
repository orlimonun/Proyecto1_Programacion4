package codigo.services;


import codigo.dtos.oferente.OferenteResponse;
import codigo.models.Oferente;
import codigo.models.OferenteHabilidad;
import codigo.models.Puesto;
import codigo.models.PuestoHabilidad;
import codigo.repositories.IOferenteRepository;
import codigo.repositories.IPuestoRepository;
import codigo.repositories.OferenteHabilidadRepository;
import codigo.repositories.PuestoHabilidadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchingService {


    private final IPuestoRepository puestoRepository;
    private final PuestoHabilidadRepository puestoHabilidadRepository;
    private final IOferenteRepository oferenteRepository;
    private final OferenteHabilidadRepository oferenteHabilidadRepository;

    public MatchingService(
            IPuestoRepository puestoRepository,
            PuestoHabilidadRepository puestoHabilidadRepository,
            IOferenteRepository oferenteRepository,
            OferenteHabilidadRepository oferenteHabilidadRepository) {

        this.puestoRepository = puestoRepository;
        this.puestoHabilidadRepository = puestoHabilidadRepository;
        this.oferenteRepository = oferenteRepository;
        this.oferenteHabilidadRepository = oferenteHabilidadRepository;
    }

   public  List<OferenteResponse> buscarCandidatos(Long puestoId){

        Puesto puesto = puestoRepository.findById(puestoId)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        List<PuestoHabilidad> habilidadesPuesto =
                puestoHabilidadRepository.findByPuesto(puesto);

        List<Oferente> oferentes = oferenteRepository.findAll();

        List<OferenteResponse> candidatos = new ArrayList<>();

        for (Oferente oferente : oferentes) {

            List<OferenteHabilidad> habilidadesOferente =
                    oferenteHabilidadRepository.findByOferente(oferente);

            boolean cumple = true;

            for (PuestoHabilidad req : habilidadesPuesto) {

                boolean habilidadCumplida = false;

                for (OferenteHabilidad hab : habilidadesOferente) {

                    if (hab.getHabilidad().getId()
                            .equals(req.getHabilidad().getId())
                            &&
                            hab.getNivel() >= req.getNivelRequerido()) {

                        habilidadCumplida = true;
                        break;
                    }
                }

                if (!habilidadCumplida) {
                    cumple = false;
                    break;
                }
            }

            if (cumple) {

                OferenteResponse response = new OferenteResponse(oferente.getId(),oferente.getEmail(), oferente.getPassword(), oferente.isAprobado(),
                        oferente.getNombre(), oferente.getPrimerApellido(), oferente.getNacionalidad(),oferente.getTelefono(),oferente.getResidencia() );

                candidatos.add(response);
            }
        }

        return candidatos;

    }

    public OferenteResponse getDetalleCandidato(Long oferenteId) {

        Oferente oferente = oferenteRepository.findById(oferenteId)
                .orElseThrow(() -> new RuntimeException("Oferente no encontrado"));

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
