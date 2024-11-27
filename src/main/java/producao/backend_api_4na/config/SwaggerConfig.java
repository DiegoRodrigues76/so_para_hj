package producao.backend_api_4na.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition; 
// Importa a anotação OpenAPIDefinition do Swagger, usada para definir as informações da API.

import io.swagger.v3.oas.annotations.info.Info; 
// Importa a anotação Info do Swagger, que permite definir as informações detalhadas da API, como título, versão, descrição, etc.

import org.springframework.context.annotation.Configuration; 
// Importa a anotação Configuration do Spring, que indica que esta classe configura componentes do contexto da aplicação.

@Configuration 
// Define esta classe como uma classe de configuração para o Spring. Ela será usada para configurar aspectos da aplicação, como o Swagger.

@OpenAPIDefinition(
    info = @Info(
        title = "API de Cadastro de Usuários", 
        // Define o título da documentação da API.

        version = "1.0", 
        // Define a versão da API.

        description = "Documentação da API de cadastro de usuários" 
        // Define a descrição da API.
    )
)
public class SwaggerConfig {
    // Classe de configuração do Swagger que fornece informações sobre a API para a geração automática da documentação.
}
