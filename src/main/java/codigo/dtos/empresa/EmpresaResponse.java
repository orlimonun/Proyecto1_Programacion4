package codigo.dtos.empresa;

public record EmpresaResponse(
        String identificacion,
        String correo,
        boolean activo,
        String descripcion,
        String telefono,
        String localizacion,
        String nombre
) {}
