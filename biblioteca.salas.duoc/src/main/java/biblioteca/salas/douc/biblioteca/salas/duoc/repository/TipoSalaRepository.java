package biblioteca.salas.douc.biblioteca.salas.duoc.repository;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.TipoSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSalaRepository extends JpaRepository<TipoSala, Integer> {
    // hereda findAll(), findById(Integer), save(), deleteById(Integer)
}