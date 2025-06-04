package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoSalaService {

    private final TipoSalaRepository tipoSalaRepo;

    public TipoSalaService(TipoSalaRepository tipoSalaRepo) {
        this.tipoSalaRepo = tipoSalaRepo;
    }

    public List<TipoSala> findAll() {
        return tipoSalaRepo.findAll();
    }

    public Optional<TipoSala> findById(Integer id) {
        return tipoSalaRepo.findById(id);
    }

    public TipoSala save(TipoSala tipoSala) {
        return tipoSalaRepo.save(tipoSala);
    }

    public void deleteById(Integer id) {
        tipoSalaRepo.deleteById(id);
    }
}