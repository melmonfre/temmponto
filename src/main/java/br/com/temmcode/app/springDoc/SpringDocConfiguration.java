package br.com.temmcode.app.springDoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("API de Registro de Horas - TEMM")
                        .version("1.0")
                        .description("Aplicativo interno com o objetivo de registrar as horas gastas em cada um dos clientes e projetos da TEMM.\n\n"
                                + "O aplicativo terá as funcionalidades:\n\n"
                                + "1. **Login**\n"
                                + "2. **Registrar horas de um produto/cliente**, informando:\n"
                                + "   - Horário de entrada\n"
                                + "   - Horário de saída\n"
                                + "   - Empresa\n"
                                + "   - Funcionário (informado automaticamente via autenticação)\n"
                                + "3. **Exportar planilha de horas**, informado:\n"
                                + "   - Horário de entrada\n"
                                + "   - Horário de saída\n"
                                + "   - Empresa\n"
                                + "   - Funcionário\n\n"
                                + "Os produtos e clientes podem estar definidos hardcoded;\n"
                                + "A criação de usuário pode ser feita via API;")
                        .contact(new Contact()
                                .name("Equipe TEMM")
                                .url("https://www.temmcode.com")));
    }
}
