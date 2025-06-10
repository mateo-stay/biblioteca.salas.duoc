package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.assembler.ReservaModelAssembler;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.ReservaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/reservas")
public class ReservaControllerV2 {

    private final ReservaService service;
    private final ReservaModelAssembler assembler;

    public ReservaControllerV2(ReservaService service, ReservaModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Reserva>> findAll() {
        List<EntityModel<Reserva>> list = service.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(list,
            linkTo(methodOn(ReservaControllerV2.class).findAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Reserva> findById(@PathVariable Integer id) {
        Reserva r = service.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return assembler.toModel(r);
    }

    @GetMapping("/sala/{salaId}")
    public CollectionModel<EntityModel<Reserva>> findBySala(
        @PathVariable Integer salaId) {
        List<EntityModel<Reserva>> coll = service.findBySalaId(salaId).stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(coll,
            linkTo(methodOn(ReservaControllerV2.class).findBySala(salaId)).withSelfRel());
    }

    @GetMapping("/fecha/{fecha}")
    public CollectionModel<EntityModel<Reserva>> findByFecha(
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        Date d = Date.valueOf(fecha);
        List<EntityModel<Reserva>> coll = service.findByFechaSolicitada(d).stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(coll,
            linkTo(methodOn(ReservaControllerV2.class).findByFecha(fecha)).withSelfRel());
    }

    @GetMapping("/estado/{estado}")
    public CollectionModel<EntityModel<Reserva>> findByEstado(
        @PathVariable Integer estado) {
        List<EntityModel<Reserva>> coll = service.findByEstado(estado).stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(coll,
            linkTo(methodOn(ReservaControllerV2.class).findByEstado(estado)).withSelfRel());
    }

    @GetMapping("/rango")
    public CollectionModel<EntityModel<Reserva>> findBetween(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        Date d1 = Date.valueOf(desde);
        Date d2 = Date.valueOf(hasta);
        List<EntityModel<Reserva>> coll = service.findByFechaSolicitadaBetween(d1, d2).stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(coll,
            linkTo(methodOn(ReservaControllerV2.class).findBetween(desde, hasta)).withSelfRel());
    }

    @GetMapping("/total/student/{stuId}")
    public EntityModel<Map<String, Object>> totalByStudent(
        @PathVariable Integer stuId) {
        long total = service.countByEstudianteId(stuId);
        Map<String, Object> body = Map.of(
            "studentId", stuId,
            "totalReservations", total
        );
        return EntityModel.of(body,
            linkTo(methodOn(ReservaControllerV2.class).totalByStudent(stuId)).withSelfRel(),
            linkTo(methodOn(ReservaControllerV2.class).findAll()).withRel("reservas")
        );
    }
}
