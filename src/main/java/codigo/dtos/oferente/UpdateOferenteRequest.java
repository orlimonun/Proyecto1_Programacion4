package codigo.dtos.oferente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateOferenteRequest {

    @NotBlank(message = "Id number required")
    @Size(min = 9, max = 9, message = "Id number must be composed by 9 digits")
    String identificacion;

    @NotBlank(message = "An email is required")
    @Size(min = 10, max = 100, message = "Product name must be between 2 and 100 characters")
    String correo ;

    @NotBlank(message = "Password is required")
    @Size(min = 2, max = 100, message = "Password name must be between 5 and 100 characters")
    String clave ;

    @NotBlank(message = "A name is required")
    String nombre ;

    @NotBlank(message = "LastName is required")
    String primerApellido;

    @NotBlank(message = "Nacionality is required")
    String nacionalidad ;

    @NotBlank(message = "Phone Number  is required")
    @Size(min = 2, max = 20, message = "Product name must be between 2 and 20 characters")
    String telefono ;

    @NotBlank(message = "Local Residence is required")
    @Size(min = 2, max = 1000, message = "Product name must be between 2 and 100 characters")
    String residencia;

    public UpdateOferenteRequest() {
    }

    public UpdateOferenteRequest(String identificacion, String correo, String clave, String nombre, String primerApellido, String nacionalidad, String telefono, String residencia) {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
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
