package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.CarreraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Carreras", description = "Operaciones relacionadas con las carreras")
@RestController
@RequestMapping("/api/carreras")
public class CarreraController {
    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @Operation(summary = "Obtener todas las carreras", description = "Retorna una lista con todas las carreras disponibles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa")
    })
    @GetMapping
    public List<Carrera> findAll() {
        return carreraService.findAll();
    }

    @Operation(summary = "Crear una nueva carrera", description = "Recibe un objeto Carrera y lo guarda en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Carrera creada correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Carrera save(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }
}

