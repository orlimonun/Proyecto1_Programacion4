package codigo.exceptions;

public class HabilidadNotFoundException extends RuntimeException {
    public HabilidadNotFoundException(Long id) {
        super("Habilidad no encontrada con id: " + id);
    }
}
