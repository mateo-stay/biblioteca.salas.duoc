package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description = "Entidad que representa un tipo de sala (p. ej. Laboratorio, Aula magna, etc.)")
@Entity
@Table(name = "tipo_sala")
public class TipoSala {

    @Schema(
        description = "ID del tipo de sala",
        example = "1"
    )
    @Id
    private Integer idTipo;

    @Schema(
        description = "Nombre o descripción del tipo de sala",
        example = "Laboratorio"
    )
    private String nombre;

    public TipoSala() { }

    public TipoSala(Integer idTipo, String nombre) {
        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public Integer getIdTipo() {
        return idTipo;
    }
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
