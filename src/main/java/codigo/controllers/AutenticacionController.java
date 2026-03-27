package codigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutenticacionController {
    @GetMapping("/Login")
    public String login(Model model) {
        model.addAttribute("title", "Iniciar sesión");
        return "Autenticacion/Login";
    }
    @GetMapping("/Access-denied")
    public String accessDenied(Model model) {
        model.addAttribute("title", "Access denied");
        return "Autenticacion/Access-denied";
    }
}
