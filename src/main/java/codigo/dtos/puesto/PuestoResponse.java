package codigo.dtos.puesto;




import java.util.List;

public record PuestoResponse(
        Long id,
        String descripcion,
        Double salario,
        boolean publico,
        boolean activo,
        String empresaNombre,
        List<HabilidadNivel> habilidades
) {}
