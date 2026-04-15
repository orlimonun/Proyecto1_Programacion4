package codigo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "puestos")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 80)
    @Positive(message = "El valor debe ser mayor a 0")
    private Double salario;

    @Column(nullable = false)
    private boolean publico;

    @Column(nullable = false)
    private boolean activo = true;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "puesto")
    private List<PuestoHabilidad> habilidades;

    public Puesto(Long id, String descripcion, Double salario, boolean publico, boolean activo, LocalDateTime fecha, Empresa empresa, List<PuestoHabilidad> habilidades) {
        this.id = id;
        this.descripcion = descripcion;
        this.salario = salario;
        this.publico = publico;
        this.activo = activo;
        this.fecha = fecha;
        this.empresa = empresa;
        this.habilidades = habilidades;
    }

    public List<PuestoHabilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<PuestoHabilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public Puesto() {
    }

    @PrePersist
    public void prePersist() {
        if (fecha == null) {
            fecha = LocalDateTime.now();
        }
        activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
