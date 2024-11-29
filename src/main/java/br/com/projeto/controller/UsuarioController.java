package br.com.projeto.controller;

// Define o pacote `br.com.projeto.controller`, que é utilizado para armazenar os controladores da API REST.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.dto.UsuarioDTO;
import br.com.projeto.model.Usuario;
import br.com.projeto.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
// A anotação `@RestController` define que essa classe será um controlador no Spring e que os métodos da classe irão lidar com requisições HTTP.
// Essa anotação é uma combinação de `@Controller` e `@ResponseBody`, significando que a resposta será diretamente escrita no corpo da resposta HTTP.

@RequestMapping("/api/usuarios")
// A anotação `@RequestMapping` define a URL base para os métodos dessa classe. Ou seja, todas as rotas começando com "/api/usuarios" irão passar por esse controlador.

public class UsuarioController {

    @Autowired
    private UsuarioService service;
    // A anotação `@Autowired` é usada para injetar automaticamente a dependência do serviço `UsuarioService` no controlador.
    // Isso permite que o controlador utilize os métodos do serviço para realizar a lógica de negócios.

    @PostMapping
    // A anotação `@PostMapping` define que o método abaixo irá lidar com requisições HTTP do tipo POST.
    // Nesse caso, quando uma requisição POST for feita para "/api/usuarios", esse método será invocado.
    public Usuario criar(@RequestBody @Valid UsuarioDTO dto) {
        // O `@RequestBody` indica que o corpo da requisição será deserializado para o objeto `UsuarioDTO`.
        // O `@Valid` é usado para acionar a validação do DTO, que verifica se os dados enviados estão corretos (por exemplo, se o nome e o e-mail são válidos).
        // Se os dados não forem válidos, uma exceção de validação será lançada automaticamente.
        
        return service.salvar(dto);
        // O método `salvar` do serviço `UsuarioService` é chamado para salvar o usuário no banco de dados.
        // O `UsuarioDTO` (contendo os dados do usuário) é passado como parâmetro para o serviço.
        // Após salvar o usuário, o objeto `Usuario` (representando o usuário criado) é retornado como resposta.
    }
}
