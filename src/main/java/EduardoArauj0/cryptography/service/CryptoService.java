package EduardoArauj0.cryptography.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class CryptoService {

    public static final StrongTextEncryptor encryptor;

    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword(System.getenv("123"));
    }

    public static String encrypt(String rawText) {
        return encrypt.encrypt(rawText);
    }

    public static String decrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }
}