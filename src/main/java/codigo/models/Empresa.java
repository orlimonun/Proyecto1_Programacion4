package codigo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
@PrimaryKeyJoinColumn(name = "id")
public class Empresa extends Usuario {
    // (nombre, localización, teléfono, descripción)

    @Column(nullable = false, length = 80, unique = true)
    private String nombre;

    @Column(nullable = false, length = 80)
    private String localizacion;

    @Column(nullable = false, length = 80)
    private String telefono;

    @Column(nullable = false, length = 80)
    private String descripcion;

    public Empresa(){

    }

    public Empresa(Long id, String email, String password, Rol rol, boolean aprobado, String nombre, String localizacion, String telefono, String descripcion) {
        super(id, email, password, rol, aprobado);
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
