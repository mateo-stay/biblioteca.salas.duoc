package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.SalaService;
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

@Tag(name = "Salas", description = "Operaciones sobre salas disponibles")
@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @Operation(
        summary = "Listar todas las salas",
        description = "Devuelve todas las salas almacenadas en el sistema"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de salas obtenida",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class)
            )
        )
    })
    @GetMapping
    public List<Sala> findAll() {
        return salaService.findAll();
    }

    @Operation(
        summary = "Crear una nueva sala",
        description = "Recibe un JSON con los datos de la sala a crear"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Sala creada correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class)
            )
        ),
        @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Sala> save(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Objeto Sala en formato JSON",
            required = true,
            content = @Content(schema = @Schema(implementation = Sala.class))
        )
        @org.springframework.web.bind.annotation.RequestBody Sala sala
    ) {
        Sala saved = salaService.save(sala);
        return ResponseEntity.ok(saved);
    }

    @Operation(
        summary = "Obtener sala por ID",
        description = "Retorna la sala que coincide con el ID de la ruta"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Sala encontrada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class)
            )
        ),
        @ApiResponse(responseCode = "404", description = "No existe sala con ese ID", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Sala> findById(
        @Parameter(description = "ID de la sala a buscar", example = "10", required = true)
        @PathVariable Integer id
    ) {
        return salaService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Eliminar sala por ID",
        description = "Borra la sala cuya ID coincida con la ruta"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Sala eliminada exitosamente", content = @Content),
        @ApiResponse(responseCode = "404", description = "No existe sala con ese ID", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
        @Parameter(description = "ID de la sala a eliminar", example = "10", required = true)
        @PathVariable Integer id
    ) {
        if (salaService.findById(id).isPresent()) {
            salaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}