package br.com.projeto.model;
// Define o pacote da classe, pertencente à camada de modelo, que representa a estrutura de dados do sistema.

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
// Importa a anotação `@Data` do Lombok, que gera automaticamente getters, setters, `toString`, `equals` e `hashCode` para a classe.

@Entity
// Marca a classe como uma entidade JPA, ou seja, ela será mapeada para uma tabela no banco de dados.
@Data
// Gera automaticamente métodos de acesso (`getters` e `setters`), além de `toString`, `equals` e `hashCode` usando Lombok.
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Define o campo `id` como chave primária da entidade e indica que seu valor será gerado automaticamente pelo banco de dados.
    private Long id;

    @Column(nullable = false, unique = true)
    // Mapeia o campo `email` como uma coluna que não pode ser nula e deve ser única na tabela do banco de dados.
    private String email;

    @Column(nullable = false)
    // Mapeia o campo `nome` como uma coluna que não pode ser nula.
    private String nome;

    @Column(nullable = false)
    // Mapeia o campo `senha` como uma coluna que não pode ser nula.
    private String senha;
}
