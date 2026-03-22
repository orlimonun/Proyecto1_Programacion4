package codigo.exceptions;

public class EmpresaNotFoundException extends RuntimeException {
    public EmpresaNotFoundException(Long id) {
        super("Empresa with id " + id + " not found");
    }

}
