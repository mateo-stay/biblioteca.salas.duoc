package biblioteca.salas.douc.biblioteca.salas.duoc.assembler;

import biblioteca.salas.douc.biblioteca.salas.duoc.controller.ReservaControllerV2;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Reserva;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReservaModelAssembler
    implements RepresentationModelAssembler<Reserva, EntityModel<Reserva>> {

    @Override
    @NonNull
    public EntityModel<Reserva> toModel(@NonNull Reserva r) {
        return EntityModel.of(r,
            linkTo(methodOn(ReservaControllerV2.class)
                .findById(r.getId())).withSelfRel(),
            linkTo(methodOn(ReservaControllerV2.class)
                .findAll()).withRel("reservas")
        );
    }
}