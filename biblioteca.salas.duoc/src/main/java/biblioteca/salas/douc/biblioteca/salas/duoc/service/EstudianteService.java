package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepo;

    public EstudianteService(EstudianteRepository estudianteRepo) {
        this.estudianteRepo = estudianteRepo;
    }

    /** Devuelve todos los estudiantes */
    public List<Estudiante> findAll() {
        return estudianteRepo.findAll();
    }

    /** Busca un estudiante por ID */
    public Optional<Estudiante> findById(Integer id) {
        return estudianteRepo.findById(id);
    }

    /** Inserta o actualiza un estudiante */
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepo.save(estudiante);
    }

    /** Elimina un estudiante por ID */
    public void deleteById(Integer id) {
        estudianteRepo.deleteById(id);
    }
}