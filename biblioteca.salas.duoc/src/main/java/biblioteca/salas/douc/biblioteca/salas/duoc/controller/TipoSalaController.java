package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.TipoSalaService;
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

@Tag(name = "TipoSalas", description = "Operaciones sobre los tipos de sala")
@RestController
@RequestMapping("/api/tiposala")
public class TipoSalaController {

    private final TipoSalaService tipoSalaService;

    public TipoSalaController(TipoSalaService tipoSalaService) {
        this.tipoSalaService = tipoSalaService;
    }

    @Operation(
        summary = "Listar todos los tipos de sala",
        description = "Devuelve una lista con todos los tipos de sala disponibles"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de tipos de sala obtenida",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class)
            )
        )
    })
    @GetMapping
    public List<TipoSala> findAll() {
        return tipoSalaService.findAll();
    }

    @Operation(
        summary = "Crear un nuevo tipo de sala",
        description = "Recibe un JSON con los datos del tipo de sala a crear"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Tipo de sala creado correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class)
            )
        ),
        @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<TipoSala> save(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Objeto TipoSala en formato JSON",
            required = true,
            content = @Content(schema = @Schema(implementation = TipoSala.class))
        )
        @org.springframework.web.bind.annotation.RequestBody TipoSala tipoSala
    ) {
        TipoSala saved = tipoSalaService.save(tipoSala);
        return ResponseEntity.ok(saved);
    }

    @Operation(
        summary = "Obtener tipo de sala por ID",
        description = "Retorna el tipo de sala que coincide con el ID proporcionado"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Tipo de sala encontrado",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class)
            )
        ),
        @ApiResponse(responseCode = "404", description = "No existe tipo de sala con ese ID", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<TipoSala> findById(
        @Parameter(description = "ID del tipo de sala a buscar", example = "1", required = true)
        @PathVariable Integer id
    ) {
        return tipoSalaService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Eliminar tipo de sala por ID",
        description = "Borra el tipo de sala que coincide con el ID en la ruta"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Tipo de sala eliminado", content = @Content),
        @ApiResponse(responseCode = "404", description = "No existe tipo de sala con ese ID", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
        @Parameter(description = "ID del tipo de sala a eliminar", example = "1", required = true)
        @PathVariable Integer id
    ) {
        if (tipoSalaService.findById(id).isPresent()) {
            tipoSalaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}