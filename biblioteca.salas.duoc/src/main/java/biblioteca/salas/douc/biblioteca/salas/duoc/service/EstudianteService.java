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

    public List<Estudiante> findAll() {
        return estudianteRepo.findAll();
    }

    public Optional<Estudiante> findById(Integer id) {
        return estudianteRepo.findById(id);
    }

    public Estudiante save(Estudiante estudiante) {
        return estudianteRepo.save(estudiante);
    }

    public void deleteById(Integer id) {
        estudianteRepo.deleteById(id);
    }
}