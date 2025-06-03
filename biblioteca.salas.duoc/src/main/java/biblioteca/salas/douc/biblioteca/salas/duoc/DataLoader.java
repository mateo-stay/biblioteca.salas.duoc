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

        // 1. Tipos de sala (solo si no existen)
        if (tipoSalaRepo.count() == 0) {
            for (int i = 1; i <= 3; i++) {
                TipoSala t = new TipoSala();
                t.setIdTipo(i);
                t.setNombre(faker.book().genre());
                tipoSalaRepo.save(t);
            }
        }

        // 2. Carreras (solo si no existen)
        if (carreraRepo.count() == 0) {
            for (int i = 1; i <= 5; i++) {
                Carrera c = new Carrera();
                c.setCodigo(faker.code().asin());
                c.setNombre(faker.educator().course());
                carreraRepo.save(c);
            }
        }

        List<Carrera> carreras = carreraRepo.findAll();

        // 3. Estudiantes (solo si no existen)
        if (estudianteRepo.count() == 0) {
            for (int i = 1; i <= 50; i++) {
                Estudiante e = new Estudiante();
                e.setId(i);
                e.setRun(faker.idNumber().valid());
                e.setNombres(faker.name().fullName());
                e.setCorreo(faker.internet().emailAddress());
                e.setJornada(faker.options().option("D", "N").charAt(0));
                e.setTelefono(faker.number().numberBetween(100_000_000, 999_999_999));
                // asume que carreras.size() > 0
                e.setCarrera(carreras.get(rnd.nextInt(carreras.size())));
                estudianteRepo.save(e);
            }
        }

        // 4. Salas (solo si no existen)
        if (salaRepo.count() == 0) {
            List<TipoSala> tipos = tipoSalaRepo.findAll();
            for (int i = 1; i <= 10; i++) {
                Sala s = new Sala();
                s.setNombre("Sala " + i);
                // Usar el setter correcto:
                s.setTipoSala(tipos.get(rnd.nextInt(tipos.size())));
                salaRepo.save(s);
            }
        }        

        // 5. Listas reales para crear Reservas
        List<Estudiante> estudiantes = estudianteRepo.findAll();
        List<Sala> salas = salaRepo.findAll();

        // Si faltara alguna lista vacía, detenemos aquí
        if (estudiantes.isEmpty() || salas.isEmpty()) {
            System.out.println("No hay estudiantes o salas suficientes para poblar reservas. Omiso esta parte.");
            return;
        }

        // 6. Reservas (20 registros faker)
        for (int i = 1; i <= 20; i++) {
            Reserva r = new Reserva();
            r.setId(i);
            // nextInt(estudiantes.size()) y nextInt(salas.size()) son válidos (> 0)
            r.setEstudiante(estudiantes.get(rnd.nextInt(estudiantes.size())));
            r.setSala(salas.get(rnd.nextInt(salas.size())));
            r.setFechaSolicitada(new Date());
            r.setHoraSolicitada(new Date());
            r.setHoraCierre(new Date(System.currentTimeMillis() +
                    faker.number().numberBetween(3_600_000, 7_200_000)));
            r.setEstado(faker.number().numberBetween(0, 2));
            reservaRepo.save(r);
        }

        System.out.println("DataLoader completado: tipos, carreras, estudiantes, salas y reservas creadas.");
    }
}
