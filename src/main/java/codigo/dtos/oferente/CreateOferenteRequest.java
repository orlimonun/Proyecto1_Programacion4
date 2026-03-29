package codigo.dtos.oferente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateOferenteRequest {

    @NotNull(message = "El id es obligatorio")
    private Long identificacion;

    @NotBlank(message = "An email is required")
    @Size(min = 10, max = 100, message = "Product name must be between 2 and 100 characters")
    private String correo ;

    @NotBlank(message = "Password is required")
    @Size(min = 2, max = 100, message = "Password name must be between 5 and 100 characters")
    private String clave ;

    @NotBlank(message = "A name is required")
    private String nombre ;

    @NotBlank(message = "LastName is required")
    private  String primerApellido;

    @NotBlank(message = "Nacionality is required")
    private String nacionalidad ;

    @NotBlank(message = "Phone Number  is required")
    @Size(min = 2, max = 20, message = "The phone number must be between 2 and 20 characters")
    private String telefono ;

    @NotBlank(message = "Local Residence is required")
    @Size(min = 2, max = 1000, message = "Location must be between 2 and 100 characters")
    private String residencia;





    public CreateOferenteRequest() {
    }

    public CreateOferenteRequest(Long identificacion, String correo, String clave, String nombre, String primerApellido, String nacionalidad, String telefono, String residencia) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.residencia = residencia;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }
}
