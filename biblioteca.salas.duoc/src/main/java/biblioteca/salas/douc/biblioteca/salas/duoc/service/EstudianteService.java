package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> findById(Integer id) {
        return estudianteRepository.findById(id);
    }

    public void deleteById(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
