package br.com.projeto.model;
// Define o pacote da classe, que faz parte da camada de modelo, a qual representa a estrutura de dados no sistema.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
// Importa a anotação `@NotNull`, que assegura que os campos anotados não possam ter valores nulos.

@Entity
// Anotação que marca a classe como uma entidade JPA. Essa classe será mapeada para uma tabela no banco de dados.
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Define o campo `id` como a chave primária da entidade `Imovel`.
    // O valor do `id` será gerado automaticamente pelo banco de dados com a estratégia `GenerationType.IDENTITY` (auto incremento).
    private Long id;

    @NotNull
    // Indica que o campo `nome` não pode ser nulo.
    private String nome;

    @NotNull
    // Indica que o campo `endereco` não pode ser nulo.
    private String endereco;

    @NotNull
    // Indica que o campo `valor` (preço do imóvel) não pode ser nulo.
    private Double valor;

    @NotNull
    // Indica que o campo `operacao` não pode ser nulo. Ele representa o tipo de operação (venda ou aluguel, por exemplo).
    private String operacao; // Atributo que define a operação do imóvel (ex: "venda", "aluguel")

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    // Define um relacionamento muitos-para-um entre `Imovel` e `Categoria`, ou seja, um imóvel pertence a uma categoria.
    // A coluna `categoria_id` será criada no banco para armazenar a chave estrangeira que referencia a tabela `Categoria`.
    // A anotação `nullable = false` garante que o campo `categoria_id` não pode ser nulo.
    private Categoria categoria;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getOperacao() {
        return operacao; // Getter para o campo `operacao`, que pode ser "venda" ou "aluguel".
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao; // Setter para o campo `operacao`.
    }

    public Categoria getCategoria() {
        return categoria; // Getter para o campo `categoria`, que é uma entidade do tipo `Categoria`.
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria; // Setter para o campo `categoria`.
    }
}
