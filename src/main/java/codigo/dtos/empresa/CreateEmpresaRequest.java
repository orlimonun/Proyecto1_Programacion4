package codigo.dtos.empresa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateEmpresaRequest {

    @NotNull(message = "El id es obligatorio")
    private Long identificacion;

    @NotBlank(message = "An email is required")
    @Size(min = 10, max = 100, message = "Product name must be between 2 and 100 characters")
    @Email(message = "correo invalido")
    private String correo ;

    @NotBlank(message = "Password is required")
    @Size(min = 2, max = 100, message = "Password name must be between 5 and 100 characters")
    private String clave ;

    @NotBlank(message = "A description is required")
    @Size(min = 2, max = 1000, message = "The description must be between 2 and 1000 characters")
    private String descripcion;

    @NotBlank(message = "Phone Number  is required")
    @Size(min = 2, max = 20, message = "The phone number must be between 2 and 20 characters")
    private String telefono ;

    @NotBlank(message = "Location is required")
    @Size(min = 2, max = 1000, message = "The direction must be between 2 and 1000 characters")
    private String localizacion;

    @NotBlank(message = "A name is required")
    private String nombre;

    public CreateEmpresaRequest(Long identificacion, String correo, String clave, String descripcion, String telefono, String localizacion, String nombre) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.clave = clave;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.localizacion = localizacion;
        this.nombre = nombre;
    }

    public CreateEmpresaRequest() {
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
