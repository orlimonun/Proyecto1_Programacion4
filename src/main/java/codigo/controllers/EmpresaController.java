package codigo.controllers;

import codigo.services.EmpresaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Empresa")
public class EmpresaController {

    private final EmpresaService servicio;

    @GetMapping
    public String list(Model model){
        model.addAttribute("pageTitle", "Pagina para empresa");
        return "Empresa/Dashboard";
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("Mis Puestos",service.findAll());
        model.addAttribute("pageTitle","Mis Puestos");

        return "Empresa/MisPuestos";
    }
    @GetMapping("/{id}")
    public String detail(){



    }
