package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepo;

    public CarreraService(CarreraRepository carreraRepo) {
        this.carreraRepo = carreraRepo;
    }

    public List<Carrera> findAll() {
        return carreraRepo.findAll();
    }

    public Optional<Carrera> findById(String codigo) {
        return carreraRepo.findById(codigo);
    }

    public Carrera save(Carrera carrera) {
        return carreraRepo.save(carrera);
    }

    public void deleteById(String codigo) {
        carreraRepo.deleteById(codigo);
    }
}
