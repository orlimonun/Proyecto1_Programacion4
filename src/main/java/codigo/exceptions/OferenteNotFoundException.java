package codigo.exceptions;

public class OferenteNotFoundException extends RuntimeException {
    public OferenteNotFoundException(Long id) {
        super("Oferente with id " + id + " not found");
    }
}
