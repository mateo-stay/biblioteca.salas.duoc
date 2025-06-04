package biblioteca.salas.douc.biblioteca.salas.duoc.repository;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // findAll(), findById(Integer), save(), deleteById(Integer) ya están incluidos
}