package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitada;

    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSolicitada;

    @Temporal(TemporalType.TIMESTAMP)
    private Date horaCierre;

    private Integer estado;

    // getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
    public Date getFechaSolicitada() { return fechaSolicitada; }
    public void setFechaSolicitada(Date fechaSolicitada) { this.fechaSolicitada = fechaSolicitada; }
    public Date getHoraSolicitada() { return horaSolicitada; }
    public void setHoraSolicitada(Date horaSolicitada) { this.horaSolicitada = horaSolicitada; }
    public Date getHoraCierre() { return horaCierre; }
    public void setHoraCierre(Date horaCierre) { this.horaCierre = horaCierre; }
    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
}