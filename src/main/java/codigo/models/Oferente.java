package codigo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="oferentes")
@PrimaryKeyJoinColumn(name = "id")
public class Oferente extends Usuario{

    @Column(nullable = false, length = 80, unique = true)
    private String  nombre;

    @Column(nullable = false, length = 80, unique = true)
    String apellido;

    @Column(nullable = false, length = 80, unique = true)
    String nacionalidad;

    @Column(nullable = false, length = 80)
    String telefono;

    @Column(nullable = false, length = 80, unique = true)
    String residencia;

    public Oferente() {}


    public Oferente(Long id, String email, String password, Rol rol, boolean aprobado, String nombre, String apellido, String nacionalidad, String telefono, String residencia) {
        super(id, email, password, rol, aprobado);
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.residencia = residencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return apellido;
    }

    public void setPrimerApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }


}
