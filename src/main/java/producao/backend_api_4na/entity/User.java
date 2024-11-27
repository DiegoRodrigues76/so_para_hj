package producao.backend_api_4na.entity;

import jakarta.persistence.Entity; 
// Importa a anotação Entity do Jakarta Persistence API (JPA), que marca esta classe como uma entidade persistente no banco de dados.

import jakarta.persistence.Id; 
// Importa a anotação Id do Jakarta Persistence, que marca o campo id como a chave primária da entidade.

@Entity 
// Indica que a classe User é uma entidade JPA, ou seja, ela corresponde a uma tabela no banco de dados.
public class User {

    @Id 
    // A anotação @Id define que o campo id é a chave primária da entidade.
    private Long id; 
    // Define o campo id como um Long, que será a chave primária no banco de dados.

    private String username; 
    // Define o campo username para armazenar o nome de usuário.

    private String email; 
    // Define o campo email para armazenar o endereço de email do usuário.

    private String cpf; 
    // Define o campo cpf para armazenar o CPF do usuário.

    private String password; 
    // Define o campo password para armazenar a senha do usuário.

    private String name; 
    // Define o campo name para armazenar o nome completo do usuário.

    // Getters e Setters
    public Long getId() {
        return id; 
    }
    // Retorna o ID do usuário.

    public void setId(Long id) {
        this.id = id; 
    }
    // Define o ID do usuário.

    public String getUsername() {
        return username; 
    }
    // Retorna o nome de usuário.

    public void setUsername(String username) {
        this.username = username; 
    }
    // Define o nome de usuário.

    public String getEmail() {
        return email; 
    }
    // Retorna o email do usuário.

    public void setEmail(String email) {
        this.email = email; 
    }
    // Define o email do usuário.

    public String getCpf() {
        return cpf; 
    }
    // Retorna o CPF do usuário.

    public void setCpf(String cpf) {
        this.cpf = cpf; 
    }
    // Define o CPF do usuário.

    public String getPassword() {
        return password; 
    }
    // Retorna a senha do usuário.

    public void setPassword(String password) {
        this.password = password; 
    }
    // Define a senha do usuário.

    public String getName() {
        return name; 
    }
    // Retorna o nome completo do usuário.

    public void setName(String name) {
        this.name = name; 
    }
    // Define o nome completo do usuário.
}
