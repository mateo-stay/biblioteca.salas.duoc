package biblioteca.salas.douc.biblioteca.salas.duoc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}