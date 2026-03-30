package codigo.controllers;


import codigo.dtos.habilidad.CreateHabilidadRequest;
import codigo.services.AdministradorService;
import codigo.services.HabilidadService;
import codigo.services.ReporteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/Administrador")
public class AdministradorController {

    private final AdministradorService adminService;
    private final HabilidadService habilidadService;
    private final ReporteService reporteService;

    public AdministradorController(AdministradorService adminService,
                                   HabilidadService habilidadService,
                                   ReporteService reporteService) {
        this.adminService = adminService;
        this.habilidadService = habilidadService;
        this.reporteService = reporteService;
    }


    @GetMapping("/Admin")
    public String admin(Model model) {
        model.addAttribute("title", "Admin");
        return "Administrador/Dashboard";
    }


    @GetMapping("/EmpresasPendientes")
    public String empresasPendientes() {
        return "Administrador/EmpresasPendientes";
    }


    @GetMapping("/OferentesPendientes")
    public String oferentesPendientes() {
        return "Administrador/OferentesPendientes";
    }


    @PostMapping("/aprobarEmpresa")
    public String aprobarEmpresa(@RequestParam Long id) {

        adminService.aprobarEmpresa(id);

        return "redirect:/Administrador/EmpresasPendientes";
    }


    @PostMapping("/aprobarOferente")
    public String aprobarOferente(@RequestParam Long id) {

        adminService.aprobarOferente(id);

        return "redirect:/Administrador/OferentesPendientes";
    }


    @GetMapping("/Caracteristicas")
    public String habilidades(Model model) {

        model.addAttribute("habilidades", habilidadService.getAll());

        return "Administrador/Caracteristicas";
    }


    @GetMapping("/Caracteristicas/nueva")
    public String nuevaHabilidad(Model model) {

        model.addAttribute("habilidad", new CreateHabilidadRequest());

        return "Administrador/AgregarCaracteristicas";
    }

    @PostMapping("/Caracteristicas")
    public String guardarHabilidad(@ModelAttribute CreateHabilidadRequest request) {

        habilidadService.create(request);

        return "redirect:/Administrador/Caracteristicas";
    }


    @GetMapping("/Admin/Reportes")
    public ResponseEntity<byte[]> generarReporte(
            @RequestParam int mes,
            @RequestParam int anio) {

        byte[] pdf = reporteService.generarReportePuestosPorMes(mes, anio);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=reporte_puestos.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
