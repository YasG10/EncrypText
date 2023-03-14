package Encrypt;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

@Getter
@Setter
public class Ventana extends JFrame {

    private String texto;
    private String textoD;

    private JPanel Panel1;
    private JTextArea textA;
    private JTextArea textB;
    private JButton Encryptar;
    private JTextArea textC;
    private JTextArea textD;
    private JButton descrypt;

    public Ventana() {
        super("Encrypt");
        setContentPane(Panel1);
        Encryptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AES enc = new AES();
                texto = textA.getText();
                String key = "YasTick";
                byte[] iv = IVGenerator.generateIV();

                try {
                    if (texto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NO se puede encryptar algo vacio");
                    } else {
                        String cifrar = enc.encrypt(key, iv, texto);
                        textB.setText(cifrar);
                    }

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        descrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AES enc = new AES();
                texto = textC.getText();
                // String key = "YasTick";
                Dotenv dotenv = Dotenv.load();
                var key = dotenv.get("key");

                byte[] iv = IVGenerator.generateIV();
                try {
                    String cifrar = enc.decrypt(key, iv, texto);
                    textD.setText(cifrar);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
