package EduardoArauj0.cryptography.service;
import org.jasypt.util.text.StrongTextEncryptor;

public class CryptoService{

 
    public static final StrongTextEncryptor encryptor;

    static {
         encryptor = new StrongTextEncryptor();
         encryptor.setPassword(System.getenv(  "APP_KEY"));
    }
}