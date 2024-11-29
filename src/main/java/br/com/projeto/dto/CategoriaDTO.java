package br.com.projeto.dto;

// Define o pacote `br.com.projeto.dto`, que é utilizado para armazenar objetos de transferência de dados (DTO).

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
// A anotação `@Data` do Lombok gera automaticamente os métodos getters, setters, equals, hashCode e toString para a classe.
// Isso ajuda a evitar a necessidade de escrever código repetitivo.

public class CategoriaDTO {

    @NotBlank(message = "O nome da categoria não pode ser vazio.")
    // A anotação `@NotBlank` é usada para garantir que o campo `nome` não seja nulo nem vazio.
    // Se o valor do campo for nulo ou uma string vazia, a validação falha e o sistema retornará a mensagem de erro fornecida.
    private String nome;

}
