package producao.backend_api_4na.controller;

import producao.backend_api_4na.dto.UserDTO; 
// Importa a classe UserDTO, que é usada para transferir os dados do usuário entre o cliente e o servidor.

import producao.backend_api_4na.entity.User; 
// Importa a classe User, que é a entidade persistida no banco de dados.

import producao.backend_api_4na.service.UserService; 
// Importa a interface UserService, que define as operações do serviço de usuários.

import org.springframework.beans.factory.annotation.Autowired; 
// Importa a anotação Autowired, usada para injetar dependências automaticamente.

import org.springframework.web.bind.annotation.*; 
// Importa as anotações de controle de rotas do Spring MVC, como @RestController, @RequestMapping, @PostMapping, etc.

@RestController 
// Define que esta classe é um controlador REST, ou seja, os métodos vão responder a requisições HTTP com dados em formato JSON, por exemplo.

@RequestMapping("/users") 
// Define o caminho base "/users" para todas as rotas definidas dentro desta classe.

public class UserController {

    @Autowired 
    // Injeção automática de dependência para o UserService, que contém a lógica de negócios para lidar com usuários.
    private UserService userService;

    @PostMapping 
    // Define que este método vai responder a requisições HTTP POST para criar um novo usuário.
    public User createUser(@RequestBody UserDTO userDTO) {
        // Recebe os dados do usuário (no formato JSON) no corpo da requisição e os converte em um objeto UserDTO.
        return userService.createUser(userDTO);  
        // Chama o método createUser do serviço de usuários e retorna o usuário criado.
    }

    @PutMapping("/{id}") 
    // Define que este método vai responder a requisições HTTP PUT para atualizar um usuário existente, com base no ID.
    public User updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        // Recebe o ID do usuário na URL e os dados de atualização no corpo da requisição.
        return userService.updateUser(id, userDTO);  
        // Chama o método updateUser do serviço de usuários para atualizar o usuário com o ID especificado e retorna o usuário atualizado.
    }

    @DeleteMapping("/{id}") 
    // Define que este método vai responder a requisições HTTP DELETE para excluir um usuário, com base no ID.
    public void deleteUser(@PathVariable Long id) {
        // Recebe o ID do usuário a ser deletado na URL e chama o método deleteUser do serviço para removê-lo.
        userService.deleteUser(id); 
    }

    @GetMapping("/email/{email}") 
    // Define que este método vai responder a requisições HTTP GET para buscar um usuário com base no email.
    public User getUserByEmail(@PathVariable String email) {
        // Recebe o email do usuário na URL e chama o método getUserByEmail do serviço para retornar o usuário correspondente.
        return userService.getUserByEmail(email);
    }
}
