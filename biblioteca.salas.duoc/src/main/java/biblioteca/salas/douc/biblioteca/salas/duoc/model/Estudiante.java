package biblioteca.salas.douc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    private Integer id;
    private String run;
    private String nombres;
    private String correo;
    private Character jornada;
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "codigo_carrera")
    private Carrera carrera;

    // getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getRun() { return run; }
    public void setRun(String run) { this.run = run; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public Character getJornada() { return jornada; }
    public void setJornada(Character jornada) { this.jornada = jornada; }
    public Integer getTelefono() { return telefono; }
    public void setTelefono(Integer telefono) { this.telefono = telefono; }
    public Carrera getCarrera() { return carrera; }
    public void setCarrera(Carrera carrera) { this.carrera = carrera; }
}