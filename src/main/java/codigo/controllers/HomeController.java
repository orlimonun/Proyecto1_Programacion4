package codigo.controllers;

import codigo.services.PuestoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller

public class HomeController {

    private final PuestoService puestoService;

    public HomeController(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    @GetMapping("/")
    public String index(Model model) {

        // últimos 5 puestos públicos
       model.addAttribute("puestos", puestoService.ultimos5Publicos());

        return "Publico/Index";
    }

}
