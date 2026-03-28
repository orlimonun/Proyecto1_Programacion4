package codigo.dtos.empresa;

public record EmpresaResponse(
        Long identificacion,
        String correo,
        boolean activo,
        String descripcion,
        String telefono,
        String localizacion,
        String nombre
) {}
