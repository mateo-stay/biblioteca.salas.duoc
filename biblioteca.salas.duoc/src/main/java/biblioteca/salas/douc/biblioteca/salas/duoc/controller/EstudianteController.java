package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> findById(@PathVariable Integer id) {
        return estudianteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante) {
        Estudiante saved = estudianteService.save(estudiante);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (estudianteService.findById(id).isPresent()) {
            estudianteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}