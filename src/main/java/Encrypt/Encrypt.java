package Encrypt;
import Encrypt.UI.Ventana;
import javax.swing.*;

public class Encrypt {

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

    }
}
