package br.com.projeto.repository;
// Define o pacote da classe, pertencente à camada de repositório, que interage com o banco de dados.

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.model.Imovel;
// Importa a classe `List`, usada para retornar coleções de imóveis.

@Repository
// Anota a interface como um repositório Spring, para que seja gerenciada pelo container de injeção de dependência.
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    // Interface que estende `JpaRepository`, especificando a entidade `Imovel` e o tipo de sua chave primária (`Long`).

    List<Imovel> findByNomeContainingIgnoreCase(String nome);
    // Declara um método customizado para buscar imóveis cujo nome contenha uma sequência de caracteres específica,
    // ignorando diferenças entre maiúsculas e minúsculas.
    // Retorna uma lista de objetos `Imovel` que correspondem ao critério de busca.
}
