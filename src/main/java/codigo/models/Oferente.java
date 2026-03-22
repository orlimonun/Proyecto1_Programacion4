package codigo.models;

public class Oferente extends Usuario{
    private String  nombre, primerApellido, nacionalidad, telefono,residencia;

    public Oferente(String identificacion, String correo, String clave, boolean activo, String nombre, String primerApellido, String nacionalidad, String telefono, String residencia) {
        super(identificacion, correo, clave,activo);
        this.nombre = nombre;
        this.primerApellido = primerApellido;
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
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
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
