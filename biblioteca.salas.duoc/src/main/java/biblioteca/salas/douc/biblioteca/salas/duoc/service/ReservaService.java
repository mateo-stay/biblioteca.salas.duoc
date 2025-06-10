package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository repo;

    public ReservaService(ReservaRepository repo) {
        this.repo = repo;
    }

    public List<Reserva> findAll() {
        return repo.findAll();
    }

    public Optional<Reserva> findById(Integer id) {
        return repo.findById(id);
    }

    public Reserva save(Reserva r) {
        return repo.save(r);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public List<Reserva> findBySalaId(Integer salaId) {
        return repo.findBySalaId(salaId);
    }

    public List<Reserva> findByFechaSolicitada(Date fecha) {
        return repo.findByFechaSolicitada(fecha);
    }

    public List<Reserva> findByEstado(Integer estado) {
        return repo.findByEstado(estado);
    }

    public List<Reserva> findByFechaSolicitadaBetween(Date inicio, Date fin) {
        return repo.findByFechaSolicitadaBetween(inicio, fin);
    }

    public long countByEstudianteId(Integer estudianteId) {
        return repo.countByEstudianteId(estudianteId);
    }
}
