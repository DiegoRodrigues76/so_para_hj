package producao.backend_api_4na.service;

import producao.backend_api_4na.dto.UserDTO; // Importa o DTO (Data Transfer Object) para representar os dados de um usuário.
import producao.backend_api_4na.entity.User; // Importa a entidade User, representando o modelo do banco de dados.
import producao.backend_api_4na.repository.UserRepository; // Importa o repositório para acesso ao banco de dados.
import org.junit.jupiter.api.Test; // Importa o framework de testes JUnit.
import org.mockito.InjectMocks; // Anotação do Mockito para injeção de dependência.
import org.mockito.Mock; // Anotação do Mockito para mockar dependências.
import org.mockito.Mockito; // Ferramentas do Mockito para criação de mocks e comportamento simulado.
import org.springframework.boot.test.context.SpringBootTest; // Indica que é um teste de contexto Spring Boot.

import static org.junit.jupiter.api.Assertions.assertNotNull; // Importa método de asserção para validação de testes.
import static org.mockito.Mockito.when; // Importa método para definir comportamento simulado de mocks.

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository; 
    // Mocka a dependência UserRepository, permitindo simular interações com o banco de dados.

    @InjectMocks
    private UserServiceImpl userService; 
    // Injeta o mock userRepository na implementação do serviço UserServiceImpl.

    @Test
    public void testCreateUser() {
        // Arrange - Configuração do cenário de teste.
        UserDTO userDTO = new UserDTO(); 
        // Cria um DTO e popula com dados de exemplo.
        userDTO.setUsername("Pedro Leal");
        userDTO.setEmail("teste@email.com");
        userDTO.setCpf("12345678901");
        userDTO.setPassword("123456");

        User user = new User();
        // Cria uma entidade User a partir do DTO.
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setCpf(userDTO.getCpf());
        user.setPassword(userDTO.getPassword());

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user); 
        // Define comportamento simulado: ao salvar qualquer instância de User, o mock retorna o objeto "user".

        // Act - Executa o método a ser testado.
        User createdUser = userService.createUser(userDTO); 
        // Chama o método do serviço para criar um usuário.

        // Assert - Verifica se o resultado está conforme o esperado.
        assertNotNull(createdUser); 
        // Assegura que o objeto retornado não seja nulo.
        assertNotNull(createdUser.getUsername()); 
        // Assegura que o username do objeto criado não seja nulo.
        assertNotNull(createdUser.getEmail()); 
        // Assegura que o email do objeto criado não seja nulo.
    }
}
