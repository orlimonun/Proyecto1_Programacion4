package codigo.controllers;


import codigo.services.ReporteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministradorController {

    private final ReporteService reporteService;

    public AdministradorController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/Admin")
    public String admin(Model model) {
        model.addAttribute("title", "Admin");
        return "Administrador/Dashboard";
    }

    @GetMapping("/admin/Reportes")
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
/*
import codigo.services.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Administrador")
public class AdministradorController {
    private final AdministradorService service;

    public AdministradorController(AdministradorService service){
        this.service = service;
    }

    @GetMapping("/EmpresasPendientes")
    public String EmpresasPendientes(@PathVariable String id, Model model){
        //crear metodo en service
        model.addAttribute("Empresa",service.getAdministradorById(id));
        model.addAttribute("pageTitle","Detalles de Empresa");

        return "Administrador/EmpresasPendientes";
    }
    @GetMapping("/AgregarCaracteristicas")
    public String agregarCaracteristica(Model model){
        model.addAttribute()
    }
}
*/