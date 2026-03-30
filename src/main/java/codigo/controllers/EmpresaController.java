package codigo.controllers;

import codigo.dtos.puesto.CreatePuestoRequest;
import codigo.services.EmpresaService;
import codigo.services.MatchingService;
import codigo.services.PuestoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Empresa")
public class EmpresaController {

    private final EmpresaService empresaService;
    private final PuestoService puestoService;
    private final MatchingService matchingService;

    public EmpresaController(EmpresaService empresaService,
                             PuestoService puestoService,
                             MatchingService matchingService) {
        this.empresaService = empresaService;
        this.puestoService = puestoService;
        this.matchingService = matchingService;
    }

    @GetMapping("/Empresa")
    public String empresa(Model model) {
        model.addAttribute("title", "Empresa");
        return "Empresa/Dashboard";
    }
    @GetMapping("/puestos")
    public String misPuestos(Model model) {

        var empresa = empresaService.getEmpresaActual();

        model.addAttribute("puestos",
                puestoService.findById(empresa.getId()));

        return "Empresa/MisPuestos";
    }

    @GetMapping("/Empresa/Puestos/{id}/Ver")
    public String ver(@PathVariable Long id, Model model) {
        model.addAttribute("candidatos", matchingService.buscarCandidatos(id));
        return "Empresa/BuscarCandidatos";
    }

    @GetMapping("/Empresa/Puestos/Detalle/{id}")
    public String detalle(Model model,Long id) {
        model.addAttribute("candidato", matchingService.getDetalleCandidato(id));
        return "Empresa/VerDetalleCandidato";
    }
    @GetMapping("/Empresa/Publicar")
    public String publicarPuesto(Model model) {
        model.addAttribute("title", "Empresa - Publicar Puesto");
        model.addAttribute("puesto", new CreatePuestoRequest());
        return "Empresa/PublicarPuesto";
    }
    @PostMapping("/Empresa/Publicar")
    public String guardarPuesto(
            @ModelAttribute CreatePuestoRequest request) {

        var empresa = empresaService.getEmpresaActual();

        empresaService.publicarPuesto(empresa.getId(), request);

        return "redirect:/puestos";
    }
}
