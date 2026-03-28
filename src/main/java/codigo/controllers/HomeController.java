package codigo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class HomeController {


    @GetMapping("/home")
    public String home() {
        return "Private Home";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String admin(Model model) {
        model.addAttribute("title", "Admin");
        return "admin/dashboard";
    }
//implementar
    @GetMapping("/BuscarPuesto")
}
