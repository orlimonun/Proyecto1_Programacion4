package codigo.dtos.puesto;

import jakarta.validation.constraints.*;
import java.util.List;

public class CreatePuestoRequest {

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 5, max = 1000, message = "La descripción debe tener entre 5 y 1000 caracteres")
    private String descripcion;

    @NotNull(message = "El salario es obligatorio")
    @Positive(message = "El salario debe ser mayor a 0")
    private Double salario;

    private boolean publico;

    @NotEmpty(message = "Debe incluir al menos una habilidad")
    private List<HabilidadNivel> habilidades;

    public CreatePuestoRequest() {}

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

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public List<HabilidadNivel> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<HabilidadNivel> habilidades) {
        this.habilidades = habilidades;
    }
}