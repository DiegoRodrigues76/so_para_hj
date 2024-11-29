package br.com.projeto.service;
// Define o pacote da classe, destinado a lógica de negócios (services) da aplicação.

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dto.UsuarioDTO;
import br.com.projeto.model.Usuario;
import br.com.projeto.repository.UsuarioRepository;
// Importa a classe `Optional`, usada para lidar com valores que podem ou não estar presentes.

@Service
// Marca a classe como um serviço do Spring, para que seja gerenciada pelo container de injeção de dependência.
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    // Injeta automaticamente uma instância de `UsuarioRepository`, que será usada para interagir com o banco de dados.

    public Usuario salvar(UsuarioDTO dto) {
        // Método para salvar um novo usuário. Recebe um `UsuarioDTO` como entrada.

        Optional<Usuario> existente = repository.findByEmail(dto.getEmail());
        // Verifica no banco de dados se já existe um usuário com o mesmo email.

        if (existente.isPresent()) {
            // Se um usuário com o mesmo email já existir, lança uma exceção.
            throw new RuntimeException("Email já cadastrado.");
        }

        Usuario usuario = new Usuario();
        // Cria uma nova instância da entidade `Usuario`.

        usuario.setNome(dto.getNome());
        // Define o nome do usuário a partir do DTO recebido.

        usuario.setEmail(dto.getEmail());
        // Define o email do usuário a partir do DTO recebido.

        usuario.setSenha(dto.getSenha());
        // Define a senha do usuário. OBS: É altamente recomendável criptografar a senha antes de salvar, 
        // usando um método como o `SenhaUtils.criptografarSenha()` mostrado anteriormente.

        return repository.save(usuario);
        // Salva o usuário no banco de dados usando o repositório e retorna o usuário salvo.
    }
}
