package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.assembler.CarreraModelAssembler;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.CarreraService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/carreras")
public class CarreraControllerV2 {

    private final CarreraService service;
    private final CarreraModelAssembler assembler;

    public CarreraControllerV2(CarreraService service, CarreraModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Carrera>> findAll() {
        List<EntityModel<Carrera>> list = service.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(list,
            linkTo(methodOn(CarreraControllerV2.class).findAll()).withSelfRel());
    }

    @GetMapping("/{codigo}")
    public EntityModel<Carrera> findByCodigo(@PathVariable String codigo) {
        Carrera c = service.findById(codigo)
            .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        return assembler.toModel(c);
    }
}