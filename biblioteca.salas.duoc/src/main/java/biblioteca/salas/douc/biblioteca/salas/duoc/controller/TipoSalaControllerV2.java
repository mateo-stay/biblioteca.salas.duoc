package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.assembler.TipoSalaModelAssembler;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.TipoSalaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/tiposala")
public class TipoSalaControllerV2 {

    private final TipoSalaService service;
    private final TipoSalaModelAssembler assembler;

    public TipoSalaControllerV2(TipoSalaService service, TipoSalaModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<TipoSala>> findAll() {
        List<EntityModel<TipoSala>> list = service.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(list,
            linkTo(methodOn(TipoSalaControllerV2.class).findAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<TipoSala> findById(@PathVariable Integer id) {
        TipoSala ts = service.findById(id)
            .orElseThrow(() -> new RuntimeException("TipoSala no encontrado"));
        return assembler.toModel(ts);
    }
}
