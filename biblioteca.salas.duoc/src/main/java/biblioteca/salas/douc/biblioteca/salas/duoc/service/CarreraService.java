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

    /**
     * Devuelve todas las carreras en la base de datos.
     */
    public List<Carrera> findAll() {
        return carreraRepo.findAll();
    }

    /**
     * Busca una carrera por su código (ID) y la devuelve envuelta en Optional.
     */
    public Optional<Carrera> findById(String codigo) {
        return carreraRepo.findById(codigo);
    }

    /**
     * Crea o actualiza una Carrera en la base de datos.
     */
    public Carrera save(Carrera carrera) {
        return carreraRepo.save(carrera);
    }

    /**
     * Elimina una carrera por su código (ID). Si no existe, JpaRepository lanza excepcion o lo ignora según configuración.
     */
    public void deleteById(String codigo) {
        carreraRepo.deleteById(codigo);
    }
}
