package codigo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "oferente_habilidad")
public class OferenteHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "oferente_id")
    private Oferente oferente;

    @ManyToOne
    @JoinColumn(name = "habilidad_id")
    private Habilidad habilidad;

    @Column(nullable = false)
    @Size(min = 1 ,max = 5)
    private int nivel;

    public OferenteHabilidad(Long id, Oferente oferente, Habilidad habilidad, int nivel) {
        this.id = id;
        this.oferente = oferente;
        this.habilidad = habilidad;
        this.nivel = nivel;
    }

    public OferenteHabilidad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Oferente getOferente() {
        return oferente;
    }

    public void setOferente(Oferente oferente) {
        this.oferente = oferente;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
