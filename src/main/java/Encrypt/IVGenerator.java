package Encrypt;
import java.security.SecureRandom;

public class IVGenerator {
    public static byte[] generateIV(int size) {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[size];
        random.nextBytes(iv);
        return iv;
    }
}
