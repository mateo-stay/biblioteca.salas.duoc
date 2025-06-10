package biblioteca.salas.douc.biblioteca.salas.duoc.assembler;

import biblioteca.salas.douc.biblioteca.salas.duoc.controller.EstudianteControllerV2;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EstudianteModelAssembler
    implements RepresentationModelAssembler<Estudiante, EntityModel<Estudiante>> {

    @Override
    @NonNull
    public EntityModel<Estudiante> toModel(@NonNull Estudiante e) {
        return EntityModel.of(e,
            linkTo(methodOn(EstudianteControllerV2.class)
                .findById(e.getId())).withSelfRel(),
            linkTo(methodOn(EstudianteControllerV2.class)
                .findAll()).withRel("estudiantes")
        );
    }
}
