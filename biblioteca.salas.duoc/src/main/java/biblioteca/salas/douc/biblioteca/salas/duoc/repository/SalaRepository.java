package biblioteca.salas.douc.biblioteca.salas.duoc.repository;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
    // JpaRepository<Sala, Integer> ya provee findAll(), findById(Integer), save(), deleteById(Integer)
}