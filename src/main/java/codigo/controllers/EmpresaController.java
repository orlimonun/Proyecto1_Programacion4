package codigo.controllers;

import codigo.services.ArchivoService;
import codigo.services.EmpresaService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Empresa")
public class EmpresaController {

    private final EmpresaService servicio;
    private final ArchivoService archivoService;



    public EmpresaController(EmpresaService servicio,ArchivoService archivoService) {
        this.servicio = servicio;
        this.archivoService = archivoService;
    }


    @GetMapping
    public String Empresa(Model model){
        model.addAttribute("pageTitle", "Pagina para empresa");
        return "Empresa/Dashboard";
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("Mis Puestos",servicio.findAll());
        model.addAttribute("pageTitle","Mis Puestos");

        return "Empresa/MisPuestos";
    }
    @GetMapping("/{id}")
    public String detail(){

    }

    @GetMapping("/cv/{oferenteId}")
    public ResponseEntity<Resource> verCV(@PathVariable Long oferenteId) {

        Resource file = archivoService.obtenerCV(oferenteId);

        return ResponseEntity.ok()
                .header("Content-Disposition", "inline; filename=cv.pdf")
                .body(file);
    }

    //implementar
    @GetMapping("/BuscarCandidatos/{puestoId}")

    @GetMapping("/VerDetalleCandidato/{id}")

    @PostMapping("/desactivarPuesto/{id}")
