package br.com.projeto.repository;
// Define o pacote da classe, indicando que faz parte da camada de repositório, responsável pela interação com o banco de dados.

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Usuario;
// Importa a classe `Optional`, usada para retornar valores que podem estar ausentes.

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Interface que estende `JpaRepository`, indicando que gerencia a entidade `Usuario` e que a chave primária é do tipo `Long`.

    Optional<Usuario> findByEmail(String email);
    // Declara um método customizado para buscar um usuário pelo email. 
    // Retorna um `Optional` que pode conter o `Usuario` correspondente, ou estar vazio caso não encontre.
}
