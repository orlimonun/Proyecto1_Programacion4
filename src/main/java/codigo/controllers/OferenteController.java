package codigo.controllers;



import codigo.models.Usuario;
import codigo.services.ArchivoService;
import codigo.services.OferenteService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class OferenteController {

    private final OferenteService servicio;

    private final ArchivoService archivoService;

    public OferenteController(OferenteService servicio, ArchivoService archivoService) {
        this.servicio = servicio;
        this.archivoService = archivoService;
    }

    @GetMapping("/Oferente")
    public String Oferente(Model model){
        model.addAttribute("pageTitle", "Pagina para empresa");
        return "Oferente/Dashboard";
    }

    @GetMapping("/habilidades")
    public String list(Model model,Long id){
        model.addAttribute("Mis habilidades",servicio.listarHabilidades(id));
        model.addAttribute("pageTitle","Mis Habilidades");

        return "Oferente/MisHabilidades";
    }

    @PostMapping("/Oferente/SubirCC")
    public String subirCV(
            @RequestParam("archivo") MultipartFile archivo,
            @AuthenticationPrincipal Usuario user) {

        Long oferenteId = user.getId();

        archivoService.guardarCV(archivo, oferenteId);

        return "redirect:/Oferente/Dashboard";
    }
    @PostMapping("/MisHabilidades")
    public String agregarHabilidad(
            @RequestParam Long habilidadId,
            @RequestParam int nivel,
            @AuthenticationPrincipal Usuario user) {

        Long oferenteId = user.getId();

        servicio.agregarHabilidad(oferenteId, habilidadId, nivel);

        return "redirect:/Oferente/habilidades";
    }

}
