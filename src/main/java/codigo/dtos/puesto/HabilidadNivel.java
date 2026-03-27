package codigo.dtos.puesto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class HabilidadNivel {

    public HabilidadNivel(Long habilidadId, int nivel) {
        this.habilidadId = habilidadId;
        this.nivel = nivel;
    }

    public HabilidadNivel() {
    }

    @NotNull(message = "El id de la habilidad es obligatorio")
    private Long habilidadId;

    @Min(value = 1, message = "El nivel mínimo es 1")
    private int nivel;

    public Long getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(Long habilidadId) {
        this.habilidadId = habilidadId;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}