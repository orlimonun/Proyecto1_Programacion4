package codigo.controllers;

import org.springframework.security.core.Authentication;
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
    @GetMapping("/redirect")
    public String redirect(Authentication auth) {

        String rol = auth.getAuthorities().iterator().next().getAuthority();

        switch (rol) {
            case "ROLE_ADMIN":
                return "redirect:/Administrador/Dashboard";
            case "ROLE_EMPRESA":
                return "redirect:/Empresa/Dashboard";
            case "ROLE_OFERENTE":
                return "redirect:/Oferente/Dashboard";
            default:
                return "redirect:/";
        }
    }

}
