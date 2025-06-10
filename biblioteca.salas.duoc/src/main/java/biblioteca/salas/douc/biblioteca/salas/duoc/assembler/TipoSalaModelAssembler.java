package biblioteca.salas.douc.biblioteca.salas.duoc.assembler;

import biblioteca.salas.douc.biblioteca.salas.duoc.controller.TipoSalaControllerV2;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.TipoSala;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class TipoSalaModelAssembler
    implements RepresentationModelAssembler<TipoSala, EntityModel<TipoSala>> {

    @Override
    @NonNull
    public EntityModel<TipoSala> toModel(@NonNull TipoSala ts) {
        return EntityModel.of(ts,
            linkTo(methodOn(TipoSalaControllerV2.class)
                .findById(ts.getIdTipo())).withSelfRel(),
            linkTo(methodOn(TipoSalaControllerV2.class)
                .findAll()).withRel("tiposala")
        );
    }
}