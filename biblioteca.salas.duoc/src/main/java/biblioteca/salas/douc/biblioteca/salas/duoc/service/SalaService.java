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

    public List<Sala> findAll() {
        return salaRepo.findAll();
    }

    public Optional<Sala> findById(Integer id) {
        return salaRepo.findById(id);
    }

    public Sala save(Sala sala) {
        return salaRepo.save(sala);
    }

    public void deleteById(Integer id) {
        salaRepo.deleteById(id);
    }
}