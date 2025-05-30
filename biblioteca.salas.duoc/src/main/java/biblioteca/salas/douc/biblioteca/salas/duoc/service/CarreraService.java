package biblioteca.salas.douc.biblioteca.salas.duoc.service;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }
}
