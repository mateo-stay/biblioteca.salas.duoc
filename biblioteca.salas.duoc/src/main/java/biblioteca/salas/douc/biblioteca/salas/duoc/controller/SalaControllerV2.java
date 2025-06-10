package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.assembler.SalaModelAssembler;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.SalaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/salas")
public class SalaControllerV2 {

    private final SalaService service;
    private final SalaModelAssembler assembler;

    public SalaControllerV2(SalaService service, SalaModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Sala>> findAll() {
        List<EntityModel<Sala>> list = service.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(list,
            linkTo(methodOn(SalaControllerV2.class).findAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Sala> findById(@PathVariable Integer id) {
        Sala s = service.findById(id)
            .orElseThrow(() -> new RuntimeException("Sala no encontrada"));
        return assembler.toModel(s);
    }
}
