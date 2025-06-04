package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Entidad que representa una sala física donde se pueden hacer reservas")
@Entity
@Table(name = "sala")
public class Sala {

    @Schema(
        description = "ID de la sala (autogenerado)",
        example = "10"
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(
        description = "Nombre o número identificador de la sala",
        example = "Sala 1"
    )
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    @Schema(description = "Tipo de sala (relación con TipoSala)")
    private TipoSala tipoSala;

    public Sala() { }

    public Sala(Integer id, String nombre, TipoSala tipoSala) {
        this.id = id;
        this.nombre = nombre;
        this.tipoSala = tipoSala;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }
    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }
}
