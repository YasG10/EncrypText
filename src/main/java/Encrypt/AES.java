package Encrypt;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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

    public static String encrypt(String key, byte[] iv, @NotNull String plaintext) throws Exception {
        var secretKeySpec = generateKey(key);
        var ivParameterSpec = new IvParameterSpec(iv);

        var cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        var encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(encrypted);
    }

    @Contract("_, _, _ -> new")
    public static @NotNull String decrypt(String key, byte[] iv, String ciphertext) throws Exception {
        var secretKeySpec = generateKey(key);
        var ivParameterSpec = new IvParameterSpec(iv);

        var cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        var decoded = Base64.getDecoder().decode(ciphertext);
        var decrypted = cipher.doFinal(decoded);

        return new String(decrypted, StandardCharsets.UTF_8);
    }


    @Contract("_ -> new")
    private static @NotNull SecretKeySpec generateKey(@NotNull String key) throws Exception {
        var keyBytes = key.getBytes(StandardCharsets.UTF_8);

        var sha = MessageDigest.getInstance(HASH_ALGORITHM);
        keyBytes = sha.digest(keyBytes);
        keyBytes = Arrays.copyOf(keyBytes, 16);

        return new SecretKeySpec(keyBytes, "AES");
    }


}

