package codigo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "puesto_habilidades")
public class PuestoHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "puesto_id")
    private Puesto puesto;

    @ManyToOne
    @JoinColumn(name = "habilidad_id")
    private Habilidad habilidad;

    @Column(nullable = false)
    @Size(min = 1 ,max = 5)
    private int nivelRequerido;

}
