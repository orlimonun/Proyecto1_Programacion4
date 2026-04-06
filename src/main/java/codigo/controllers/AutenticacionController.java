package codigo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutenticacionController {
    @GetMapping("/login")
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

        if (auth == null || auth.getAuthorities().isEmpty()) {
            return "redirect:/login";
        }

        String rol = auth.getAuthorities().iterator().next().getAuthority();

        if ("ROLE_ADMIN".equals(rol)) {
            return "redirect:/Administrador/Dashboard";
        } else if ("ROLE_EMPRESA".equals(rol)) {
            return "redirect:/Empresa/Dashboard";
        } else if ("ROLE_OFERENTE".equals(rol)) {
            return "redirect:/Oferente/Dashboard";
        }

        return "redirect:/";
    }

}
