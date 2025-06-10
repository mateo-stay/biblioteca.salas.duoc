package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.assembler.EstudianteModelAssembler;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.EstudianteService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/estudiantes")
public class EstudianteControllerV2 {

    private final EstudianteService service;
    private final EstudianteModelAssembler assembler;

    public EstudianteControllerV2(EstudianteService service, EstudianteModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Estudiante>> findAll() {
        List<EntityModel<Estudiante>> list = service.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(list,
            linkTo(methodOn(EstudianteControllerV2.class).findAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Estudiante> findById(@PathVariable Integer id) {
        Estudiante e = service.findById(id)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return assembler.toModel(e);
    }
}
