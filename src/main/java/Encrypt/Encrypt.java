package Encrypt;
import Encrypt.Ventana;
import javax.swing.*;

public class Encrypt {

    public static String encriptar(String texto, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                if (Character.isUpperCase(caracter)) {
                    resultado += (char) (((int) caracter + desplazamiento - 65) % 26 + 65);
                } else {
                    resultado += (char) (((int) caracter + desplazamiento - 97) % 26 + 97);
                }
            } else {
                resultado += caracter;
            }
        }
        return resultado;
    }

    public static String desencriptar(String texto, int desplazamiento) {
        return encriptar(texto, 26 - desplazamiento);
    }

    public static void main(String[] args) {
        Ventana vent = new Ventana();



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Ventana();
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });
        /*
        String textoOriginal = vent.getTexto();
        int desplazamiento = 3;
        String textoEncriptado = encriptar(textoOriginal, desplazamiento);
        System.out.println("Texto encriptado: " + textoEncriptado);
        String textoDesencriptado = desencriptar(textoEncriptado, desplazamiento);
        System.out.println("Texto desencriptado: " + textoDesencriptado);

         */
    }
}
