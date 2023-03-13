package Encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class AES {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String HASH_ALGORITHM = "SHA-256";

    public static String encrypt(String key, byte[] iv, String plaintext) throws Exception {
        SecretKeySpec secretKeySpec = generateKey(key);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String key, byte[] iv, String ciphertext) throws Exception {
        SecretKeySpec secretKeySpec = generateKey(key);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] decoded = Base64.getDecoder().decode(ciphertext);
        byte[] decrypted = cipher.doFinal(decoded);

        return new String(decrypted, StandardCharsets.UTF_8);
    }


    private static SecretKeySpec generateKey(String key) throws Exception {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        MessageDigest sha = MessageDigest.getInstance(HASH_ALGORITHM);
        keyBytes = sha.digest(keyBytes);
        keyBytes = Arrays.copyOf(keyBytes, 16);

        return new SecretKeySpec(keyBytes, "AES");
    }

    public static void main(String[] args) {
        String key = "clave secreta";
        String iv =  "/gs8945}][@q24[#";
        System.out.println(iv.toString());

        String plaintext = "Hola Mundo";
        /*
        try {
            // Cifrado
            String ciphertext = AES.encrypt(key, iv, plaintext);
            System.out.println("Texto cifrado: " + ciphertext);

            // Descifrado
            String decrypted = AES.decrypt(key,iv, ciphertext);
            System.out.println("Texto descifrado: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

         */
    }



}

