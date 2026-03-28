package codigo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    public PublicController() {
    }

    @GetMapping("/home")
    public String home(){return "Public Home";}

    @GetMapping("/Index")
    public String index(Model model) {
        model.addAttribute("title", "Inicio");
        return "Publico/Index";
    }
    @GetMapping("/BuscarPuesto")
    public String buscarPuesto(Model model) {
        model.addAttribute("title", "Buscar-Puesto");
        return "Publico/BuscarPuesto";
    }
}
