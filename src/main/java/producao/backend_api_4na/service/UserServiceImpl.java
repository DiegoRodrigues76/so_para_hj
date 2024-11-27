package producao.backend_api_4na.service;

import producao.backend_api_4na.dto.UserDTO; 
// Importa o DTO (Data Transfer Object) para transferência de dados do usuário.

import producao.backend_api_4na.entity.User; 
// Importa a entidade User, que representa o modelo de dados no banco.

import producao.backend_api_4na.repository.UserRepository; 
// Importa o repositório para operações de acesso ao banco de dados.

import org.springframework.beans.factory.annotation.Autowired; 
// Importa a anotação para injeção de dependências automáticas no Spring.

import org.springframework.stereotype.Service; 
// Indica que esta classe é um componente de serviço gerenciado pelo Spring.

@Service
// Marca esta classe como um serviço Spring, permitindo sua injeção e uso em outras partes da aplicação.
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository; 
    // Injeta automaticamente o repositório de usuários para interagir com o banco de dados.

    @Override
    public User createUser(UserDTO userDTO) {
        // Método para criar um novo usuário a partir de um UserDTO.
        User user = new User(); 
        // Cria uma nova instância da entidade User.
        user.setUsername(userDTO.getUsername());  
        // Define o username a partir do DTO.
        user.setEmail(userDTO.getEmail()); 
        // Define o email a partir do DTO.
        user.setCpf(userDTO.getCpf()); 
        // Define o CPF a partir do DTO.
        user.setPassword(userDTO.getPassword()); 
        // Define a senha a partir do DTO.
        return userRepository.save(user); 
        // Salva o usuário no banco de dados e retorna o objeto salvo.
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        // Método para atualizar os dados de um usuário existente.
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        // Busca o usuário pelo ID e lança uma exceção se não for encontrado.
        user.setUsername(userDTO.getUsername()); 
        // Atualiza o username do usuário.
        user.setEmail(userDTO.getEmail()); 
        // Atualiza o email do usuário.
        user.setCpf(userDTO.getCpf()); 
        // Atualiza o CPF do usuário.
        user.setPassword(userDTO.getPassword()); 
        // Atualiza a senha do usuário.
        return userRepository.save(user); 
        // Salva as alterações no banco de dados.
    }

    @Override
    public void deleteUser(Long id) {
        // Método para deletar um usuário pelo ID.
        userRepository.deleteById(id); 
        // Remove o usuário correspondente do banco de dados.
    }

    @Override
    public User getUserByEmail(String email) {
        // Método para buscar um usuário pelo email.
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found")); 
        // Retorna o usuário correspondente ou lança uma exceção se não encontrado.
    }
}
