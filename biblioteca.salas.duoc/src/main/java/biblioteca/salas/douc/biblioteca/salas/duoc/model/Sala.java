package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoSala tipoSala;   // este es el único campo de tipo TipoSala

    // getters & setters
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
