package codigo.models;

public class Usuario {
    protected String identificacion,correo, clave;
    protected boolean activo;

    public Usuario(String identificacion, String correo, String clave,boolean activo) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.clave = clave;
        this.activo = activo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
