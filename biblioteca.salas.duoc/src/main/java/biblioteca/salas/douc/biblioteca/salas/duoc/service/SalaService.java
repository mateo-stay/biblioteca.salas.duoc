package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository salaRepo;

    public SalaService(SalaRepository salaRepo) {
        this.salaRepo = salaRepo;
    }

    /** Devuelve todas las salas */
    public List<Sala> findAll() {
        return salaRepo.findAll();
    }

    /** Busca una sala por ID */
    public Optional<Sala> findById(Integer id) {
        return salaRepo.findById(id);
    }

    /** Inserta o actualiza una sala */
    public Sala save(Sala sala) {
        return salaRepo.save(sala);
    }

    /** Elimina una sala por ID */
    public void deleteById(Integer id) {
        salaRepo.deleteById(id);
    }
}