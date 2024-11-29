package br.com.projeto.controller;

// Define o pacote `br.com.projeto.controller`, onde a classe `CategoriaController` é armazenada, responsável por lidar com as requisições da API relacionadas a categorias.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.dto.CategoriaDTO;
import br.com.projeto.model.Categoria;
import br.com.projeto.service.CategoriaService;
import jakarta.validation.Valid;

@RestController
// A anotação `@RestController` define que essa classe é um controlador REST. Ela combina a funcionalidade de `@Controller` e `@ResponseBody`, retornando os dados em formato JSON ou XML.
@RequestMapping("/api/categorias")
// Define o caminho base para todos os métodos dessa classe. Ou seja, todas as rotas relacionadas a categorias começam com "/api/categorias".
public class CategoriaController {

    @Autowired
    private CategoriaService service;
    // A anotação `@Autowired` injeta automaticamente a instância do serviço `CategoriaService`, que será usada para manipular as categorias.

    /**
     * Endpoint para criar uma nova categoria.
     */
    @PostMapping
    // A anotação `@PostMapping` define que este método irá lidar com requisições HTTP do tipo POST.
    // Esse método será acionado quando uma requisição POST for feita para "/api/categorias".
    public Categoria criar(@RequestBody @Valid CategoriaDTO dto) {
        // O `@RequestBody` indica que o corpo da requisição será convertido para um objeto `CategoriaDTO`.
        // O `@Valid` garante que o DTO será validado antes de ser processado.
        // O método `service.salvar(dto)` chama o serviço para salvar a categoria no banco de dados.
        return service.salvar(dto);
    }

    /**
     * Endpoint para listar todas as categorias.
     */
    @GetMapping
    // A anotação `@GetMapping` define que este método irá lidar com requisições HTTP do tipo GET.
    // Esse método será acionado quando uma requisição GET for feita para "/api/categorias".
    public List<Categoria> listarTodas() {
        // O método `service.listarTodas()` retorna uma lista com todas as categorias cadastradas no banco de dados.
        return service.listarTodas();
    }
}
