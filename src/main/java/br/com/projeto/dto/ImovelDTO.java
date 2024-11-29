package br.com.projeto.dto;

// Define o pacote `br.com.projeto.dto`, que é utilizado para armazenar objetos de transferência de dados (DTO).

import jakarta.validation.constraints.NotNull;

public class ImovelDTO {

    @NotNull
    // A anotação `@NotNull` garante que o valor do campo `nome` não seja nulo.
    // Se o valor for nulo, a validação falha e o sistema retorna uma mensagem de erro.
    private String nome;

    @NotNull
    // A anotação `@NotNull` é aplicada para garantir que o campo `endereco` não seja nulo.
    // A validação assegura que um endereço seja fornecido para o imóvel.
    private String endereco;

    @NotNull
    // A anotação `@NotNull` aqui garante que o campo `valor` não seja nulo.
    // O valor do imóvel é um campo essencial, portanto, ele deve ser fornecido.
    private Double valor;

    @NotNull
    // A anotação `@NotNull` para o campo `operacao` indica que o tipo de operação (ex: compra, venda, aluguel) é obrigatório.
    // Sem o tipo de operação, o imóvel não pode ser processado corretamente.
    private String operacao; // Operação é obrigatória

    @NotNull
    // A anotação `@NotNull` para o campo `categoriaId` garante que o campo não seja nulo.
    // O campo `categoriaId` refere-se ao ID da categoria do imóvel, que é essencial para categorizar o imóvel.
    private Long categoriaId;

    @NotNull
    // A anotação `@NotNull` para o campo `usuarioId` garante que o campo não seja nulo.
    // O campo `usuarioId` refere-se ao ID do usuário que está associando o imóvel, e é necessário para determinar quem é o responsável.
    private Long usuarioId;

    // Getters e Setters gerados manualmente para acessar e modificar os campos da classe.

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
        return operacao; // Getter para o campo operacao
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao; // Setter para o campo operacao
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
