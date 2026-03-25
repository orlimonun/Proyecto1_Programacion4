package codigo.controllers;



import codigo.services.OferenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Empresa")
public class OferenteController {

    private final OferenteService servicio;

    @GetMapping
    public String list(Model model){
        model.addAttribute("pageTitle", "Pagina para empresa");
        return "Oferente/Dashboard";
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("Mis habilidades",service.findAll());
        model.addAttribute("pageTitle","Mis Habilidades");

        return "Oferente/MisHabilidades";
    }
    @GetMapping("/{id}")
    public String detail(){



    }


}
