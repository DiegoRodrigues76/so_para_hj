package br.com.projeto.service;
// Define o pacote da classe, indicando que faz parte da camada de serviço (lógica de negócios).

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dto.ImovelDTO;
import br.com.projeto.model.Categoria;
import br.com.projeto.model.Imovel;
import br.com.projeto.repository.CategoriaRepository;
import br.com.projeto.repository.ImovelRepository;
// Importa a classe `List`, usada para retornar coleções de imóveis.

@Service
// Indica que esta classe é um serviço gerenciado pelo Spring.
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;
    // Injeta o repositório de imóveis para interagir com o banco de dados.

    @Autowired
    private CategoriaRepository categoriaRepository;
    // Injeta o repositório de categorias para buscar e manipular dados relacionados à categoria.

    public Imovel salvar(ImovelDTO dto) {
        // Método responsável por salvar um novo imóvel.

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
        // Busca a categoria pelo ID fornecido no DTO. Lança uma exceção se a categoria não for encontrada.

        Imovel imovel = new Imovel();
        // Cria uma nova instância de `Imovel`.

        imovel.setNome(dto.getNome());
        imovel.setEndereco(dto.getEndereco());
        imovel.setValor(dto.getValor());
        imovel.setOperacao(dto.getOperacao());
        imovel.setCategoria(categoria);
        // Define os atributos do imóvel a partir dos dados do DTO e da categoria encontrada.

        return imovelRepository.save(imovel);
        // Salva o imóvel no banco de dados e retorna o imóvel salvo.
    }

    public List<Imovel> listarTodos() {
        // Método para listar todos os imóveis cadastrados.
        return imovelRepository.findAll();
        // Retorna todos os imóveis presentes no banco.
    }

    public List<Imovel> buscarPorNome(String nome) {
        // Método para buscar imóveis pelo nome (parcial ou completo), ignorando diferenças de maiúsculas/minúsculas.
        return imovelRepository.findByNomeContainingIgnoreCase(nome);
        // Retorna a lista de imóveis que contenham o nome fornecido.
    }

    public Imovel atualizar(Long id, ImovelDTO dto) {
        // Método para atualizar um imóvel existente.

        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado."));
        // Busca o imóvel pelo ID fornecido. Lança uma exceção se o imóvel não for encontrado.

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
        // Busca a categoria pelo ID no DTO. Lança uma exceção se não encontrar.

        imovel.setNome(dto.getNome());
        imovel.setEndereco(dto.getEndereco());
        imovel.setValor(dto.getValor());
        imovel.setOperacao(dto.getOperacao());
        imovel.setCategoria(categoria);
        // Atualiza os atributos do imóvel com os novos valores fornecidos.

        return imovelRepository.save(imovel);
        // Salva e retorna o imóvel atualizado.
    }

    public void deletar(Long id) {
        // Método para deletar um imóvel pelo ID.

        if (!imovelRepository.existsById(id)) {
            throw new RuntimeException("Imóvel não encontrado.");
        }
        // Verifica se o imóvel existe no banco. Lança uma exceção caso não exista.

        imovelRepository.deleteById(id);
        // Exclui o imóvel do banco de dados.
    }
}
