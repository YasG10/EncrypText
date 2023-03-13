package Encrypt;
import java.security.SecureRandom;

public class IVGenerator {

    public static byte[] generateIV() {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        return iv;
    }

}
