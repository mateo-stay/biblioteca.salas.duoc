package biblioteca.salas.douc.biblioteca.salas.duoc;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.*;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.*;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    private final CarreraRepository carreraRepo;
    private final EstudianteRepository estudianteRepo;
    private final ReservaRepository reservaRepo;
    private final SalaRepository salaRepo;
    private final TipoSalaRepository tipoSalaRepo;

    public DataLoader(CarreraRepository carreraRepo,
                      EstudianteRepository estudianteRepo,
                      ReservaRepository reservaRepo,
                      SalaRepository salaRepo,
                      TipoSalaRepository tipoSalaRepo) {
        this.carreraRepo = carreraRepo;
        this.estudianteRepo = estudianteRepo;
        this.reservaRepo = reservaRepo;
        this.salaRepo = salaRepo;
        this.tipoSalaRepo = tipoSalaRepo;
    }

    @Override
    public void run(String... args) {
        Faker faker = new Faker();
        Random rnd = new Random();

        // 1. Tipos de sala
        for (int i = 1; i <= 3; i++) {
            TipoSala t = new TipoSala();
            t.setIdTipo(i);
            t.setNombre(faker.book().genre());
            tipoSalaRepo.save(t);
        }

        // 2. Carreras
        for (int i = 1; i <= 5; i++) {
            Carrera c = new Carrera();
            c.setCodigo(faker.code().asin());
            c.setNombre(faker.educator().course());
            carreraRepo.save(c);
        }

        List<Carrera> carreras = carreraRepo.findAll();

        // 3. Estudiantes
        for (int i = 1; i <= 50; i++) {
            Estudiante e = new Estudiante();
            e.setId(i);
            e.setRun(faker.idNumber().valid());
            e.setNombres(faker.name().fullName());
            e.setCorreo(faker.internet().emailAddress());
            e.setJornada(faker.options().option("D", "N").charAt(0));
            e.setTelefono(faker.number().numberBetween(100_000_000, 999_999_999));
            e.setCarrera(carreras.get(rnd.nextInt(carreras.size())));
            estudianteRepo.save(e);
        }

        List<Sala> salas = salaRepo.findAll();

        // 4. Reservas
        for (int i = 1; i <= 20; i++) {
            Reserva r = new Reserva();
            r.setId(i);
            r.setEstudiante(estudianteRepo.findAll().get(rnd.nextInt(50)));
            r.setSala(salas.get(rnd.nextInt(salas.size())));
            r.setFechaSolicitada(new Date());
            r.setHoraSolicitada(new Date());
            r.setHoraCierre(new Date(System.currentTimeMillis() +
                faker.number().numberBetween(3_600_000, 7_200_000)));
            r.setEstado(faker.number().numberBetween(0, 2));
            reservaRepo.save(r);
        }
    }
}
