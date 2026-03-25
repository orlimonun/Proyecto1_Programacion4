package codigo.dtos.puesto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UpdatePuestoRequest {

    @Size(min = 5, max = 1000, message = "La descripción debe tener entre 5 y 1000 caracteres")
    private String descripcion;

    @Positive(message = "El salario debe ser mayor a 0")
    private Double salario;

    private Boolean publico;
    private Boolean activo;

    public UpdatePuestoRequest() {}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}