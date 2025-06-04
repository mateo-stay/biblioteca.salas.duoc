package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Entidad que representa a un estudiante del sistema")
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Schema(
        description = "ID único del estudiante",
        example = "1"
    )
    @Id
    private Integer id;

    @Schema(
        description = "RUN o número de identificación válido",
        example = "12.345.678-9",
        minLength = 5,
        maxLength = 12
    )
    private String run;

    @Schema(
        description = "Nombre completo del estudiante",
        example = "Juan Pérez",
        minLength = 2
    )
    private String nombres;

    @Schema(
        description = "Correo electrónico del estudiante",
        example = "juan.perez@duoc.cl",
        format = "email"
    )
    private String correo;

    @Schema(
        description = "Jornada de estudio: 'D' para diurna o 'N' para nocturna",
        example = "D"
    )
    private Character jornada;

    @Schema(
        description = "Teléfono de contacto (9 dígitos)",
        example = "912345678",
        minimum = "100000000",
        maximum = "999999999"
    )
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "codigo_carrera")
    @Schema(description = "Carrera a la que pertenece el estudiante")
    private Carrera carrera;

    public Estudiante() { }

    public Estudiante(Integer id, String run, String nombres, String correo, Character jornada, Integer telefono, Carrera carrera) {
        this.id = id;
        this.run = run;
        this.nombres = nombres;
        this.correo = correo;
        this.jornada = jornada;
        this.telefono = telefono;
        this.carrera = carrera;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRun() {
        return run;
    }
    public void setRun(String run) {
        this.run = run;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Character getJornada() {
        return jornada;
    }
    public void setJornada(Character jornada) {
        this.jornada = jornada;
    }

    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Carrera getCarrera() {
        return carrera;
    }
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
