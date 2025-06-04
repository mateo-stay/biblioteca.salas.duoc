package biblioteca.salas.douc.biblioteca.salas.duoc.repository;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, String> {
    // JpaRepository<Carrera, String> ya te da:
    //  - List<Carrera> findAll()
    //  - Optional<Carrera> findById(String id)
    //  - Carrera save(Carrera entidad)
    //  - void deleteById(String id)
}