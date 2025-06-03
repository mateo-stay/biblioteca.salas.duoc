package biblioteca.salas.douc.biblioteca.salas.duoc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Proyecto Biblioteca Salas Duoc API")
                .version("1.0.0")
                .description("Documentación de la API para reservas de salas"));
    }
}
