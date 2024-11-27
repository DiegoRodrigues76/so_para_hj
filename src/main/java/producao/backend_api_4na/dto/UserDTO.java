package producao.backend_api_4na.dto;

public class UserDTO {
    // Define a classe UserDTO que é usada para transferir dados de um usuário (sem persistir no banco de dados).

    private String username; 
    // Define o campo username para armazenar o nome de usuário do DTO.

    private String email; 
    // Define o campo email para armazenar o email do DTO.

    private String cpf; 
    // Define o campo cpf para armazenar o CPF do DTO.

    private String password; 
    // Define o campo password para armazenar a senha do DTO.

    // Getters e Setters

    public String getUsername() {
        return username; 
    }
    // Retorna o nome de usuário do DTO.

    public void setUsername(String username) {
        this.username = username; 
    }
    // Define o nome de usuário no DTO.

    public String getEmail() {
        return email; 
    }
    // Retorna o email do DTO.

    public void setEmail(String email) {
        this.email = email; 
    }
    // Define o email no DTO.

    public String getCpf() {
        return cpf; 
    }
    // Retorna o CPF do DTO.

    public void setCpf(String cpf) {
        this.cpf = cpf; 
    }
    // Define o CPF no DTO.

    public String getPassword() {
        return password; 
    }
    // Retorna a senha do DTO.

    public void setPassword(String password) {
        this.password = password; 
    }
    // Define a senha no DTO.
}
