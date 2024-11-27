package producao.backend_api_4na.security;

import io.jsonwebtoken.Jwts; 
// Importa a biblioteca JJWT para manipulação de tokens JWT (JSON Web Tokens).

import io.jsonwebtoken.SignatureAlgorithm; 
// Importa os algoritmos de assinatura para tokens JWT, como HS512.

import org.springframework.stereotype.Component; 
// Marca esta classe como um componente Spring para ser gerenciada pelo contêiner de dependências.

import java.util.Date; 
// Importa a classe Date para manipulação de datas (data de emissão e expiração do token).

@Component
// Define a classe como um componente Spring para permitir a injeção de dependência em outras partes da aplicação.
public class JwtTokenProvider {

    private final String secretKey = "secrect-key"; 
    // Define a chave secreta usada para assinar e validar os tokens JWT. (Nota: a chave deve ser segura e não hardcoded em produção).

    private final long validityInMilliseconds = 600000; 
    // Define o tempo de validade do token em milissegundos (600000 ms = 10 minutos).

    @SuppressWarnings("deprecation")
    public String createToken(String username) {
        // Método para criar um token JWT com base no nome de usuário.
        Date now = new Date(); 
        // Obtém a data e hora atual para definir a data de emissão do token.

        Date validity = new Date(now.getTime() + validityInMilliseconds); 
        // Define a data de expiração do token somando o tempo de validade à data atual.

        // Gera o token JWT com as informações necessárias
        return Jwts.builder()
                .setSubject(username) // Define o subject do token como o nome de usuário.
                .setIssuedAt(now) // Define a data de emissão do token.
                .setExpiration(validity) // Define a data de expiração do token.
                .signWith(SignatureAlgorithm.HS512, secretKey) // Assina o token com o algoritmo HS512 e a chave secreta.
                .compact(); // Compacta o token gerado e o retorna como uma string.
    }

    @SuppressWarnings("deprecation")
    public String getUsernameFromToken(String token) {
        // Método para extrair o nome de usuário (subject) a partir de um token JWT.
        return Jwts.parser() 
                .setSigningKey(secretKey) // Define a chave secreta usada para validar o token.
                .parseClaimsJws(token) // Analisa o token JWT e extrai as claims.
                .getBody() // Obtém o corpo (payload) do token, que contém as informações.
                .getSubject(); // Retorna o subject do token, que é o nome de usuário.
    }
}
