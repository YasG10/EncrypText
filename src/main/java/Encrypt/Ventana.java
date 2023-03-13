package Encrypt;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
                /*
                Encrypt enc = new Encrypt();

                texto = textA.getText();
                String textoOriginal = texto;
                int desplazamiento = 3;
                String textoEncriptado = enc.encriptar(textoOriginal, desplazamiento);
                System.out.println("Texto encriptado: " + textoEncriptado);
                textB.setText(textoEncriptado);
                String textoDesencriptado = enc.desencriptar(textoEncriptado, desplazamiento);
                System.out.println("Texto desencriptado: " + textoDesencriptado);

                 */
                AES enc = new AES();
                texto = textA.getText();
                String key = "YasTick";
                String iv =  "/gs8945}][@q24[#";
                try {
                    String cifrar = enc.encrypt(key, iv, texto);
                    textB.setText(cifrar);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        descrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                Encrypt enc1 = new Encrypt();
                textoD = textC.getText();
                int desplazamiento = 3;
                String textoDesencriptado = enc1.desencriptar(textoD, desplazamiento);
                textD.setText(textoDesencriptado);

                 */
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
