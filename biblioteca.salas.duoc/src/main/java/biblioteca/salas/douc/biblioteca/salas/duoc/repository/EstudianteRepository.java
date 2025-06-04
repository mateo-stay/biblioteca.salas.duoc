package biblioteca.salas.douc.biblioteca.salas.duoc.repository;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    // JpaRepository<Estudiante, Integer> ya tiene:
    //   List<Estudiante> findAll()
    //   Optional<Estudiante> findById(Integer id)
    //   Estudiante save(Estudiante e)
    //   void deleteById(Integer id)
}