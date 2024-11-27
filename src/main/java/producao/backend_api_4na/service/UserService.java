package producao.backend_api_4na.service;

import producao.backend_api_4na.dto.UserDTO; 
// Importa o DTO (Data Transfer Object) que será utilizado para transferir dados de usuário.

import producao.backend_api_4na.entity.User; 
// Importa a entidade User, que representa o modelo de dados de usuário no sistema.

public interface UserService {
    // Define a interface para o serviço de usuário, que descreve os métodos a serem implementados.

    User createUser(UserDTO userDTO); 
    // Método para criar um novo usuário a partir de um objeto UserDTO.

    User updateUser(Long id, UserDTO userDTO); 
    // Método para atualizar um usuário existente, identificado por seu ID, com os dados de um UserDTO.

    void deleteUser(Long id); 
    // Método para deletar um usuário identificado por seu ID.

    User getUserByEmail(String email); 
    // Método para buscar um usuário a partir de seu email.
}
