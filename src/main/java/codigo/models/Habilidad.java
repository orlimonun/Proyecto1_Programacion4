package codigo.models;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "habilidades")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Habilidad parent;

    @OneToMany(mappedBy = "parent")
    private List<Habilidad> subHabilidades;

    public Habilidad(Long id, String nombre, Habilidad parent, List<Habilidad> subHabilidades) {
        this.id = id;
        this.nombre = nombre;
        this.parent = parent;
        this.subHabilidades = subHabilidades;
    }

    public Habilidad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Habilidad getParent() {
        return parent;
    }

    public void setParent(Habilidad parent) {
        this.parent = parent;
    }

    public List<Habilidad> getSubHabilidades() {
        return subHabilidades;
    }

    public void setSubHabilidades(List<Habilidad> subHabilidades) {
        this.subHabilidades = subHabilidades;
    }
}
