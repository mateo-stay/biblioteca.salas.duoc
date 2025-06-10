package biblioteca.salas.douc.biblioteca.salas.duoc.assembler;

import biblioteca.salas.douc.biblioteca.salas.duoc.controller.CarreraControllerV2;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CarreraModelAssembler
    implements RepresentationModelAssembler<Carrera, EntityModel<Carrera>> {

    @Override
    @NonNull
    public EntityModel<Carrera> toModel(@NonNull Carrera carrera) {
        return EntityModel.of(carrera,
            linkTo(methodOn(CarreraControllerV2.class).findByCodigo(carrera.getCodigo())).withSelfRel(),
            linkTo(methodOn(CarreraControllerV2.class).findAll()).withRel("carreras")
        );
    }
}