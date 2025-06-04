package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Schema(description = "Entidad que representa una reserva de sala realizada por un estudiante")
@Entity
@Table(name = "reserva")
public class Reserva {

    @Schema(
        description = "ID de la reserva",
        example = "100"
    )
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    @Schema(description = "Estudiante que hace la reserva")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    @Schema(description = "Sala que se reserva")
    private Sala sala;

    @Schema(
        description = "Fecha y hora en que se solicitó la reserva",
        example = "2025-06-03T10:00:00Z"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitada;

    @Schema(
        description = "Hora de inicio de la reserva",
        example = "2025-06-03T10:00:00Z"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSolicitada;

    @Schema(
        description = "Hora de cierre de la reserva",
        example = "2025-06-03T12:00:00Z"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaCierre;

    @Schema(
        description = "Estado de la reserva (0 = pendiente, 1 = aprobada, 2 = rechazada)",
        example = "1"
    )
    private Integer estado;

    public Reserva() { }

    public Reserva(Integer id, Estudiante estudiante, Sala sala, Date fechaSolicitada, Date horaSolicitada, Date horaCierre, Integer estado) {
        this.id = id;
        this.estudiante = estudiante;
        this.sala = sala;
        this.fechaSolicitada = fechaSolicitada;
        this.horaSolicitada = horaSolicitada;
        this.horaCierre = horaCierre;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }
    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public Date getHoraSolicitada() {
        return horaSolicitada;
    }
    public void setHoraSolicitada(Date horaSolicitada) {
        this.horaSolicitada = horaSolicitada;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }
    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Integer getEstado() {
        return estado;
    }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
