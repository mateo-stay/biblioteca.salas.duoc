package biblioteca.salas.douc.biblioteca.salas.duoc.controller;
import biblioteca.salas.douc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.EstudianteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EstudianteController.class)
@ActiveProfiles("test")
public class EstudianteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstudianteService estudianteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateEstudiante() throws Exception {
        Estudiante input = new Estudiante();
        input.setId(1);
        input.setRun("12345678-9");
        input.setNombres("Juan Pérez");
        input.setCorreo("juan@duoc.cl");
        input.setJornada('D');
        input.setTelefono(912345678);

        when(estudianteService.save(Mockito.any(Estudiante.class))).thenReturn(input);

        mockMvc.perform(post("/api/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombres").value("Juan Pérez"))
                .andExpect(jsonPath("$.correo").value("juan@duoc.cl"));
    }

    @Test
    void testFindAllEstudiantes() throws Exception {
        Estudiante e = new Estudiante();
        e.setId(1);
        e.setRun("12345678-9");
        e.setNombres("María López");
        e.setCorreo("maria@duoc.cl");
        e.setJornada('N');
        e.setTelefono(987654321);
        List<Estudiante> lista = List.of(e);

        when(estudianteService.findAll()).thenReturn(lista);

        mockMvc.perform(get("/api/estudiantes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombres").value("María López"));
    }
}
