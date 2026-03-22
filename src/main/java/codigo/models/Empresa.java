package codigo.models;

public class Empresa extends Usuario {
    // (nombre, localización, correo electrónico, teléfono, descripción)
    private String nombre,localizacion, telefono, descripcion;

    public Empresa(String identificacion, String correo, String clave,boolean activo, String descripcion, String telefono, String localizacion, String nombre) {
        super(identificacion, correo, clave,activo);
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.localizacion = localizacion;
        this.nombre = nombre;
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
