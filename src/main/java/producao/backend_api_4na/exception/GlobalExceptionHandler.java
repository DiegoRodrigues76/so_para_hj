package producao.backend_api_4na.exception;

import org.springframework.http.HttpStatus; 
// Importa o HttpStatus para definir os códigos de status HTTP nas respostas.

import org.springframework.http.ResponseEntity; 
// Importa a classe ResponseEntity, que é usada para construir a resposta HTTP.

import org.springframework.web.bind.MethodArgumentNotValidException; 
// Importa a exceção MethodArgumentNotValidException, que ocorre quando um parâmetro de método não é válido.

import org.springframework.web.bind.annotation.ExceptionHandler; 
// Importa a anotação ExceptionHandler para lidar com exceções específicas.

import org.springframework.web.bind.annotation.RestControllerAdvice; 
// Importa a anotação RestControllerAdvice para definir um controlador global de exceções.

import java.util.HashMap; 
// Importa a classe HashMap para armazenar erros de validação.

import java.util.Map; 
// Importa a interface Map, usada para armazenar pares chave-valor de erros.

@RestControllerAdvice 
// Define um controlador global de exceções que será aplicado a todas as classes de controlador (REST controllers).
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) 
    // Método que trata exceções de validação (MethodArgumentNotValidException) lançadas durante a validação de argumentos.
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>(); 
        // Cria um mapa para armazenar os erros de validação (campo e mensagem de erro).
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        ); 
        // Itera sobre os erros de campo e os adiciona ao mapa.
        return ResponseEntity.badRequest().body(errors); 
        // Retorna uma resposta HTTP 400 (Bad Request) com o mapa de erros.
    }

    @ExceptionHandler(UserNotFoundException.class) 
    // Método que trata exceções UserNotFoundException lançadas quando um usuário não é encontrado.
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()); 
        // Retorna uma resposta HTTP 404 (Not Found) com a mensagem da exceção.
    }
}
