package biblioteca.salas.douc.biblioteca.salas.duoc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
}