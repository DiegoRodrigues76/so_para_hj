package br.com.projeto.exception;

// Define o pacote da classe `ErrorResponse`, que é usada para representar os detalhes do erro retornado ao cliente.

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// A anotação `@Data` é fornecida pelo Lombok. Ela gera automaticamente os métodos `getters`, `setters`, `toString()`, `equals()` e `hashCode()` para todos os campos da classe.
@AllArgsConstructor
// A anotação `@AllArgsConstructor` também do Lombok gera automaticamente um construtor com todos os campos da classe como parâmetros. 
public class ErrorResponse {

    private LocalDateTime timestamp; // Representa o momento em que o erro ocorreu. Útil para auditoria e rastreamento de problemas.
    private String message; // Mensagem de erro, geralmente relacionada ao tipo de erro ou a causa do problema.
    private String details; // Detalhes adicionais sobre o erro. Pode conter informações como quais campos causaram falha de validação ou o que exatamente deu errado.

}
