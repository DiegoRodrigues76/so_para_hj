package br.com.projeto.util;
// Define o pacote da classe. Este pacote é destinado a utilitários ou classes auxiliares.

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// Importa a classe `BCryptPasswordEncoder`, que é usada para criptografar e verificar senhas.

public class SenhaUtils {
    // Classe utilitária para manipulação de senhas, como criptografia e validação.

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    // Cria uma instância do `BCryptPasswordEncoder` como um campo estático e final, 
    // permitindo seu uso em todos os métodos da classe.

    /**
     * Criptografa a senha usando o BCrypt.
     * @param senha A senha em texto puro a ser criptografada.
     * @return Uma string representando a senha criptografada.
     */
    public static String criptografarSenha(String senha) {
        return encoder.encode(senha);
        // Usa o método `encode` do `BCryptPasswordEncoder` para gerar uma hash segura da senha fornecida.
    }

    /**
     * Verifica se a senha fornecida corresponde à senha criptografada.
     * @param senha A senha em texto puro a ser comparada.
     * @param senhaCriptografada A senha criptografada para comparação.
     * @return `true` se a senha fornecida corresponder à senha criptografada, caso contrário, `false`.
     */
    public static boolean verificarSenha(String senha, String senhaCriptografada) {
        return encoder.matches(senha, senhaCriptografada);
        // Usa o método `matches` do `BCryptPasswordEncoder` para comparar a senha em texto puro 
        // com a senha criptografada e verifica se são equivalentes.
    }
}
