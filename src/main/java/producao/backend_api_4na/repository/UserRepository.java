package producao.backend_api_4na.repository;

import producao.backend_api_4na.entity.User; 
// Importa a classe User, que representa a entidade de usuário no sistema.

import org.springframework.data.jpa.repository.JpaRepository; 
// Importa a interface JpaRepository, que fornece métodos prontos para interação com o banco de dados.

import java.util.Optional; 
// Importa a classe Optional para manipulação de valores que podem ser nulos de maneira segura.

public interface UserRepository extends JpaRepository<User, Long> {
    // Extende a interface JpaRepository, onde o primeiro parâmetro é a entidade (User) e o segundo é o tipo do ID (Long).

    Optional<User> findByUsername(String username); 
    // Declara um método para encontrar um usuário pelo seu nome de usuário, retornando um Optional.

    Optional<User> findByEmail(String email); 
    // Declara um método para encontrar um usuário pelo seu email, retornando um Optional.

    Optional<User> findByCpf(String cpf); 
    // Declara um método para encontrar um usuário pelo seu CPF, retornando um Optional.
}
