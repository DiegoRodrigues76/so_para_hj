package br.com.projeto.exception;
// Define o pacote para a classe `GlobalExceptionHandler`, que contém a lógica para o tratamento global de exceções.

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// Anotação que marca a classe como um manipulador global de exceções. A anotação `@RestControllerAdvice` combina o comportamento de `@ControllerAdvice` com `@ResponseBody`,
// o que significa que todas as exceções tratadas nesta classe irão retornar uma resposta no formato JSON.
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    // Anotação que define um método para tratar exceções do tipo `RuntimeException` (exceções genéricas em tempo de execução).
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        // Cria uma instância de `ErrorResponse` para representar os detalhes do erro.
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(), // Hora atual para o momento do erro.
                ex.getMessage(), // A mensagem de erro proveniente da exceção.
                "Erro interno no servidor" // Mensagem padrão para erros internos.
        );
        // Retorna um `ResponseEntity` com o corpo da resposta `error` e o status HTTP 500 (Erro Interno do Servidor).
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    // Anotação que define um método para tratar exceções do tipo `MethodArgumentNotValidException`,
    // que ocorre quando há falhas de validação de argumentos de métodos (normalmente em parâmetros de controladores).
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        // Extrai os erros de validação dos campos dos objetos e os formata como uma string.
        String errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage()) // Cria a mensagem de erro formatada com o nome do campo e a mensagem de erro.
                .collect(Collectors.joining(", ")); // Junta todos os erros em uma string separada por vírgulas.

        // Cria uma instância de `ErrorResponse` para representar os detalhes do erro de validação.
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(), // Hora atual para o momento do erro.
                "Erro de validação", // Mensagem indicando que ocorreu um erro de validação.
                errors // A lista formatada de erros.
        );
        // Retorna um `ResponseEntity` com o corpo da resposta `error` e o status HTTP 400 (Bad Request).
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
