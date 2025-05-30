package biblioteca.salas.douc.biblioteca.salas.duoc.controller;

import biblioteca.salas.douc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.douc.biblioteca.salas.duoc.repository.CarreraRepository;
import biblioteca.salas.douc.biblioteca.salas.duoc.service.CarreraService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarreraServiceTest {

    @Mock
    private CarreraRepository carreraRepository;

    @InjectMocks
    private CarreraService carreraService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Carrera c = new Carrera();
        c.setCodigo("1");
        c.setNombre("Ingeniería");
    
        when(carreraRepository.findAll())
            .thenReturn(List.of(c));
    
        List<Carrera> result = carreraService.findAll();
    
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Ingeniería", result.get(0).getNombre());
    
        verify(carreraRepository, times(1)).findAll();
    }
}