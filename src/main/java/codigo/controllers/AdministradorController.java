package codigo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {
    @GetMapping("/Admin")
    public String admin(Model model) {
        model.addAttribute("title", "Admin");
        return "Administrador/Dashboard";
    }
}
/*
import codigo.services.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Administrador")
public class AdministradorController {
    private final AdministradorService service;

    public AdministradorController(AdministradorService service){
        this.service = service;
    }

    @GetMapping("/EmpresasPendientes")
    public String EmpresasPendientes(@PathVariable String id, Model model){
        //crear metodo en service
        model.addAttribute("Empresa",service.getAdministradorById(id));
        model.addAttribute("pageTitle","Detalles de Empresa");

        return "Administrador/EmpresasPendientes";
    }
    @GetMapping("/AgregarCaracteristicas")
    public String agregarCaracteristica(Model model){
        model.addAttribute()
    }
}
*/