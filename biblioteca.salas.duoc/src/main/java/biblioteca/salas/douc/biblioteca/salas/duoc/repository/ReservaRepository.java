package biblioteca.salas.douc.biblioteca.salas.duoc.repository;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findBySalaId(Integer salaId);

    List<Reserva> findByFechaSolicitada(Date fecha);

    List<Reserva> findByEstado(Integer estado);

    List<Reserva> findByFechaSolicitadaBetween(Date inicio, Date fin);

    long countByEstudianteId(Integer estudianteId);
}
