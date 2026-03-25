package codigo.exceptions;

public class PuestoNotFoundException extends RuntimeException {
    public PuestoNotFoundException(Long id) {
        super("Puesto no encontrado con id: " + id);
    }
}
