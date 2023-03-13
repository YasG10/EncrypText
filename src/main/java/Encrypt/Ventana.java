package Encrypt;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Ventana extends JFrame{

    private String texto;
    private String textoD;

    private JPanel Panel1;
    private JTextArea textA;
    private JTextArea textB;
    private JButton Encryptar;
    private JTextArea textC;
    private JTextArea textD;
    private JButton descrypt;

    public Ventana(){
        super("Encrypt");
        setContentPane(Panel1);
        Encryptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AES enc = new AES();
                texto = textA.getText();
                String key = "YasTick";
                byte [] iv = IVGenerator.generateIV();

                try {
                    if(texto.isEmpty()){
                        JOptionPane.showMessageDialog(null, "NO se puede encryptar algo vacio");
                    }
                    else{
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
                String key = "YasTick";
                byte [] iv = IVGenerator.generateIV();
                try {
                    String cifrar = enc.decrypt(key, iv, texto);
                    textD.setText(cifrar);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public JPanel getPanel1() {
        return Panel1;
    }

    public void setPanel1(JPanel panel1) {
        Panel1 = panel1;
    }

    public JTextArea getTextA() {
        return textA;
    }

    public void setTextA(JTextArea textA) {
        this.textA = textA;
    }

    public JTextArea getTextB() {
        return textB;
    }

    public void setTextB(JTextArea textB) {
        this.textB = textB;
    }

    public JButton getEncryptar() {
        return Encryptar;
    }

    public void setEncryptar(JButton encryptar) {
        Encryptar = encryptar;
    }
}
