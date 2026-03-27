package codigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OferenteController {
    @GetMapping("/Oferente")
    public String oferente(Model model) {
        model.addAttribute("title", "Oferente");
        return "Oferente/Dashboard";
    }
}
