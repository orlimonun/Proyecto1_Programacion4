package codigo.controllers;

import codigo.dtos.empresa.CreateEmpresaRequest;
import codigo.dtos.oferente.CreateOferenteRequest;
import codigo.services.EmpresaService;
import codigo.services.OferenteService;
import codigo.services.PuestoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/public")
public class PublicController {

    private final EmpresaService empresaService;
    private final PuestoService puestoService;
    private final OferenteService oferenteService;

    public PublicController(PuestoService puestoService, EmpresaService empresaService, OferenteService oferenteService) {
        this.puestoService = puestoService;
        this.empresaService = empresaService;
        this.oferenteService = oferenteService;
    }

    @GetMapping("/home")
    public String home(){return "Public Home";}

    @GetMapping("/Index")
    public String index(Model model) {
        model.addAttribute("title", "Inicio");
        return "Publico/Index";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) String q, Model model) {

        if (q != null && !q.isBlank()) {
            model.addAttribute("puestos", puestoService.searchByName(q));
        } else {
            model.addAttribute("puestos", puestoService.findAll());
        }

        return "Publico/BuscarPuesto";
    }

    @GetMapping("/BuscarPuesto")
    public String buscarPuesto(Model model) {
        model.addAttribute("title", "Buscar-Puesto");
        return "Publico/BuscarPuesto";
    }

    @GetMapping("/puesto/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        model.addAttribute("puesto", puestoService.findById(id));
        return "Publico/PuestoRegistrado";
    }

    @GetMapping("/Empresa/Registro")
    public String registroEmpresa(Model model) {
        model.addAttribute("title", "Registrar - Empresa");
        model.addAttribute("empresa", new CreateEmpresaRequest());
        return "Publico/RegistroEmpresa";
    }

    @GetMapping("/Oferente/Registro")
    public String registroOferente(Model model) {
        model.addAttribute("title", "Registrar - Oferente");
        model.addAttribute("oferente", new CreateOferenteRequest());
        return "Publico/RegistroOferente";
    }
    @PostMapping("/Empresa/Registro")
    public String registrarEmpresa(@ModelAttribute CreateEmpresaRequest request) {

        empresaService.registrar(request);

        return "redirect:/public/Index";
    }

    @PostMapping("/Oferente/Registro")
    public String registrarOferente(@ModelAttribute CreateOferenteRequest request) {

        oferenteService.createOferente(request);

        return "redirect:/public/Index";
    }

}
