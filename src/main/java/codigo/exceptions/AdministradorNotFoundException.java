package codigo.exceptions;

public class AdministradorNotFoundException extends RuntimeException {

    public AdministradorNotFoundException(Long id) {
        super("Administrador with id " + id + " not found");
    }


}
