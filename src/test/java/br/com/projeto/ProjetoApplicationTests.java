package br.com.projeto;
// Define o pacote da classe. Isso organiza o código e ajuda a identificar a localização da classe dentro do projeto.

import org.junit.jupiter.api.Test;
// Importa a anotação @Test, que é usada para marcar métodos que são executados como testes.

import org.springframework.boot.test.context.SpringBootTest;
// Importa a anotação @SpringBootTest, que indica que este é um teste de integração do Spring Boot. 
// Ele carrega o contexto completo da aplicação, permitindo testar a interação entre componentes.

@SpringBootTest
// Indica que esta classe de teste é um teste de integração. O Spring Boot inicializa o contexto da aplicação 
// para verificar se tudo é carregado corretamente.

class ProjetoApplicationTests {
    // Define a classe de teste. Por convenção, o nome da classe é o mesmo do aplicativo seguido de "Tests".

    @Test
    // Marca o método como um caso de teste que será executado pelo JUnit.

    void contextLoads() {
        // Método de teste vazio que verifica se o contexto do Spring Boot é carregado corretamente.
        // Se o contexto não carregar, o teste falhará.
    }
}
