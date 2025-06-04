package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepo;

    public ReservaService(ReservaRepository reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    /** Devuelve todas las reservas */
    public List<Reserva> findAll() {
        return reservaRepo.findAll();
    }

    /** Busca una reserva por ID */
    public Optional<Reserva> findById(Integer id) {
        return reservaRepo.findById(id);
    }

    /** Inserta o actualiza una reserva */
    public Reserva save(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    /** Elimina una reserva por ID */
    public void deleteById(Integer id) {
        reservaRepo.deleteById(id);
    }
}