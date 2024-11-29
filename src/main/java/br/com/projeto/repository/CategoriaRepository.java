package br.com.projeto.repository;
// Define o pacote da classe, pertencente à camada de repositório, responsável pela interação com o banco de dados.

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Categoria;
// Importa a classe `Optional`, usada para lidar com retornos que podem estar ausentes.

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Interface que estende `JpaRepository`, indicando que gerencia a entidade `Categoria` e que a chave primária é do tipo `Long`.

    Optional<Categoria> findByNome(String nome);
    // Declara um método customizado para buscar uma categoria pelo nome.
    // Retorna um `Optional`, que pode conter a categoria encontrada ou estar vazio caso nenhuma seja encontrada.
}
