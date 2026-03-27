package codigo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
//borrar lo de Administrador
@Entity
@Table(name = "administradores")
public class Administrador extends Usuario{
    public Administrador(String identificacion, String correo, String clave,boolean activo) {
        super(identificacion, correo, clave,activo);
    }


}
