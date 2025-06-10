package biblioteca.salas.douc.biblioteca.salas.duoc.assembler;

import biblioteca.salas.douc.biblioteca.salas.duoc.controller.SalaControllerV2;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Sala;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class SalaModelAssembler
    implements RepresentationModelAssembler<Sala, EntityModel<Sala>> {

    @Override
    @NonNull
    public EntityModel<Sala> toModel(@NonNull Sala s) {
        return EntityModel.of(s,
            linkTo(methodOn(SalaControllerV2.class)
                .findById(s.getId())).withSelfRel(),
            linkTo(methodOn(SalaControllerV2.class)
                .findAll()).withRel("salas")
        );
    }
}