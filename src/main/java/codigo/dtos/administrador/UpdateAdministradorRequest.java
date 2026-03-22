package codigo.dtos.administrador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateAdministradorRequest {
    @NotBlank(message = "Id number required")
    @Size(min = 9, max = 9, message = "Id number must be composed by 9 digits")
    private String identificacion;

    @NotBlank(message = "An email is required")
    @Size(min = 10, max = 100, message = "Product name must be between 2 and 100 characters")
    private String correo ;

    @NotBlank(message = "Password is required")
    @Size(min = 2, max = 100, message = "Password name must be between 5 and 100 characters")
    private String clave ;

    public UpdateAdministradorRequest(String identificacion, String correo, String clave) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.clave = clave;
    }

    public UpdateAdministradorRequest() {
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
}
