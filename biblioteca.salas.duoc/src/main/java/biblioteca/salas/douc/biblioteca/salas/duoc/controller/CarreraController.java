package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.CarreraService;
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

@Tag(name = "Carreras", description = "Operaciones relacionadas con las carreras")
@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @Operation(
        summary = "Obtener todas las carreras",
        description = "Retorna una lista con todas las carreras disponibles en el sistema"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de carreras retornada correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class)
            )
        )
    })
    @GetMapping
    public List<Carrera> findAll() {
        return carreraService.findAll();
    }

    @Operation(
        summary = "Crear una nueva carrera",
        description = "Recibe un objeto Carrera en el cuerpo de la petición y lo guarda en la base de datos"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Carrera creada correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos inválidos en la petición",
            content = @Content
        )
    })
    @PostMapping
    public ResponseEntity<Carrera> save(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "JSON con los datos de la carrera a crear",
            required = true,
            content = @Content(schema = @Schema(implementation = Carrera.class))
        )
        @org.springframework.web.bind.annotation.RequestBody Carrera carrera
    ) {
        Carrera saved = carreraService.save(carrera);
        return ResponseEntity.ok(saved);
    }

    @Operation(
        summary = "Obtener una carrera por código",
        description = "Devuelve la carrera cuyo código coincide con el parámetro de la ruta"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Carrera encontrada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "No se encontró ninguna carrera con el código especificado",
            content = @Content
        )
    })
    @GetMapping("/{codigo}")
    public ResponseEntity<Carrera> findByCodigo(
        @Parameter(
            description = "Código de la carrera a buscar",
            example = "ING",
            required = true
        )
        @PathVariable String codigo
    ) {
        return carreraService.findById(codigo)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Eliminar una carrera por código",
        description = "Borra la carrera que coincida con el código recibido como parámetro"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Carrera eliminada exitosamente", content = @Content),
        @ApiResponse(responseCode = "404", description = "No existe carrera con el código especificado", content = @Content)
    })
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteByCodigo(
        @Parameter(
            description = "Código de la carrera a eliminar",
            example = "ING",
            required = true
        )
        @PathVariable String codigo
    ) {
        if (carreraService.findById(codigo).isPresent()) {
            carreraService.deleteById(codigo);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}