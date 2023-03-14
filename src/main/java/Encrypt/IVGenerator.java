package Encrypt;
import java.security.SecureRandom;

import static java.security.DrbgParameters.nextBytes;

public class IVGenerator {

    public static byte[] generateIV() {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv);


        for (int i =0; i < iv.length; i++){
            iv[i] = (byte) random.nextDouble(0, 9);
        }
        var lol = 100;
        System.out.println((byte) lol);


        return iv;
    }

}
