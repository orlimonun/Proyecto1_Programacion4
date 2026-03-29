package codigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {
    @GetMapping("/Empresa")
    public String empresa(Model model) {
        model.addAttribute("title", "Empresa");
        return "Empresa/Dashboard";
    }
    @GetMapping("/Empresa/Puestos")
    public String puestos(Model model) {
        model.addAttribute("title", "Empresa - Mis Puestos");
        return "Empresa/MisPuestos";
    }

    @GetMapping("/Empresa/Puestos/ver")
    public String ver(Model model) {
        model.addAttribute("title", "Empresa - Candidatos");
        return "Empresa/BuscarCandidatos";
    }

    @GetMapping("/Empresa/Puestos/detalle")
    public String detalle(Model model) {
        model.addAttribute("title", "Empresa - Detalle Candidato");
        return "Empresa/VerDetalleCandidato";
    }


}
