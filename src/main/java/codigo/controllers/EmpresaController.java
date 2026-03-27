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
}
