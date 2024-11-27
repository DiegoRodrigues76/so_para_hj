package producao.backend_api_4na.exception;

public class UserNotFoundException extends RuntimeException {
    // Define uma exceção personalizada chamada UserNotFoundException que estende RuntimeException.

    public UserNotFoundException(String message) {
        // Construtor que recebe uma mensagem de erro e passa para o construtor da classe pai (RuntimeException).
        super(message); 
        // A mensagem é passada para a classe pai para ser usada como a descrição da exceção.
    }
}
