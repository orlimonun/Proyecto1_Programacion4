package codigo.repositories;


import codigo.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<Usuario,Long> {

    Usuario findByCorreo(String Correo);

}
