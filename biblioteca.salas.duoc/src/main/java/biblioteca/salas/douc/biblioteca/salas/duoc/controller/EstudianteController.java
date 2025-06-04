package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Estudiantes", description = "Operaciones sobre estudiantes")
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @Operation(
        summary = "Listar todos los estudiantes",
        description = "Retorna un arreglo con todos los estudiantes registrados"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de estudiantes obtenida",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class)
            )
        )
    })
    @GetMapping
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }

    @Operation(
        summary = "Crear un nuevo estudiante",
        description = "Recibe un JSON con los datos del estudiante y lo guarda en la base de datos"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Estudiante creado exitosamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class)
            )
        ),
        @ApiResponse(responseCode = "400", description = "Datos inválidos en la petición", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Estudiante> save(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Objeto Estudiante en formato JSON",
            required = true,
            content = @Content(schema = @Schema(implementation = Estudiante.class))
        )
        @org.springframework.web.bind.annotation.RequestBody Estudiante estudiante
    ) {
        Estudiante saved = estudianteService.save(estudiante);
        return ResponseEntity.ok(saved);
    }

    @Operation(
        summary = "Obtener estudiante por ID",
        description = "Devuelve el estudiante que coincide con el ID en la ruta"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Estudiante encontrado",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class)
            )
        ),
        @ApiResponse(responseCode = "404", description = "No se encontró el estudiante", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> findById(
        @Parameter(description = "ID del estudiante a buscar", example = "1", required = true)
        @PathVariable Integer id
    ) {
        return estudianteService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Eliminar estudiante por ID",
        description = "Borra el estudiante que concuerde con el ID"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Estudiante eliminado exitosamente", content = @Content),
        @ApiResponse(responseCode = "404", description = "No existe estudiante con ese ID", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
        @Parameter(description = "ID del estudiante a eliminar", example = "1", required = true)
        @PathVariable Integer id
    ) {
        if (estudianteService.findById(id).isPresent()) {
            estudianteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}