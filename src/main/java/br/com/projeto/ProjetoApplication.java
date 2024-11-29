package br.com.projeto;
// Define o pacote da classe. É uma convenção do Java para organizar e agrupar classes relacionadas.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa a anotação `@SpringBootApplication`, que marca a classe principal de uma aplicação Spring Boot.

@SpringBootApplication
// Anotação que combina três funcionalidades principais:
// 1. @Configuration - Indica que a classe contém configurações da aplicação.
// 2. @EnableAutoConfiguration - Habilita a configuração automática baseada nas dependências presentes no classpath.
// 3. @ComponentScan - Permite a varredura de componentes (como @Service, @Controller, etc.) dentro do pacote e subpacotes.

public class ProjetoApplication {
    // Define a classe principal da aplicação, que será executada para iniciar o projeto.

    public static void main(String[] args) {
        // O método `main` é o ponto de entrada de uma aplicação Java.

        SpringApplication.run(ProjetoApplication.class, args);
        // Inicia a aplicação Spring Boot. 
        // O método `run` configura o contexto da aplicação, inicializa o servidor embutido (como Tomcat) 
        // e prepara os componentes para serem utilizados.
    }

}
