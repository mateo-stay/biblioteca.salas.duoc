package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Reservas", description = "Operaciones sobre reservas de sala")
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Operation(
        summary = "Listar todas las reservas",
        description = "Retorna todas las reservas creadas en el sistema",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de reservas obtenida correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class)
            )
        ),
        @ApiResponse(responseCode = "401", description = "No autorizado", content = @Content)
    })
    @GetMapping
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @Operation(
        summary = "Crear una nueva reserva",
        description = "Recibe un JSON con los datos de la reserva y la persiste",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Reserva creada correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class)
            )
        ),
        @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content),
        @ApiResponse(responseCode = "401", description = "No autorizado", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Reserva> save(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Objeto Reserva en formato JSON",
            required = true,
            content = @Content(schema = @Schema(implementation = Reserva.class))
        )
        @org.springframework.web.bind.annotation.RequestBody Reserva reserva
    ) {
        Reserva saved = reservaService.save(reserva);
        return ResponseEntity.ok(saved);
    }

    @Operation(
        summary = "Obtener reserva por ID",
        description = "Retorna la reserva que coincide con el ID de la ruta",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Reserva encontrada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class)
            )
        ),
        @ApiResponse(responseCode = "404", description = "No existe reserva con ese ID", content = @Content),
        @ApiResponse(responseCode = "401", description = "No autorizado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(
        @Parameter(description = "ID de la reserva a buscar", example = "100", required = true)
        @PathVariable Integer id
    ) {
        return reservaService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Eliminar reserva por ID",
        description = "Borra la reserva que coincida con el ID de la ruta",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Reserva eliminada exitosamente", content = @Content),
        @ApiResponse(responseCode = "404", description = "No existe reserva con ese ID", content = @Content),
        @ApiResponse(responseCode = "401", description = "No autorizado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
        @Parameter(description = "ID de la reserva a eliminar", example = "100", required = true)
        @PathVariable Integer id
    ) {
        if (reservaService.findById(id).isPresent()) {
            reservaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}