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

    /** Devuelve todos los tipos de sala */
    public List<TipoSala> findAll() {
        return tipoSalaRepo.findAll();
    }

    /** Busca un tipo de sala por ID */
    public Optional<TipoSala> findById(Integer id) {
        return tipoSalaRepo.findById(id);
    }

    /** Inserta o actualiza un tipo de sala */
    public TipoSala save(TipoSala tipoSala) {
        return tipoSalaRepo.save(tipoSala);
    }

    /** Elimina un tipo de sala por ID */
    public void deleteById(Integer id) {
        tipoSalaRepo.deleteById(id);
    }
}