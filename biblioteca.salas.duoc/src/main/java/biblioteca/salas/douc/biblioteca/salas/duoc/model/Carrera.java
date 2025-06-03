package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description = "Entidad que representa una carrera")
@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    private String codigo;
    private String nombre;

    // getters & setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}