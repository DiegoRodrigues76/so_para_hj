package br.com.projeto.controller;

// Define o pacote `br.com.projeto.controller`, que é utilizado para armazenar os controladores da API REST.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.dto.ImovelDTO;
import br.com.projeto.model.Imovel;
import br.com.projeto.service.ImovelService;
import jakarta.validation.Valid;

@RestController
// A anotação `@RestController` define que essa classe será um controlador REST, que lida com as requisições HTTP e retorna dados em formato JSON.
@RequestMapping("/api/imoveis")
// Define o caminho base para os métodos dessa classe. Ou seja, todas as rotas começando com "/api/imoveis" serão tratadas por esse controlador.

public class ImovelController {

    @Autowired
    private ImovelService imovelService;
    // A anotação `@Autowired` injeta automaticamente o serviço `ImovelService` no controlador. O controlador pode usar os métodos do serviço para manipular imóveis.

    /**
     * Endpoint para criar um novo imóvel.
     */
    @PostMapping
    // A anotação `@PostMapping` define que esse método irá lidar com requisições HTTP do tipo POST.
    // Esse método será acionado quando uma requisição POST for feita para "/api/imoveis".
    public Imovel salvar(@RequestBody @Valid ImovelDTO dto) {
        // O `@RequestBody` indica que o corpo da requisição será convertido (desserializado) para um objeto `ImovelDTO`.
        // O `@Valid` garante que o DTO será validado antes de ser processado.
        // O método `imovelService.salvar(dto)` chama o serviço para salvar o imóvel no banco de dados.
        return imovelService.salvar(dto);
    }

    /**
     * Endpoint para listar todos os imóveis.
     */
    @GetMapping
    // A anotação `@GetMapping` define que esse método irá lidar com requisições HTTP do tipo GET.
    // Esse método será acionado quando uma requisição GET for feita para "/api/imoveis".
    public List<Imovel> listarTodos() {
        // O método `imovelService.listarTodos()` busca todos os imóveis no banco de dados e retorna a lista de imóveis.
        return imovelService.listarTodos();
    }

    /**
     * Endpoint para buscar imóveis pelo nome.
     *
     * @param nome Nome do imóvel a ser buscado.
     */
    @GetMapping("/nome")
    // Esse método lida com requisições GET para "/api/imoveis/nome". Ele busca imóveis com base no nome.
    public List<Imovel> buscarPorNome(@RequestParam String nome) {
        // O `@RequestParam` indica que o valor de `nome` será extraído da query string da URL.
        // Exemplo: "/api/imoveis/nome?nome=Apartamento".
        // O método `imovelService.buscarPorNome(nome)` retorna a lista de imóveis que correspondem ao nome fornecido.
        return imovelService.buscarPorNome(nome);
    }

    /**
     * Endpoint para atualizar um imóvel.
     *
     * @param id  ID do imóvel a ser atualizado.
     * @param dto Dados atualizados do imóvel.
     */
    @PutMapping("/{id}")
    // A anotação `@PutMapping("/{id}")` define que esse método irá lidar com requisições HTTP do tipo PUT.
    // Esse método será acionado quando uma requisição PUT for feita para "/api/imoveis/{id}".
    // O `{id}` na URL é um parâmetro que representa o ID do imóvel a ser atualizado.
    public Imovel atualizar(@PathVariable Long id, @RequestBody @Valid ImovelDTO dto) {
        // O `@PathVariable` indica que o parâmetro `id` será extraído da URL.
        // O `@RequestBody` indica que o corpo da requisição será convertido para um objeto `ImovelDTO`.
        // O método `imovelService.atualizar(id, dto)` chama o serviço para atualizar o imóvel com o ID fornecido.
        return imovelService.atualizar(id, dto);
    }

    /**
     * Endpoint para deletar um imóvel pelo ID.
     *
     * @param id ID do imóvel a ser deletado.
     */
    @DeleteMapping("/{id}")
    // A anotação `@DeleteMapping("/{id}")` define que esse método irá lidar com requisições HTTP do tipo DELETE.
    // Esse método será acionado quando uma requisição DELETE for feita para "/api/imoveis/{id}".
    // O `{id}` na URL é um parâmetro que representa o ID do imóvel a ser deletado.
    public void deletar(@PathVariable Long id) {
        // O `@PathVariable` indica que o parâmetro `id` será extraído da URL.
        // O método `imovelService.deletar(id)` chama o serviço para deletar o imóvel com o ID fornecido.
        imovelService.deletar(id);
    }
}
