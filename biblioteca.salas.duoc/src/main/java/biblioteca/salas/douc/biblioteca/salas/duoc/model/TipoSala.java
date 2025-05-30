package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_sala")
public class TipoSala {
    @Id
    private Integer idTipo;
    private String nombre;

    // getters & setters
    public Integer getIdTipo() { return idTipo; }
    public void setIdTipo(Integer idTipo) { this.idTipo = idTipo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}