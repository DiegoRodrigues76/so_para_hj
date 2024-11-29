package br.com.projeto.dto;

// Define o pacote `br.com.projeto.dto`, que é utilizado para armazenar objetos de transferência de dados (DTO).

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
// A anotação `@Data` do Lombok gera automaticamente os métodos `getters`, `setters`, `toString()`, `equals()` e `hashCode()` para todos os campos da classe.
// Isso reduz a quantidade de código boilerplate, facilitando a criação de objetos e suas manipulações.
public class UsuarioDTO {

    @NotBlank(message = "O nome é obrigatório.")
    // A anotação `@NotBlank` valida se o campo `nome` não é nulo nem vazio.
    // Se o campo for inválido, a mensagem "O nome é obrigatório." será retornada.
    private String nome;

    @Email(message = "O email deve ser válido.")
    // A anotação `@Email` garante que o valor do campo `email` seja um email válido (formato de endereço de email correto).
    // Se o email não for válido, a mensagem "O email deve ser válido." será retornada.
    
    @NotBlank(message = "O email é obrigatório.")
    // A anotação `@NotBlank` valida se o campo `email` não é nulo nem vazio.
    // Se o campo for inválido, a mensagem "O email é obrigatório." será retornada.
    private String email;

    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    // A anotação `@Size` valida o comprimento da senha. Aqui, é exigido que a senha tenha pelo menos 6 caracteres.
    // Se a senha for muito curta, a mensagem "A senha deve ter pelo menos 6 caracteres." será retornada.
    private String senha;
}
