package biblioteca.salas.douc.biblioteca.salas.duoc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bibliotecaOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("📚 API Biblioteca Salas Duoc")
                .version("v1.0.0")
                .description("API REST para gestión de reservas, estudiantes, salas y carreras en Biblioteca Duoc"));
    }

    @Bean
    public GlobalOpenApiCustomizer agregarHeaderPorDefecto() {
        return openApi -> {
            openApi.getPaths()
                .values()
                .forEach(pathItem -> pathItem.readOperations()
                    .forEach(op -> op.addParametersItem(new io.swagger.v3.oas.models.parameters.Parameter()
                        .name("X-Cliente-Id")
                        .description("Identificador único de la entidad cliente")
                        .required(false)
                        .schema(new io.swagger.v3.oas.models.media.StringSchema()))));
        };
    }
}
