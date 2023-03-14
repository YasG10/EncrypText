package Encrypt.Utilty;

import Encrypt.AES;
import Encrypt.UI.Ventana;
import io.github.cdimascio.dotenv.Dotenv;

public class Initializer {
    public static void init() {
        AES enc = new AES();
        Dotenv dotenv = Dotenv.load();
        var key = dotenv.get("key");
        var iv = IVGenerator.generateIV();

    }


}
