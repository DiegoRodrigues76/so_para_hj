package br.com.projeto.service;
// Define o pacote da classe, destinado à lógica de negócios (services) da aplicação.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dto.CategoriaDTO;
import br.com.projeto.model.Categoria;
import br.com.projeto.repository.CategoriaRepository;
// Importa a classe `List`, usada para retornar coleções de categorias.

@Service
// Marca a classe como um componente de serviço no contexto do Spring, responsável pela lógica de negócios.
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;
    // Injeta automaticamente uma instância de `CategoriaRepository`, usada para acessar o banco de dados.

    public Categoria salvar(CategoriaDTO dto) {
        // Método responsável por salvar uma nova categoria.

        if (repository.findByNome(dto.getNome()).isPresent()) {
            // Verifica se já existe uma categoria com o mesmo nome no banco de dados.
            throw new RuntimeException("Já existe uma categoria com esse nome.");
            // Lança uma exceção se o nome da categoria já estiver cadastrado.
        }

        Categoria categoria = new Categoria();
        // Cria uma nova instância da entidade `Categoria`.

        categoria.setNome(dto.getNome());
        // Define o nome da categoria com base no valor fornecido pelo DTO.

        return repository.save(categoria);
        // Salva a nova categoria no banco de dados e retorna o objeto salvo.
    }

    public List<Categoria> listarTodas() {
        // Método para listar todas as categorias cadastradas.
        return repository.findAll();
        // Retorna uma lista contendo todas as categorias no banco de dados.
    }
}
