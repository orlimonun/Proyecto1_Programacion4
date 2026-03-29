package codigo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "administradores")
public class Administrador extends Usuario{
    public Administrador(Long id, String correo, String clave,boolean activo) {
        super(id, correo, clave,activo);
    }


}
