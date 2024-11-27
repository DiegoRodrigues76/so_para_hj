package producao.backend_api_4na;

import org.springframework.boot.SpringApplication; 
// Importa a classe responsável por iniciar a aplicação Spring Boot.

import org.springframework.boot.autoconfigure.SpringBootApplication; 
// Importa a anotação que marca esta classe como principal para configuração do Spring Boot.
// Combina as anotações @Configuration, @EnableAutoConfiguration e @ComponentScan.

@SpringBootApplication
// Indica que esta é a classe principal da aplicação Spring Boot, 
// e ativa a configuração automática e a varredura de componentes.

public class MainApplication {
    public static void main(String[] args) {
        // Método principal que inicia a aplicação Spring Boot.
        SpringApplication.run(MainApplication.class, args);
        // Configura o contexto do Spring e inicializa o servidor.
    }
}
