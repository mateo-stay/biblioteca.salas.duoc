package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description = "Entidad que representa una carrera académica en el sistema")
@Entity
@Table(name = "carrera")
public class Carrera {

    @Schema(
        description = "Código único de la carrera",
        example = "ING",
        minLength = 1,
        maxLength = 10
    )
    @Id
    private String codigo;

    @Schema(
        description = "Nombre completo de la carrera",
        example = "Ingeniería en Informática",
        minLength = 3,
        maxLength = 100
    )
    private String nombre;

    public Carrera() { }

    public Carrera(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
