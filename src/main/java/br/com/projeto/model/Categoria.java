package br.com.projeto.model;
// Define o pacote da classe `Categoria`, que faz parte da camada de modelo, representando a estrutura de dados da categoria no sistema.

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
// Importa a anotação `@Data` do Lombok, que gera automaticamente os métodos getters, setters, `toString`, `equals`, e `hashCode`.

@Entity
// Anotação que marca a classe como uma entidade JPA. A classe será mapeada para uma tabela no banco de dados.
@Data
// Anotação do Lombok que gera automaticamente os métodos `getters`, `setters`, `toString()`, `equals()`, `hashCode()` para todos os campos da classe.
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Define o campo `id` como a chave primária da entidade `Categoria`.
    // A anotação `@GeneratedValue(strategy = GenerationType.IDENTITY)` indica que o valor do `id` será gerado automaticamente pelo banco de dados com a estratégia de auto incremento.
    private Long id;

    @Column(nullable = false, unique = true)
    // Define o campo `nome` como uma coluna obrigatória (não pode ser nulo) e única na tabela.
    private String nome;
}
